/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package muzamia.northernlights.web.servlet;

import jakarta.servlet.RequestDispatcher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.List;
import muzamia.northernlights.dao.DaoCaja;
import muzamia.northernlights.dao.DaoDashboard;
import muzamia.northernlights.dao.impl.DaoCajaImpl;
import muzamia.northernlights.dao.impl.DaoDashboardImpl;

/**
 *
 * @author User
 */
@WebServlet(name = "DashboardServlet", urlPatterns = {"/Dashboard"})
public class DashboardServlet extends HttpServlet {

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

        DaoDashboard daoDashboard = new DaoDashboardImpl();
        DaoCaja daoCaja = new DaoCajaImpl();

        switch (accion) {
            case "DASH":
                List<Object[]> list = daoDashboard.listarDashboard();
                Object[] objDash = new Object[5];
                int id_tipo = 0;
                boolean caja = false;
                String montoIngreso = "0.00";
                String montoGasto = "0.00";
                String montoCosto = "0.00";
                DecimalFormat df = new DecimalFormat("0.00");

                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        objDash = list.get(i);
                        caja = (boolean) objDash[5];
                        if (caja) {
                            id_tipo = Integer.parseInt(objDash[3].toString());
                            double auxMonto = Double.parseDouble(objDash[2].toString());

                            if (id_tipo == 1) {
                                montoIngreso = df.format(auxMonto);
                            } else if (id_tipo == 7) {
                                montoGasto = df.format(auxMonto);
                            } else if (id_tipo == 2) {
                                montoCosto = df.format(auxMonto);
                            }
                        }
                    }

                    request.setAttribute("ing", montoIngreso);
                    request.setAttribute("gas", montoGasto);
                    request.setAttribute("cos", montoCosto);
                }

                List<Object[]> listId = daoDashboard.getCajaId();
                Object[] objId = new Object[2];

                objId = listId.get(0);
                int cajaIdAct = Integer.parseInt(objId[0].toString());
                String cajaDesAct = objId[1].toString();

                objId = listId.get(1);
                int cajaIdPrv = Integer.parseInt(objId[0].toString());
                String cajaDesPrv = objId[1].toString();

                request.setAttribute("desAct", cajaDesAct);
                request.setAttribute("desPrv", cajaDesPrv);

                List<Object[]> list1 = daoDashboard.listarDashboardCl();
                Object[] objDashCl = new Object[4];
                caja = false;
                int cajaId = 0;

                int cnt_cliPrv = 0;
                int cnt_opePrv = 0;
                int cnt_cliAct = 0;
                int cnt_opeAct = 0;

                if (list1 != null) {
                    for (int i = 0; i < list1.size(); i++) {
                        objDashCl = list1.get(i);
                        cajaId = Integer.parseInt(objDashCl[0].toString());
                        if (cajaId == cajaIdPrv) {
                            cnt_cliPrv++;
                            cnt_opePrv += Integer.parseInt(objDashCl[2].toString());
                        } else if (cajaId == cajaIdAct) {
                            cnt_cliAct++;
                            cnt_opeAct += Integer.parseInt(objDashCl[2].toString());
                        }
                    }

                    request.setAttribute("cliPrv", cnt_cliPrv);
                    request.setAttribute("opePrv", cnt_opePrv);
                    request.setAttribute("cliAct", cnt_cliAct);
                    request.setAttribute("opeAct", cnt_opeAct);
                }

                target = "view/dash.jsp";
                break;

            case "DASH2":

                target = "view/db/dash2.jsp";
                break;

            case "DATA":
                List<Object[]> listCj = daoCaja.listarCajas();
                Object[] objCj = new Object[16];
                Integer cajaID = 0;
                String cajaDesc = "";
                StringBuilder d0 = new StringBuilder();
                if (listCj != null) {
                    d0.append("d0,");
                    for (int i = 0; i < listCj.size(); i++) {
                        objCj = listCj.get(i);

                        cajaID = Integer.parseInt(objCj[0].toString());
                        cajaDesc = objCj[1].toString();
                        d0.append(cajaID).append(",");
                        d0.append(cajaDesc).append(",");
                    }
                    if (d0.length() > 0) {
                        result = d0.substring(0, d0.length() - 1);
                    }
                }

                list = daoDashboard.listarDashboard();
                objDash = new Object[6];
                id_tipo = 0;
                double auxMonto = 0.0;
                Integer cajaIDaux = 1;
                String monto = "0.00";
                df = new DecimalFormat("0.00");
                StringBuilder d1 = new StringBuilder();
                StringBuilder d2 = new StringBuilder();
                StringBuilder d3 = new StringBuilder();
                StringBuilder d4 = new StringBuilder();
                StringBuilder d5 = new StringBuilder();
                StringBuilder d6 = new StringBuilder();

                Object[] objData = null;

                if (list != null) {
                    d1.append("d1,");
                    d2.append("d2,");
                    for (int i = 0; i < list.size(); i++) {
                        objDash = list.get(i);

                        cajaID = Integer.parseInt(objDash[0].toString());
                        cajaDesc = objDash[1].toString();
                        auxMonto = Double.parseDouble(objDash[2].toString());
                        id_tipo = Integer.parseInt(objDash[3].toString());

                        if (id_tipo == 1) {
                            d1.append(cajaID).append(",");
                            monto = df.format(auxMonto);
                            d1.append(monto).append(",");
                        } else if (id_tipo == 7 || id_tipo == 2 || id_tipo == 4) {
                            d2.append(cajaID).append(",");
                            monto = df.format(auxMonto);
                            d2.append(monto).append(",");
                        }
                    }
                    if (d1.length() > 0) {
                        result += "|";
                        result += d1.substring(0, d1.length() - 1);
                    }
                    if (d2.length() > 0) {
                        result += "|";
                        result += d2.substring(0, d2.length() - 1);
                    }
                }

                String srvName = "";
                Integer cnt = 0;
                List<Object[]> listSv = daoDashboard.listarDashboardSv();
                Object[] objSv = new Object[5];
                if (listSv != null) {
                    d3.append("d3,");
                    for (int i = 0; i < listSv.size(); i++) {
                        objSv = listSv.get(i);
                        auxMonto = 0.0;
                        srvName = objSv[2].toString();
                        cnt = Integer.parseInt(objSv[3].toString());
                        d3.append(srvName)
                                .append(",")
                                .append(cnt)
                                .append(",");
                    }
                    if (d3.length() > 0) {
                        result += "|";
                        result += d3.substring(0, d3.length() - 1);
                    }
                }

                List<Object[]> listMt = daoDashboard.listarDashboardMt();
                Object[] objMt = new Object[5];
                if (objMt != null) {
                    d4.append("d4,");
                    for (int i = 0; i < listMt.size(); i++) {
                        objMt = listMt.get(i);
                        auxMonto = 0.0;
                        srvName = objMt[2].toString();
                        cnt = Integer.parseInt(objMt[3].toString());
                        auxMonto = Double.parseDouble(objMt[4].toString());
                        monto = df.format(auxMonto);
                        d4.append(srvName)
                                .append(",")
                                .append(monto)
                                .append(",")
                                .append(cnt)
                                .append(",");
                    }
                    if (d4.length() > 0) {
                        result += "|";
                        result += d4.substring(0, d4.length() - 1);
                    }
                }
                /*
                List<Object[]> listPr = daoDashboard.listarDashboardPr();
                Object[] objPr = new Object[6];
                cajaID = null;
                Integer estilistaID = null;
                if (listPr != null) {
                    d4.append("d4,");
                    for (int i = 0; i < listPr.size(); i++) {
                        objPr = listPr.get(i);
                        auxMonto = 0.0;
                        cajaID = Integer.parseInt(objPr[0].toString());
                        estilistaID = Integer.parseInt(objPr[2].toString());
                        auxMonto = Double.parseDouble(objPr[4].toString());
                        monto = df.format(auxMonto);
                        d4.append(cajaID)
                                .append(",")
                                .append(estilistaID)
                                .append(",")
                                .append(monto)
                                .append(",");
                    }
                    if (d4.length() > 0) {
                        result += "|";
                        result += d4.substring(0, d4.length() - 1);
                    }
                }
                 */
                request.setAttribute("data", result);

