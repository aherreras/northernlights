/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class Detalle {

    private Integer detf_id;
    private Integer fact_id;
    private Integer serv_id;
    private Integer prod_id;
    private String detf_p_s;
    private double detf_precio;
    private Integer detf_cantidad;
    private double detf_subtotal;
    private double detf_descuento;
    private double detf_total;

    /**
     * @return the detf_id
     */
    public Integer getDetf_id() {
        return detf_id;
    }

    /**
     * @param detf_id the detf_id to set
     */
    public void setDetf_id(Integer detf_id) {
        this.detf_id = detf_id;
    }

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
     * @return the serv_id
     */
    public Integer getServ_id() {
        return serv_id;
    }

    /**
     * @param serv_id the serv_id to set
     */
    public void setServ_id(Integer serv_id) {
        this.serv_id = serv_id;
    }
    
    /**
     * @return the prod_id
     */
    public Integer getProd_id() {
        return prod_id;
    }

    /**
     * @param prod_id the prod_id to set
     */
    public void setProd_id(Integer prod_id) {
        this.prod_id = prod_id;
    }

    /**
     * @return the detf_p_s
     */
    public String getDetf_p_s() {
        return detf_p_s;
    }

    /**
     * @param detf_p_s the detf_p_s to set
     */
    public void setDetf_p_s(String detf_p_s) {
        this.detf_p_s = detf_p_s;
    }

    /**
     * @return the detf_precio
     */
    public double getDetf_precio() {
        return detf_precio;
    }

    /**
     * @param detf_precio the detf_precio to set
     */
    public void setDetf_precio(double detf_precio) {
        this.detf_precio = detf_precio;
    }

    /**
     * @return the detf_cantidad
     */
    public Integer getDetf_cantidad() {
        return detf_cantidad;
    }

    /**
     * @param detf_cantidad the detf_cantidad to set
     */
    public void setDetf_cantidad(Integer detf_cantidad) {
        this.detf_cantidad = detf_cantidad;
    }

    /**
     * @return the detf_subtotal
     */
    public double getDetf_subtotal() {
        return detf_subtotal;
    }

    /**
     * @param detf_subtotal the detf_subtotal to set
     */
    public void setDetf_subtotal(double detf_subtotal) {
        this.detf_subtotal = detf_subtotal;
    }

    /**
     * @return the detf_descuento
     */
    public double getDetf_descuento() {
        return detf_descuento;
    }

    /**
     * @param detf_descuento the detf_descuento to set
     */
    public void setDetf_descuento(double detf_descuento) {
        this.detf_descuento = detf_descuento;
    }

    /**
     * @return the detf_total
     */
    public double getDetf_total() {
        return detf_total;
    }

    /**
     * @param detf_total the detf_total to set
     */
    public void setDetf_total(double detf_total) {
        this.detf_total = detf_total;
    }
}
