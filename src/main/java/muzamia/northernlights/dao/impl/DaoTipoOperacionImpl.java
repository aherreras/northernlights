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
import muzamia.northernlights.dao.DaoTipoOperacion;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoTipoOperacionImpl implements DaoTipoOperacion {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoTipoOperacionImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Object[]> listaTiposOperacion() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("tope_id,")
                .append("tope_descripcion ")
                .append("FROM TIPO_OPERACION");

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
    
}