//                int cajaIdAct = Integer.parseInt(objId[0].toString());
//                String cajaDesAct = objId[1].toString();
//
//                objId = listId.get(1);
//                int cajaIdPrv = Integer.parseInt(objId[0].toString());
//                String cajaDesPrv = objId[1].toString();
//
//                request.setAttribute(
//                        "desAct", cajaDesAct);
//                request.setAttribute(
//                        "desPrv", cajaDesPrv);
//
//                List<Object[]> list1 = daoDashboard.listarDashboardCl();
//                Object[] objDashCl = new Object[4];
//                caja = false;
//                int cajaId = 0;
//
//                int cnt_cliPrv = 0;
//                int cnt_opePrv = 0;
//                int cnt_cliAct = 0;
//                int cnt_opeAct = 0;
//
//                if (list1
//                        != null) {
//                    for (int i = 0; i < list1.size(); i++) {
//                        objDashCl = list1.get(i);
//                        cajaId = Integer.parseInt(objDashCl[0].toString());
//                        if (cajaId == cajaIdPrv) {
//                            cnt_cliPrv++;
//                            cnt_opePrv += Integer.parseInt(objDashCl[2].toString());
//                        } else if (cajaId == cajaIdAct) {
//                            cnt_cliAct++;
//                            cnt_opeAct += Integer.parseInt(objDashCl[2].toString());
//                        }
//                    }
//
//                    request.setAttribute("cliPrv", cnt_cliPrv);
//                    request.setAttribute("opePrv", cnt_opePrv);
//                    request.setAttribute("cliAct", cnt_cliAct);
//                    request.setAttribute("opeAct", cnt_opeAct);
//                }
//                target = "view/db/dash2.jsp";
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
