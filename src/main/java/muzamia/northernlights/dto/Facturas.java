/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class Facturas {

    private Integer fact_id;
    private String fact_fecha;
    private String fact_hora;
    private Integer user_id;
    private String fact_estilista;
    private Integer clie_id;
    private String fact_cliente;
    private Integer mpag_id;
    private String fact_metodo_pago;
    private double fact_subtotal;
    private double fact_descuento;
    private double fact_total;

    /**
     * @return the fact_id
     */
    public Integer getFact_id() {
        return fact_id;
    }

    /**
     * @param fact_id the fact_id to set
     */
    public void setFact_id(Integer fact_id) {
        this.fact_id = fact_id;
    }

    /**
     * @return the fact_fecha
     */
    public String getFact_fecha() {
        return fact_fecha;
    }

    /**
     * @param fact_fecha the fact_fecha to set
     */
    public void setFact_fecha(String fact_fecha) {
        this.fact_fecha = fact_fecha;
    }

    /**
     * @return the fact_hora
     */
    public String getFact_hora() {
        return fact_hora;
    }

    /**
     * @param fact_hora the fact_hora to set
     */
    public void setFact_hora(String fact_hora) {
        this.fact_hora = fact_hora;
    }

    /**
     * @return the user_id
     */
    public Integer getUser_id() {
        return user_id;
    }

    /**
     * @param user_id the user_id to set
     */
    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    /**
     * @return the fact_estilista
     */
    public String getFact_estilista() {
        return fact_estilista;
    }

    /**
     * @param fact_estilista the fact_estilista to set
     */
    public void setFact_estilista(String fact_estilista) {
        this.fact_estilista = fact_estilista;
    }

    /**
     * @return the clie_id
     */
    public Integer getClie_id() {
        return clie_id;
    }

    /**
     * @param clie_id the clie_id to set
     */
    public void setClie_id(Integer clie_id) {
        this.clie_id = clie_id;
    }

    /**
     * @return the fact_cliente
     */
    public String getFact_cliente() {
        return fact_cliente;
    }

    /**
     * @param fact_cliente the fact_cliente to set
     */
    public void setFact_cliente(String fact_cliente) {
        this.fact_cliente = fact_cliente;
    }

    /**
     * @return the mpag_id
     */
    public Integer getMpag_id() {
        return mpag_id;
    }

    /**
     * @param mpag_id the mpag_id to set
     */
    public void setMpag_id(Integer mpag_id) {
        this.mpag_id = mpag_id;
    }

    /**
     * @return the fact_metodo_pago
     */
    public String getFact_metodo_pago() {
        return fact_metodo_pago;
    }

    /**
     * @param fact_metodo_pago the fact_metodo_pago to set
     */
    public void setFact_metodo_pago(String fact_metodo_pago) {
        this.fact_metodo_pago = fact_metodo_pago;
    }
    
    /**
     * @return the fact_subtotal
     */
    public double getFact_subtotal() {
        return fact_subtotal;
    }

    /**
     * @param fact_subtotal the fact_subtotal to set
     */
    public void setFact_subtotal(double fact_subtotal) {
        this.fact_subtotal = fact_subtotal;
    }

    /**
     * @return the fact_descuento
     */
    public double getFact_descuento() {
        return fact_descuento;
    }

    /**
     * @param fact_descuento the fact_descuento to set
     */
    public void setFact_descuento(double fact_descuento) {
        this.fact_descuento = fact_descuento;
    }

    /**
     * @return the fact_total
     */
    public double getFact_total() {
        return fact_total;
    }

    /**
     * @param fact_total the fact_total to set
     */
    public void setFact_total(double fact_total) {
        this.fact_total = fact_total;
    }
}
