/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class MetodoPago {
    
    private Integer mpag_id;
    private String mpag_descripcion;
    private double mpag_comision;
    private Boolean mpag_estado;

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
     * @return the mpag_descripcion
     */
    public String getMpag_descripcion() {
        return mpag_descripcion;
    }

    /**
     * @param mpag_descripcion the mpag_descripcion to set
     */
    public void setMpag_descripcion(String mpag_descripcion) {
        this.mpag_descripcion = mpag_descripcion;
    }

    /**
     * @return the mpag_comision
     */
    public double getMpag_comision() {
        return mpag_comision;
    }

    /**
     * @param mpag_comision the mpag_comision to set
     */
    public void setMpag_comision(double mpag_comision) {
        this.mpag_comision = mpag_comision;
    }

    /**
     * @return the mpag_estado
     */
    public Boolean getMpag_estado() {
        return mpag_estado;
    }

    /**
     * @param mpag_estado the mpag_estado to set
     */
    public void setMpag_estado(Boolean mpag_estado) {
        this.mpag_estado = mpag_estado;
    }
    
}
