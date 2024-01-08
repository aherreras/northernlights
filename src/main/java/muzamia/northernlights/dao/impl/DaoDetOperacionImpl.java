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
import java.util.LinkedList;
import java.util.List;
import muzamia.northernlights.dao.DaoDetOperacion;
import muzamia.northernlights.dto.DetOperacion;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoDetOperacionImpl implements DaoDetOperacion {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoDetOperacionImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public String registrarDetOperacion(DetOperacion detOperacion) {
        String sp = "{call sp_InsertDet_Operacion(?,?,?,?,?,?,?,?,?,?)}";
        Integer eid = detOperacion.getUser_id();
        Integer sid = detOperacion.getServ_id();
        Integer pid = detOperacion.getProd_id();

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cs.setInt(1, detOperacion.getOper_id());

            if (eid == null) {
                cs.setNull(2, Types.INTEGER);
            } else {
                cs.setInt(2, eid);
            }

            if (sid == null) {
                cs.setNull(3, Types.INTEGER);
            } else {
                cs.setInt(3, sid);
            }

            if (pid == null) {
                cs.setNull(4, Types.INTEGER);
            } else {
                cs.setInt(4, pid);
            }

//            if (sid == null && pid != null) {
//                cs.setNull(2, Types.INTEGER);
//                cs.setInt(3, pid);
//            } else if (sid != null && pid == null) {
//                cs.setInt(2, sid);
//                cs.setNull(3, Types.INTEGER);
//            } else {
//                cs.setNull(2, Types.INTEGER);                
//                cs.setNull(3, Types.INTEGER);
//            }
            cs.setString(5, detOperacion.getDope_s_p());
            cs.setDouble(6, detOperacion.getDope_precio());
            cs.setInt(7, detOperacion.getDope_cantidad());
            cs.setDouble(8, detOperacion.getDope_subtotal());
            cs.setDouble(9, detOperacion.getDope_descuento());
            cs.setDouble(10, detOperacion.getDope_total());

            int ctos = cs.executeUpdate();
            if (ctos == 0) {
                throw new SQLException("0 filas afectadas");
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return message;
    }

    @Override
    public List<DetOperacion> getDetOperacion(int id) {
        List<DetOperacion> list = null;
        DetOperacion det = null;
        sql.append("SELECT ")
                .append("dope_id,")
                .append("oper_id,")
                .append("serv_id,")
                .append("prod_id,")
                .append("dope_s_p,")
                .append("dope_precio,")
                .append("dope_cantidad,")
                .append("dope_subtotal,")
                .append("dope_descuento,")
                .append("dope_total ")
                .append("FROM DET_OPERACION ")
                .append("WHERE oper_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    det = new DetOperacion();
                    det.setDope_id(rs.getInt(1));
                    det.setOper_id(rs.getInt(2));
                    det.setServ_id(rs.getInt(3));
                    det.setProd_id(rs.getInt(4));
                    det.setDope_s_p(rs.getString(5));
                    det.setDope_precio(rs.getDouble(6));
                    det.setDope_cantidad(rs.getInt(7));
                    det.setDope_subtotal(rs.getDouble(8));
                    det.setDope_descuento(rs.getDouble(9));
                    det.setDope_total(rs.getDouble(10));

                    list.add(det);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

}
