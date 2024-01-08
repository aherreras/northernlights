/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import muzamia.northernlights.dao.DaoServicios;
import muzamia.northernlights.dto.Categorias;
import muzamia.northernlights.dto.Servicios;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoServiciosImpl implements DaoServicios {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoServiciosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> listarServicios(Integer id) {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio,")
                .append("s.cate_id,")
                .append("cate_descripcion ")
                .append("FROM SERVICIOS s ")
                .append("INNER JOIN CATEGORIAS c ")
                .append("ON s.cate_id = c.cate_id ")
                .append("WHERE s.cate_id = ? ")
                .append("ORDER BY serv_nombre ASC ");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[6];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getInt(5);
                    reg[5] = rs.getString(6);
                    
                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> listarServicios() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio,")
                .append("cate_id ")
                .append("FROM SERVICIOS");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[5];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getInt(5);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public List<Object[]> listarServicios2() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("serv_id,")
                .append("serv_nombre,")
                .append("serv_descripcion,")
                .append("serv_precio,")
                .append("s.cate_id,")
                .append("cate_descripcion ")
                .append("FROM SERVICIOS s ")
                .append("INNER JOIN CATEGORIAS c ")
                .append("ON s.cate_id = c.cate_id;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[6];
                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getDouble(4);
                    reg[4] = rs.getInt(5);
                    reg[5] = rs.getString(6);
                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public Double obtenerPrecio(Integer id) {
        Double precio = null;
        Servicios servicios = null;
        sql.append("SELECT ")
                .append("serv_precio ")
                .append("FROM SERVICIOS ")
                .append("WHERE serv_id = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setInt(1, id);

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    servicios = new Servicios();

                    servicios.setServ_precio(rs.getDouble(1));

                    precio = servicios.getServ_precio();
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return precio;
    }
}
