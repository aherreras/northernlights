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
import muzamia.northernlights.dao.DaoKitt;
import muzamia.northernlights.dto.Kitt;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoKittImpl implements DaoKitt{

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoKittImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Kitt> listarKitts() {
        List<Kitt> list= new ArrayList<Kitt>();
        Kitt kitt = null;
        sql.append("SELECT ")
                .append("kitt_id,")
                .append("kitt_descripcion,")
                .append("kitt_estado ")
                .append("FROM KITT ")
                .append("WHERE kitt_estado = 1");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    kitt = new Kitt();

                    kitt.setKitt_id(rs.getInt(1));
                    kitt.setKitt_descripcion(rs.getString(2));
                    kitt.setKitt_estado(rs.getBoolean(3));
                    
                    list.add(kitt);

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
        Kitt kitt = null;
        sql.append("SELECT ")
                .append("kitt_precio ")
                .append("FROM KITT ")
                .append("WHERE kitt_id = ?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    kitt = new Kitt();

                    kitt.setKitt_precio(rs.getDouble(1));

                    precio = kitt.getKitt_precio();
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return precio;
    }
    
}
