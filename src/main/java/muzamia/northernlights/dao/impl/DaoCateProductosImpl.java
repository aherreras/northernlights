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
import java.util.List;
import muzamia.northernlights.dao.DaoCateProductos;
import muzamia.northernlights.dto.CateProductos;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoCateProductosImpl implements DaoCateProductos{

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoCateProductosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<CateProductos> listarCateProductos() {
        List<CateProductos> list= new ArrayList<CateProductos>();
        CateProductos cateProductos = null;
        sql.append("SELECT ")
                .append("cpro_id,")
                .append("cpro_descripcion ")
                .append("FROM CATEGORIA_PRODUCTOS ");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    cateProductos = new CateProductos();

                    cateProductos.setCpro_id(rs.getInt(1));
                    cateProductos.setCpro_descripcion(rs.getString(2));
                    
                    list.add(cateProductos);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }
    
}
