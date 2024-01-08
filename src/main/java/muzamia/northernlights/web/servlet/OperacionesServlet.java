/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package muzamia.northernlights.web.servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.ArrayList;
import muzamia.northernlights.dao.DaoCaja;
import muzamia.northernlights.dao.DaoCategorias;
import muzamia.northernlights.dao.DaoClientes;
import muzamia.northernlights.dao.DaoDetOperacion;
import muzamia.northernlights.dao.DaoMetodoPago;
import muzamia.northernlights.dao.DaoOperacion;
import muzamia.northernlights.dao.DaoProductos;
import muzamia.northernlights.dao.DaoProveedores;
import muzamia.northernlights.dao.DaoServicios;
import muzamia.northernlights.dao.DaoTipoOperacion;
import muzamia.northernlights.dao.DaoUsuarios;
import muzamia.northernlights.dao.impl.DaoCajaImpl;
import muzamia.northernlights.dao.impl.DaoCategoriasImpl;
import muzamia.northernlights.dao.impl.DaoClientesImpl;
import muzamia.northernlights.dao.impl.DaoDetOperacionImpl;
import muzamia.northernlights.dao.impl.DaoMetodoPagoImpl;
import muzamia.northernlights.dao.impl.DaoOperacionImpl;
import muzamia.northernlights.dao.impl.DaoProductosImpl;
import muzamia.northernlights.dao.impl.DaoProveedoresImpl;
import muzamia.northernlights.dao.impl.DaoServiciosImpl;
import muzamia.northernlights.dao.impl.DaoTipoOperacionImpl;
import muzamia.northernlights.dao.impl.DaoUsuariosImpl;
import muzamia.northernlights.dto.DetOperacion;
import muzamia.northernlights.dto.Operacion;
import muzamia.northernlights.dto.Categorias;
import muzamia.northernlights.dto.Servicios;
import muzamia.northernlights.dto.Usuarios;
import parainfo.convert.DeString;

/**
 *
 * @author User
 */
