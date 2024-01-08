/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLType;
import java.sql.Types;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import muzamia.northernlights.dao.DaoOperacion;
import muzamia.northernlights.dto.Operacion;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoOperacionImpl implements DaoOperacion {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoOperacionImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public Integer registrarOperacion(Operacion operacion) {
        String sp = "{?= call fn_InsertOperacion(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
        Integer id = null;

        try ( Connection cn = db.getConnection();  CallableStatement cs = cn.prepareCall(sp)) {

            cn.setAutoCommit(false);

            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(2, operacion.getTope_id());
            cs.setInt(3, operacion.getMpag_id());
            cs.setInt(4, operacion.getCaja_id());
            cs.setInt(5, operacion.getUser_id());
            if (operacion.getClie_id() != null) {
                cs.setInt(6, operacion.getClie_id());
            } else {
                cs.setNull(6, Types.NULL);
            }
            if (operacion.getProv_id() != null) {
                cs.setInt(7, operacion.getProv_id());
            } else {
                cs.setNull(7, Types.NULL);
            }
            cs.setString(8, operacion.getOper_timestamp());
            cs.setDouble(9, operacion.getOper_monto());
            cs.setDouble(10, operacion.getOper_pagado());
            cs.setDouble(11, operacion.getOper_vuelto());
            cs.setDouble(12, operacion.getOper_cobrado());
            cs.setDouble(13, operacion.getOper_saldo());

            Date date1 = Date.valueOf(operacion.getOper_fecha());
            cs.setDate(14, date1);

            cs.execute();
            id = cs.getInt(1);

            if (id == null) {
                cn.rollback();
            } else {
                cn.commit();
            }

            cn.setAutoCommit(true);

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return id;
    }

    @Override
    public List<Object[]> listarOperaciones() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("oper_id,")
                .append("t.tope_id,")
                .append("tope_descripcion,")
                .append("m.mpag_id,")
                .append("mpag_descripcion,")
                .append("c.clie_id,")
                .append("clie_nombres,")
                .append("p.prov_id,")
                .append("prov_razon_social,")
                .append("oper_timestamp,")
                .append("oper_monto,")
                .append("oper_pagado,")
                .append("oper_vuelto,")
                .append("oper_cobrado,")
                .append("oper_saldo,")
                .append("oper_fecha ")
                .append("FROM OPERACION o ")
                .append("INNER JOIN TIPO_OPERACION t ")
                .append("ON o.tope_id = t.tope_id ")
                .append("INNER JOIN METODO_PAGO m ")
                .append("ON o.mpag_id = m.mpag_id ")
                .append("LEFT JOIN CLIENTES c ")
                .append("ON o.clie_id = c.clie_id ")
                .append("LEFT JOIN PROVEEDORES p ")
                .append("ON o.prov_id = p.prov_id ")
                .append("INNER JOIN CAJA x ")
                .append("ON o.caja_id = x.caja_id ")
                .append("WHERE caja_estado = true ")
                .append("ORDER BY oper_fecha ASC");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[16];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getInt(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getInt(4);
                    reg[4] = rs.getString(5);
                    reg[5] = rs.getInt(6);
                    reg[6] = rs.getString(7);
                    reg[7] = rs.getInt(8);
                    reg[8] = rs.getString(9);
                    reg[9] = rs.getString(10);
                    reg[10] = rs.getDouble(11);
                    reg[11] = rs.getDouble(12);
                    reg[12] = rs.getDouble(13);
                    reg[13] = rs.getDouble(14);
                    reg[14] = rs.getDouble(15);
                    reg[15] = rs.getString(16);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public Object[] getOperacion1(int id) {
        Object[] obj = null;
        sql.append("SELECT ")
                .append("oper_id,")
                .append("o.tope_id,")
                .append("tope_descripcion,")
                .append("o.mpag_id,")
                .append("mpag_descripcion,")
                .append("caja_id,")
                .append("o.clie_id,")
                .append("clie_nombres,")
                .append("o.user_id,")
                .append("user_nombres,")
                .append("prov_id,")
                .append("oper_timestamp,")
                .append("oper_monto,")
                .append("oper_pagado,")
                .append("oper_vuelto,")
                .append("oper_cobrado,")
                .append("oper_saldo,")
                .append("oper_fecha ")
                .append("FROM OPERACION o ")
                .append("INNER JOIN TIPO_OPERACION t ")
                .append("ON o.tope_id = t.tope_id ")
                .append("INNER JOIN METODO_PAGO m ")
                .append("ON o.mpag_id = m.mpag_id ")
                .append("INNER JOIN CLIENTES c ")
                .append("ON o.clie_id = c.clie_id ")
                .append("INNER JOIN USUARIOS u ")
                .append("ON o.user_id = u.user_id ")
                .append("WHERE oper_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new Object[18];

                    obj[0] = rs.getInt(1);
                    obj[1] = rs.getInt(2);
                    obj[2] = rs.getString(3);
                    obj[3] = rs.getInt(4);
                    obj[4] = rs.getString(5);
                    obj[5] = rs.getInt(6);
                    obj[6] = rs.getInt(7);
                    obj[7] = rs.getString(8);
                    obj[8] = rs.getInt(9);
                    obj[9] = rs.getString(10);
                    obj[10] = rs.getInt(11);
                    obj[11] = rs.getString(12);
                    obj[12] = rs.getDouble(13);
                    obj[13] = rs.getDouble(14);
                    obj[14] = rs.getDouble(15);
                    obj[15] = rs.getDouble(16);
                    obj[16] = rs.getDouble(17);
                    obj[17] = rs.getString(18);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return obj;
    }

    @Override
    public Object[] getOperacion2_4(int id) {
        Object[] obj = null;
        sql.append("SELECT ")
                .append("oper_id,")
                .append("o.tope_id,")
                .append("tope_descripcion,")
                .append("o.mpag_id,")
                .append("mpag_descripcion,")
                .append("caja_id,")
                .append("clie_id,")
                .append("NULL,")
                .append("prov_id,")
                .append("oper_timestamp,")
                .append("oper_monto,")
                .append("oper_pagado,")
                .append("oper_vuelto,")
                .append("oper_cobrado,")
                .append("oper_saldo,")
                .append("oper_fecha ")
                .append("FROM OPERACION o ")
                .append("INNER JOIN TIPO_OPERACION t ")
                .append("ON o.tope_id = t.tope_id ")
                .append("INNER JOIN METODO_PAGO m ")
                .append("ON o.mpag_id = m.mpag_id ")
                .append("WHERE oper_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new Object[16];

                    obj[0] = rs.getInt(1);
                    obj[1] = rs.getInt(2);
                    obj[2] = rs.getString(3);
                    obj[3] = rs.getInt(4);
                    obj[4] = rs.getString(5);
                    obj[5] = rs.getInt(6);
                    obj[6] = rs.getInt(7);
                    obj[7] = rs.getString(8);
                    obj[8] = rs.getInt(9);
                    obj[9] = rs.getString(10);
                    obj[10] = rs.getDouble(11);
                    obj[11] = rs.getDouble(12);
                    obj[12] = rs.getDouble(13);
                    obj[13] = rs.getDouble(14);
                    obj[14] = rs.getDouble(15);
                    obj[15] = rs.getString(16);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return obj;
    }

}
