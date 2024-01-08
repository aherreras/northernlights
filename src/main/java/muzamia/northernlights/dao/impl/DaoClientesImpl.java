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
import muzamia.northernlights.dao.DaoClientes;
import muzamia.northernlights.dto.Clientes;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoClientesImpl implements DaoClientes {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoClientesImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }
    
    @Override
    public Clientes getCliente(Integer dni) {
        Clientes clientes = new Clientes();;
        sql.append("SELECT ")
                .append("clie_id,")
                .append("clie_nombres,")
                .append("clie_apellidos,")
                .append("clie_dni,")
                .append("clie_estado ")
                .append("FROM CLIENTES ")
                .append("WHERE clie_dni = ?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            
            ps.setInt(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    clientes.setClie_id(rs.getInt(1));
                    clientes.setClie_nombres(rs.getString(2));
                    clientes.setClie_apellidos(rs.getString(3));
                    clientes.setClie_dni(rs.getInt(4));
                    clientes.setClie_estado(rs.getBoolean(5));
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return clientes;
    }

    @Override
    public Integer getID(Integer dni) {
        Integer id = null;
        sql.append("SELECT ")
                .append("clie_id ")
                .append("FROM CLIENTES ")
                .append("WHERE clie_dni = ?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            
            ps.setInt(1, dni);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getInt(1);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return id;
    }

    @Override
    public List<Object[]> listaClientes() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("clie_id,")
                .append("clie_nombres,")
                .append("clie_apellidos,")
                .append("clie_dni,")
                .append("clie_estado ")
                .append("FROM CLIENTES ")
                .append("WHERE clie_estado = true;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[2];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
//                    reg[2] = rs.getString(3);
//                    reg[3] = rs.getInt(4);
//                    reg[4] = rs.getBoolean(5);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return list;
    }
    
}
