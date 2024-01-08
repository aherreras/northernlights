/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;
import java.sql.Types;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import muzamia.northernlights.dao.DaoFacturas;
import muzamia.northernlights.dto.Detalle;
import muzamia.northernlights.dto.Facturas;
import muzamia.northernlights.sql.ConectaDb;
/**
 *
 * @author User
 */
public class DaoFacturasImpl implements DaoFacturas{

    private final ConectaDb db;
    private final StringBuilder sql;
    private String message;

    public DaoFacturasImpl() {
        db = new ConectaDb();
        this.sql = new StringBuilder();
    }

    @Override
    public List<Facturas> listarFacturas() {
        List<Facturas> list= new ArrayList<Facturas>();
        Facturas facturas = null;
        sql.append("SELECT ")
                .append("fact_id,")
                .append("fact_fecha,")
                .append("fact_hora,")
                .append("fact_estilista,")
                .append("fact_cliente,")
                .append("mpag_id,")
                .append("fact_metodo_pago,")
                .append("fact_subtotal,")
                .append("fact_descuento,")
                .append("fact_total ")
                .append("FROM FACTURAS");

        try (Connection cn = db.getConnection();
                PreparedStatement ps = cn.prepareStatement(sql.toString())) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    facturas = new Facturas();

                    facturas.setFact_id(rs.getInt(1));
                    facturas.setFact_fecha(rs.getString(2));
                    facturas.setFact_hora(rs.getString(3));
                    facturas.setFact_estilista(rs.getString(4));
                    facturas.setFact_cliente(rs.getString(5));
                    facturas.setMpag_id(rs.getInt(6));
                    facturas.setFact_metodo_pago(rs.getString(7));
                    facturas.setFact_subtotal(rs.getDouble(8));
                    facturas.setFact_descuento(rs.getDouble(9));
                    facturas.setFact_total(rs.getDouble(10));
                    
                    list.add(facturas);

                }
            }

        } catch (SQLException e) {
            message = e.getMessage();
        }

        return list;
    }

    @Override
    public Integer registrarFactura(Facturas facturas) {
        String sp = "{?= call fn_InsertFactura(?,?,?,?,?,?,?,?,?,?,?)}";
         Integer id = null;
        
        try (Connection cn = db.getConnection();
                CallableStatement cs = cn.prepareCall(sp)) {

            cn.setAutoCommit(false);
            
            Date date1 = Date.valueOf(facturas.getFact_fecha());
            Time time1 = Time.valueOf(facturas.getFact_hora());
                        
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setDate(2, date1);
            cs.setTime(3, time1);
            cs.setInt(4, facturas.getUser_id());
            cs.setString(5, facturas.getFact_estilista());
            cs.setInt(6, facturas.getClie_id());
            cs.setString(7, facturas.getFact_cliente());
            cs.setInt(8, facturas.getMpag_id());
            cs.setString(9, facturas.getFact_metodo_pago());
            cs.setDouble(10, facturas.getFact_subtotal());
            cs.setDouble(11, facturas.getFact_descuento());
            cs.setDouble(12, facturas.getFact_total());

            cs.execute();
            id = cs.getInt(1);
            
            if (id == null) {
                cn.rollback();
            }
            else {
                cn.commit();
            }
            
            cn.setAutoCommit(true);
            
        } catch (SQLException e) {
            message = e.getMessage();
        }

        return id;
    }
    
}
