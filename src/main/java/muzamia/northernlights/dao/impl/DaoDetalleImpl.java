/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import muzamia.northernlights.dao.DaoDetalle;
import muzamia.northernlights.dto.Categorias;
import muzamia.northernlights.dto.Detalle;
import muzamia.northernlights.dto.Facturas;
import muzamia.northernlights.dto.Servicios;
import muzamia.northernlights.dto.Productos;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoDetalleImpl implements DaoDetalle {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoDetalleImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> verDetalle(Integer id) {
        List<Object[]> list = new ArrayList<Object[]>();
        Detalle detalle = null;
        Servicios servicios = null;
        Categorias categorias = null;
        Productos productos = null;
        Object obj[];

        sql.append("SELECT ")
                .append("d.detf_id,")
                .append("d.fact_id,")
                .append("d.serv_id,")
                .append("s.serv_nombre,")
                .append("d.prod_id,")
                .append("p.prod_descripcion,")
                .append("c.cate_id,")
                .append("c.cate_descripcion,")
                .append("d.detf_precio,")
                .append("d.detf_cantidad,")
                .append("d.detf_subtotal,")
                .append("d.detf_descuento ")
                .append("FROM detalle_facturas d ")
                .append("INNER JOIN servicios s ")
                .append("ON d.serv_id = s.serv_id ")
                .append("INNER JOIN productos p ")
                .append("ON d.prod_id = p.prod_id ")
                .append("INNER JOIN categorias c ")
                .append("ON s.cate_id = c.cate_id ")
                .append("WHERE fact_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    servicios = new Servicios();
                    detalle = new Detalle();
                    categorias = new Categorias();
                    productos = new Productos();
                    obj = new Object[4];

                    detalle.setDetf_id(rs.getInt(1));
                    detalle.setFact_id(rs.getInt(2));
                    servicios.setServ_id(rs.getInt(3));
                    servicios.setServ_nombre(rs.getString(4));
                    productos.setProd_id(rs.getInt(5));
                    productos.setProd_descripcion(rs.getString(6));                    
                    categorias.setCate_id(rs.getInt(7));
                    categorias.setCate_descripcion(rs.getString(8));
                    detalle.setDetf_precio(rs.getDouble(9));
                    detalle.setDetf_cantidad(rs.getInt(10));
                    detalle.setDetf_subtotal(rs.getDouble(11));
                    detalle.setDetf_descuento(rs.getDouble(12));

                    obj[0] = detalle;
                    obj[1] = servicios;
                    obj[2] = categorias;
                    obj[3] = productos;

                    list.add(obj);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public String registrarDetalle(Detalle detalle) {
        String sp = "{call sp_InsertDetalle_Factura(?,?,?,?,?,?,?,?,?)}";
        Integer sid = detalle.getServ_id();
        Integer pid = detalle.getProd_id();
        
        try ( Connection cn = db.getConnection();
                CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, detalle.getFact_id());
            
            if (sid == null) {
                cs.setNull(2, Types.INTEGER);
                cs.setInt(3, pid);
            }
            else if (pid == null) {
                cs.setInt(2, sid);
                cs.setNull(3, Types.INTEGER);
            }
            
            cs.setString(4, detalle.getDetf_p_s());
            cs.setDouble(5, detalle.getDetf_precio());
            cs.setInt(6, detalle.getDetf_cantidad());
            cs.setDouble(7, detalle.getDetf_subtotal());
            cs.setDouble(8, detalle.getDetf_descuento());
            cs.setDouble(9, detalle.getDetf_total());

            int ctos = cs.executeUpdate();
            if (ctos == 0) {
                throw new SQLException("0 filas afectadas");
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }
}
