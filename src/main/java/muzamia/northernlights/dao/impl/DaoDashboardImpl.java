/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.LinkedList;
import java.util.List;
import muzamia.northernlights.dao.DaoDashboard;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoDashboardImpl implements DaoDashboard {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoDashboardImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> listarDashboard() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("c.caja_id,")
                .append("c.caja_descripcion,")
                .append("oper_monto,")
                .append("tope_id,")
                .append("tope_descripcion,")
                .append("c.caja_estado ")
                .append("FROM CAJA c ")
                .append("LEFT JOIN DASHBOARD_OP d ")
                .append("ON c.caja_id = d.caja_id;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[6];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getDouble(3);
                    reg[3] = rs.getInt(4);
                    if (rs.getString(5) == null) {
                        reg[4] = "";
                    } else {
                        reg[4] = rs.getString(5);
                    }
                    reg[5] = rs.getBoolean(6);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> listarDashboardCl() {
        List<Object[]> list = null;
        sql.delete(0, sql.length());
        sql.append("SELECT ")
                .append("caja_id,")
                .append("clie_id,")
                .append("cnt_oper,")
                .append("caja_estado ")
                .append("FROM DASHBOARD_CL;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[4];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getInt(2);
                    reg[2] = rs.getInt(3);
                    reg[3] = rs.getBoolean(4);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> getCajaId() {
        List<Object[]> list = null;
        sql.delete(0, sql.length());
        sql.append("SELECT ")
                .append("caja_id,")
                .append("caja_descripcion ")
                .append("FROM CAJA ")
                .append("ORDER BY caja_id DESC ")
                .append("LIMIT 2;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[2];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> listarDashboardPr() {
        List<Object[]> list = null;
        sql.delete(0, sql.length());
        sql.append("SELECT ")
                .append("caja_id,")
                .append("caja_descripcion,")
                .append("user_id,")
                .append("user_nombres,")
                .append("dope_total,")
                .append("caja_estado ")
                .append("FROM DASHBOARD_PR;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[6];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getInt(3);
                    reg[3] = rs.getString(4);
                    reg[4] = rs.getDouble(5);
                    reg[5] = rs.getBoolean(6);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> listarDashboardSv() {
        List<Object[]> list = null;
        sql.delete(0, sql.length());
        sql.append("SELECT ")
                .append("cate_id,")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("dope_cnt,")
                .append("dope_total ")
                .append("FROM DASHBOARD_SV ")
                .append("WHERE serv_id NOT IN (52) ")
                .append("ORDER BY dope_cnt DESC ")
                .append("LIMIT 10;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[5];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getInt(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getInt(4);
                    reg[4] = rs.getDouble(5);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> listarDashboardMt() {
        List<Object[]> list = null;
        sql.delete(0, sql.length());
        sql.append("SELECT ")
                .append("cate_id,")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("dope_cnt,")
                .append("dope_total ")
                .append("FROM DASHBOARD_SV ")
                .append("WHERE serv_id NOT IN (52) ")
                .append("ORDER BY dope_total DESC ")
                .append("LIMIT 10;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[5];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getInt(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getInt(4);
                    reg[4] = rs.getDouble(5);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
}
