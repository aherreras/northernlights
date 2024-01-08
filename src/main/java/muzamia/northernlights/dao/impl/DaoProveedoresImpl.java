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
import muzamia.northernlights.dao.DaoProveedores;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoProveedoresImpl implements DaoProveedores {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoProveedoresImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> listaProveedores() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("prov_id,")
                .append("prov_razon_social,")
                .append("prov_ruc,")
                .append("prov_estado ")
                .append("FROM PROVEEDORES ")
                .append("WHERE prov_estado = true;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[2];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
//                    reg[2] = rs.getString(3);
//                    reg[3] = rs.getBoolean(4);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return list;
    }
    
}
