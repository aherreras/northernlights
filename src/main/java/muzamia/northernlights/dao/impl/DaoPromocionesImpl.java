/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import muzamia.northernlights.dao.DaoPromociones;
import muzamia.northernlights.dto.Promociones;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoPromocionesImpl implements DaoPromociones{

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoPromocionesImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }
    
    @Override
    public Double obtenerPrecio(Integer id) {
        Double precio = null;
        Promociones promociones = null;
        sql.append("SELECT ")
                .append("kitt_precio ")
                .append("FROM PROMOCIONES ")
                .append("WHERE kitt_id = ?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    promociones = new Promociones();

                    promociones.setProm_precio(rs.getDouble(1));

                    precio = promociones.getProm_precio();
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return precio;
    }
    
}
