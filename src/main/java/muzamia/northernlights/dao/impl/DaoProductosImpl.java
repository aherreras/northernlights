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
import java.util.LinkedList;
import java.util.List;
import muzamia.northernlights.dao.DaoProductos;
import muzamia.northernlights.dto.Productos;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoProductosImpl implements DaoProductos{

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoProductosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }
    
    @Override
    public List<Productos> listarProductos(Integer categoria_id) {
        List<Productos> list = new ArrayList<Productos>();
        Productos productos = null;
        sql.append("SELECT ")
                .append("prod_id,")
                .append("prod_descripcion,")
                .append("prod_precio,")
                .append("prod_estado,")
                .append("cpro_id ")
                .append("FROM PRODUCTOS ")
                .append("WHERE cpro_id = ?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            
            ps.setInt(1, categoria_id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    productos = new Productos();
                    productos.setProd_id(rs.getInt(1));
                    productos.setProd_descripcion(rs.getString(2));
                    productos.setProd_precio(rs.getDouble(3));
                    productos.setProd_estado(rs.getBoolean(4));
                    productos.setCpro_id(rs.getInt(5));
                    
                    list.add(productos);
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
        Productos productos = null;
        sql.append("SELECT ")
                .append("prod_precio ")
                .append("FROM PRODUCTOS ")
                .append("WHERE prod_id = ?");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    productos = new Productos();

                    productos.setProd_precio(rs.getDouble(1));

                    precio = productos.getProd_precio();
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return precio;
    }

    @Override
    public List<Object[]> listaProductos() {
        List<Object[]> list = null;
        sql.append("SELECT ")
                .append("prod_id,")
                .append("prod_descripcion,")
                .append("prod_precio,")
                .append("prod_estado,")
                .append("cpro_id ")
                .append("FROM PRODUCTOS ")
                .append("WHERE prod_estado = true;");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            list = new LinkedList<>();
            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[3];

                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getDouble(3);
//                    reg[3] = rs.getBoolean(4);
//                    reg[4] = rs.getInt(5);

                    list.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }
        
        return list;
    }
    
}