@WebServlet(name = "OperacionesServlet", urlPatterns = "/Operaciones")
public class OperacionesServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("accion");
        accion = (accion == null) ? "" : accion;
        String result = null;
        String target = null;

        DaoOperacion daoOperacion = new DaoOperacionImpl();
        DaoDetOperacion daoDetOperacion = new DaoDetOperacionImpl();
        DaoServicios daoServicios = new DaoServiciosImpl();
        DaoCategorias daoCategorias = new DaoCategoriasImpl();
        DaoTipoOperacion daoTipoOperacion = new DaoTipoOperacionImpl();
        DaoMetodoPago daoMetodoPago = new DaoMetodoPagoImpl();
        DaoClientes daoClientes = new DaoClientesImpl();
        DaoProveedores daoProveedores = new DaoProveedoresImpl();
        DaoProductos daoProductos = new DaoProductosImpl();
        DaoUsuarios daoUsuarios = new DaoUsuariosImpl();
        DaoCaja daoCaja = new DaoCajaImpl();

        switch (accion) {
            case "LST":
                //Lista operaciones
                List<Object[]> list1 = daoOperacion.listarOperaciones();
                if (list1 != null) {
                    request.setAttribute("list1", list1);
                }

                target = "view/operaciones.jsp";
                break;

            case "LSTCAT":
//                Lista Categorias
//                List<Object[]> listCat = daoCategorias.listarCategorias();
//                if (listCat != null) {
//                    request.setAttribute("listCat", listCat);
//                }

                List<Object[]> listSrv = daoServicios.listarServicios2();
//                Object[] objCat = new Object[2];
//                Object[] objSrv = new Object[5];
//                Categorias cat = null;
//                Servicios srv = null;
//                int id;
//                for (int i = 0; i < listCat.size(); i++) {
//                    objCat = listCat.get(i);
//                    id = Integer.parseInt(objCat[0].toString());
//
//                    objSrv = daoServicios.obtieneServicio(id);
//                    listSrv.add(objSrv);

                if (listSrv != null) {
                    request.setAttribute("listSrv", listSrv);
                }

                target = "view/catalogo/catalogoLst.jsp";
                break;

            case "GET_PRECIO":
                Integer serv = Integer.parseInt(request.getParameter("servicio"));
                Double p = daoServicios.obtenerPrecio(serv);

                result = p + "";
                break;

            case "GET_SRV":
                Integer cate = Integer.parseInt(request.getParameter("categoria"));
                listSrv = daoServicios.listarServicios(cate);
                if (listSrv != null) {
                    StringBuilder sb = new StringBuilder();
                    for (Object[] objSrv : listSrv) {
                        sb.append(Integer.parseInt(objSrv[0].toString()))
                                .append(",")
                                .append(objSrv[1].toString())
                                .append("|");
                    }

                    if (sb.length() > 0) {
                        result = sb.substring(0, sb.length() - 1);
                    }
                }
                break;

            case "LST_ADD":
                //Lista Tipos de operaciones
                List<Object[]> list2 = daoTipoOperacion.listaTiposOperacion();
                if (list2 != null) {
                    request.setAttribute("list2", list2);
                }

                // Lista servicios
                List<Object[]> list3 = daoServicios.listarServicios();
                if (list3 != null) {
                    request.setAttribute("list3", list3);
                }

                //Lista Métodos de Pago
                List<Object[]> list4 = daoMetodoPago.listaMetodosPago();

                if (list4 != null) {
                    request.setAttribute("list4", list4);
                }

                //Lista Clientes
                List<Object[]> list5 = daoClientes.listaClientes();

                if (list5 != null) {
                    request.setAttribute("list5", list5);
                }

                //Lista Clientes
                List<Object[]> list6 = daoProveedores.listaProveedores();

                if (list6 != null) {
                    request.setAttribute("list6", list6);
                }

                //Lista Productos
                List<Object[]> list7 = daoProductos.listaProductos();

                if (list7 != null) {
                    request.setAttribute("list7", list7);
                }

                //Lista Usuarios
                List<Object[]> lstUser = daoUsuarios.Listar_Usuarios();

                if (lstUser != null) {
                    request.setAttribute("lstUser", lstUser);
                }

                //Lista Caja
                List<Object[]> lstCaja = daoCaja.listarCajas();

                if (lstCaja != null) {
                    request.setAttribute("lstCaja", lstCaja);
                }

                //Lista Categorias
                List<Object[]> listCat = daoCategorias.listarCategorias();

                if (listCat != null) {
                    request.setAttribute("listCat", listCat);
                }

                target = "view/ins/operacionIns.jsp";
                break;

            case "ADD":
                Operacion operacionBE = new Operacion();
                DetOperacion detOperacionBE = null;

                Integer tipooper = Integer.parseInt(request.getParameter("tipooper"));
                Integer cliente = Integer.parseInt(request.getParameter("cliente"));
                Integer proveedor = Integer.parseInt(request.getParameter("proveedor"));
                Integer metpago = Integer.parseInt(request.getParameter("metpago"));

// operacion
                Integer caja = Integer.parseInt(request.getParameter("caja"));
                Integer user = Integer.parseInt(request.getParameter("usuario"));
                Double montoope = Double.parseDouble(request.getParameter("montoope"));
                Double pagado = Double.parseDouble(request.getParameter("pagado"));
                Double vuelto = Double.parseDouble(request.getParameter("vuelto"));
                Double cobrado = Double.parseDouble(request.getParameter("cobrado"));
                Double saldo = Double.parseDouble(request.getParameter("saldo"));
                String fecha = request.getParameter("fecha");

                Timestamp timestamp = new Timestamp(System.currentTimeMillis());

                operacionBE.setTope_id(tipooper);
                operacionBE.setMpag_id(metpago);
                operacionBE.setCaja_id(caja);
                operacionBE.setUser_id(user);
                switch (tipooper) {
                    case 1:
                    case 5:
                        operacionBE.setClie_id(cliente);
                        operacionBE.setProv_id(null);
                        break;
                    case 2:
                    case 4:
                    case 7:
                        operacionBE.setClie_id(null);
                        operacionBE.setProv_id(null);
                        break;
                }
                operacionBE.setOper_timestamp(timestamp.toString());
                operacionBE.setOper_monto(montoope);
                operacionBE.setOper_pagado(pagado);
                operacionBE.setOper_vuelto(vuelto);
                operacionBE.setOper_cobrado(cobrado);
                operacionBE.setOper_saldo(saldo);
                operacionBE.setOper_fecha(fecha);

                Integer idOpe = daoOperacion.registrarOperacion(operacionBE);

// detalle
                List<Integer> ide = DeString.ids(request.getParameter("ide"));
                List<Integer> ids = DeString.ids(request.getParameter("ids"));
                List<String> srv = DeString.str(request.getParameter("srv"));
                List<Double> prc = DeString.dbl(request.getParameter("prc"));
                List<Integer> cnt = DeString.ids(request.getParameter("cnt"));
                List<Double> st = DeString.dbl(request.getParameter("st"));
                List<Double> des = DeString.dbl(request.getParameter("des"));
                List<Double> tt = DeString.dbl(request.getParameter("tt"));

                int idx = 0;

                switch (tipooper) {
                    case 1:
                        for (Integer id : ids) {
                            detOperacionBE = new DetOperacion();
                            detOperacionBE.setOper_id(idOpe);
                            //
                            detOperacionBE.setUser_id(Integer.parseInt(ide.get(idx).toString()));
                            detOperacionBE.setServ_id(id);
                            detOperacionBE.setProd_id(null);
                            //
                            detOperacionBE.setDope_s_p(srv.get(idx));
                            detOperacionBE.setDope_precio(Double.parseDouble(prc.get(idx).toString()));
                            detOperacionBE.setDope_cantidad(cnt.get(idx));
                            detOperacionBE.setDope_subtotal(Double.parseDouble(st.get(idx).toString()));
                            detOperacionBE.setDope_descuento(Double.parseDouble(des.get(idx).toString()));
                            detOperacionBE.setDope_total(Double.parseDouble(tt.get(idx).toString()));
                            daoDetOperacion.registrarDetOperacion(detOperacionBE);
                            idx++;
                        }
                        break;
                    case 5:
                        for (Integer id : ids) {
                            detOperacionBE = new DetOperacion();
                            detOperacionBE.setOper_id(idOpe);
                            //
                            detOperacionBE.setUser_id(Integer.parseInt(ide.get(idx).toString()));
                            detOperacionBE.setServ_id(null);
                            detOperacionBE.setProd_id(null);
                            //
                            detOperacionBE.setDope_s_p(srv.get(idx));
                            detOperacionBE.setDope_precio(Double.parseDouble(prc.get(idx).toString()));
                            detOperacionBE.setDope_cantidad(cnt.get(idx));
                            detOperacionBE.setDope_subtotal(Double.parseDouble(st.get(idx).toString()));
                            detOperacionBE.setDope_descuento(Double.parseDouble(des.get(idx).toString()));
                            detOperacionBE.setDope_total(Double.parseDouble(tt.get(idx).toString()));
                            daoDetOperacion.registrarDetOperacion(detOperacionBE);
                            idx++;
                        }
                        break;
                    case 2:
                    case 4:
                    case 7:
                        for (Integer id : ids) {
                            detOperacionBE = new DetOperacion();
                            detOperacionBE.setOper_id(idOpe);
                            //
                            detOperacionBE.setUser_id(Integer.parseInt(ide.get(idx).toString()));
                            detOperacionBE.setServ_id(null);
                            detOperacionBE.setProd_id(null);
                            //
                            detOperacionBE.setDope_s_p(srv.get(idx));
                            detOperacionBE.setDope_precio(Double.parseDouble(prc.get(idx).toString()));
                            detOperacionBE.setDope_cantidad(cnt.get(idx));
                            detOperacionBE.setDope_subtotal(Double.parseDouble(st.get(idx).toString()));
                            detOperacionBE.setDope_descuento(Double.parseDouble(des.get(idx).toString()));
                            detOperacionBE.setDope_total(Double.parseDouble(tt.get(idx).toString()));
                            daoDetOperacion.registrarDetOperacion(detOperacionBE);
                            idx++;
                        }
                        break;
                }
                break;

            case "DET":
                //Lista operaciones
                Integer ope_id = Integer.parseInt(request.getParameter("id"));
                Integer tipo_ope_id = Integer.parseInt(request.getParameter("tid"));
                StringBuilder sb = new StringBuilder();
                Object[] objOperacion = null;

                if (tipo_ope_id == 1) {
                    objOperacion = daoOperacion.getOperacion1(ope_id);
                } else if (tipo_ope_id == 2 || tipo_ope_id == 4 || tipo_ope_id == 5 || tipo_ope_id == 7) {
                    objOperacion = daoOperacion.getOperacion2_4(ope_id);
                }

                if (objOperacion != null) {
                    sb.append("<tr>").append("<th>ID</th>").append("<td>").append(objOperacion[0]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Tipo Operación</th>").append("<td>").append(objOperacion[2]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Medio de Pago</th>").append("<td>").append(objOperacion[4]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Caja</th>").append("<td>").append(objOperacion[5]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Usuario</th>").append("<td>").append(objOperacion[9]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Cliente</th>").append("<td>").append(objOperacion[7]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Fecha y Hora del Sistema</th>").append("<td>").append(objOperacion[11]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Monto Operación</th>").append("<td>").append(objOperacion[12]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Monto Pagado</th>").append("<td>").append(objOperacion[13]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Vuelto</th>").append("<td>").append(objOperacion[14]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Monto Cobrado</th>").append("<td>").append(objOperacion[15]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Saldo</th>").append("<td>").append(objOperacion[16]).append("</td>").append("</tr>")
                            .append("<tr>").append("<th>Fecha Operación</th>").append("<td>").append(objOperacion[17]).append("</td>").append("</tr>")
                            .append(";");
                }

                List<DetOperacion> lstDetalle = daoDetOperacion.getDetOperacion(ope_id);
                Double tot = 0.0;

                if (lstDetalle != null) {
                    for (DetOperacion det : lstDetalle) {
                        sb.append("<tr>")
                                .append("<td hidden='true'>").append(det.getDope_id()).append("</td>")
                                .append("<td>").append(det.getDope_s_p()).append("</td>")
                                .append("<td>").append(det.getDope_precio()).append("</td>")
                                .append("<td>").append(det.getDope_cantidad()).append("</td>")
                                .append("<td>").append(det.getDope_subtotal()).append("</td>")
                                .append("<td>").append(det.getDope_descuento()).append("</td>")
                                .append("<td>").append(det.getDope_total()).append("</td>")
                                .append("</tr>");
                        tot += det.getDope_total();
                    }
                }
                sb.append(";").append(tot);

                result = sb.toString();
                break;

            case "UPD":
                //Lista operaciones
                List<Object[]> listUpd = daoOperacion.listarOperaciones();
                if (listUpd != null) {
                    request.setAttribute("listUpd", listUpd);
                }

                target = "view/operacionesIns.jsp";
                break;
        }

        if (target
                == null) {
            response.setContentType("text/html;charset=UTF-8");
            try ( PrintWriter out = response.getWriter()) {
                if (result == null) {
                    result = "";
                }
                out.print(result);
            }
        } else {
            RequestDispatcher dispatcher
                    = request.getRequestDispatcher(target);
            dispatcher.forward(request, response);
        }
    }

// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
