/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import muzamia.northernlights.dao.DaoCaja;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoCajaImpl implements DaoCaja{

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;
    
    public DaoCajaImpl () {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> listarCajas() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("caja_id,")
                .append("caja_descripcion,")
                .append("caja_total_cierre,")
                .append("caja_saldo_anterior,")
                .append("caja_total_cobrado,")
                .append("caja_total_gasto,")
                .append("caja_total_retirado,")
                .append("caja_total_ingresado,")
                .append("caja_fecha_ini,")
                .append("caja_fecha_fin,")
                .append("caja_estado ")
                .append("FROM CAJA ")
                .append("ORDER BY caja_id ASC");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[16];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getDouble(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getDouble(5);
                    reg[5] = rs.getDouble(6);
                    reg[6] = rs.getDouble(7);
                    reg[7] = rs.getDouble(8);
                    reg[8] = rs.getString(9);
                    reg[9] = rs.getString(10);
                    reg[10] = rs.getBoolean(11);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
}
