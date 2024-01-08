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
import muzamia.northernlights.dao.DaoUsuarios;
import muzamia.northernlights.dto.Usuarios;
import muzamia.northernlights.sql.ConectaDb;

/**
 *
 * @author User
 */
public class DaoUsuariosImpl implements DaoUsuarios {

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoUsuariosImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public Usuarios getUsuario(String cod) {
        Usuarios usuarios = new Usuarios();
        sql.append("SELECT ")
                .append("user_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("user_codigo,")
                .append("user_fecha_nacimiento,")
                .append("user_dni,")
                .append("tsue_id,")
                .append("user_sueldo,")
                .append("user_estado,")
                .append("user_fecha_ingreso,")
                .append("user_fecha_salida,")
                .append("user_rol ")
                .append("FROM USUARIOS ")
                .append("WHERE user_codigo = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setString(1, cod);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    usuarios.setUser_id(rs.getInt(1));
                    usuarios.setUser_nombres(rs.getString(2));
                    usuarios.setUser_apellidos(rs.getString(3));
                    usuarios.setUser_codigo(rs.getString(4));
                    usuarios.setUser_fecha_nacimiento(rs.getString(5));
                    usuarios.setUser_dni(rs.getInt(6));
                    usuarios.setTsue_id(rs.getInt(7));
                    usuarios.setUser_sueldo(rs.getDouble(8));
                    usuarios.setUser_estado(rs.getBoolean(9));
                    usuarios.setUser_fecha_ingreso(rs.getString(10));
                    usuarios.setUser_fecha_salida(rs.getString(11));
                    usuarios.setUser_rol(rs.getString(12));
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return usuarios;
    }

    @Override
    public Integer getID(String cod) {
        Integer id = null;
        sql.append("SELECT ")
                .append("user_id ")
                .append("FROM USUARIOS ")
                .append("WHERE user_codigo = ?");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            ps.setString(1, cod);

            try ( ResultSet rs = ps.executeQuery()) {
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
    public List<Object[]> Listar_Usuarios() {
        List<Object[]> lstUser = null;
        sql.append("SELECT ")
                .append("user_id,")
                .append("user_nombres,")
                .append("user_apellidos,")
                .append("user_codigo,")
                .append("user_fecha_nacimiento,")
                .append("user_dni,")
                .append("tsue_id,")
                .append("user_sueldo,")
                .append("user_estado,")
                .append("user_fecha_ingreso,")
                .append("user_fecha_salida,")
                .append("user_rol ")
                .append("FROM USUARIOS");

        try ( Connection cn = db.getConnection();  PreparedStatement ps = cn.prepareStatement(sql.toString())) {
            lstUser = new LinkedList<>();

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object[] reg = new Object[16];
                    reg[0] = rs.getInt(1);
                    reg[1] = rs.getString(2);
                    reg[2] = rs.getString(3);
                    reg[3] = rs.getString(4);
                    reg[4] = rs.getString(5);
                    reg[5] = rs.getInt(6);
                    reg[6] = rs.getInt(7);
                    reg[7] = rs.getDouble(8);
                    reg[8] = rs.getBoolean(9);
                    reg[9] = rs.getString(10);
                    reg[10] = rs.getString(11);
                    reg[11] = rs.getString(12);
                    
                    lstUser.add(reg);
                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return lstUser;
    }

}
