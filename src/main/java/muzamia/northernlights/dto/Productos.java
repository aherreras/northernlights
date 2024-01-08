/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class Productos {

    private Integer prod_id;
    private String prod_descripcion;
    private Double prod_precio;
    private Boolean prod_estado;
    private Integer cpro_id;
    
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
     * @return the prod_descripcion
     */
    public String getProd_descripcion() {
        return prod_descripcion;
    }

    /**
     * @param prod_descripcion the prod_descripcion to set
     */
    public void setProd_descripcion(String prod_descripcion) {
        this.prod_descripcion = prod_descripcion;
    }

    /**
     * @return the prod_precio
     */
    public Double getProd_precio() {
        return prod_precio;
    }

    /**
     * @param prod_precio the prod_precio to set
     */
    public void setProd_precio(Double prod_precio) {
        this.prod_precio = prod_precio;
    }

    /**
     * @return the prod_estado
     */
    public Boolean getProd_estado() {
        return prod_estado;
    }

    /**
     * @param prod_estado the prod_estado to set
     */
    public void setProd_estado(Boolean prod_estado) {
        this.prod_estado = prod_estado;
    }

    /**
     * @return the cpro_id
     */
    public Integer getCpro_id() {
        return cpro_id;
    }

    /**
     * @param cpro_id the cpro_id to set
     */
    public void setCpro_id(Integer cpro_id) {
        this.cpro_id = cpro_id;
    }
}
