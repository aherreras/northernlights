/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class Promociones {
    
    private Integer prom_id;
    private Integer prod_id;
    private Integer kitt_id;
    private String prom_descripcion;
    private Double prom_precio;
    private Boolean prom_estado;

    /**
     * @return the prom_id
     */
    public Integer getProm_id() {
        return prom_id;
    }

    /**
     * @param prom_id the prom_id to set
     */
    public void setProm_id(Integer prom_id) {
        this.prom_id = prom_id;
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
     * @return the kitt_id
     */
    public Integer getKitt_id() {
        return kitt_id;
    }

    /**
     * @param kitt_id the kitt_id to set
     */
    public void setKitt_id(Integer kitt_id) {
        this.kitt_id = kitt_id;
    }

    /**
     * @return the prom_descripcion
     */
    public String getProm_descripcion() {
        return prom_descripcion;
    }

    /**
     * @param prom_descripcion the prom_descripcion to set
     */
    public void setProm_descripcion(String prom_descripcion) {
        this.prom_descripcion = prom_descripcion;
    }

    /**
     * @return the prom_precio
     */
    public Double getProm_precio() {
        return prom_precio;
    }

    /**
     * @param prom_precio the prom_precio to set
     */
    public void setProm_precio(Double prom_precio) {
        this.prom_precio = prom_precio;
    }

    /**
     * @return the prom_estado
     */
    public Boolean getProm_estado() {
        return prom_estado;
    }

    /**
     * @param prom_estado the prom_estado to set
     */
    public void setProm_estado(Boolean prom_estado) {
        this.prom_estado = prom_estado;
    }
    
}
