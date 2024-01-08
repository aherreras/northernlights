/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class Proveedores {
    private Integer prov_id;
    private String prov_razon_social;
    private String prov_ruc;
    private Boolean prov_estado;

    /**
     * @return the prov_id
     */
    public Integer getProv_id() {
        return prov_id;
    }

    /**
     * @param prov_id the prov_id to set
     */
    public void setProv_id(Integer prov_id) {
        this.prov_id = prov_id;
    }

    /**
     * @return the prov_razon_social
     */
    public String getProv_razon_social() {
        return prov_razon_social;
    }

    /**
     * @param prov_razon_social the prov_razon_social to set
     */
    public void setProv_razon_social(String prov_razon_social) {
        this.prov_razon_social = prov_razon_social;
    }

    /**
     * @return the prov_ruc
     */
    public String getProv_ruc() {
        return prov_ruc;
    }

    /**
     * @param prov_ruc the prov_ruc to set
     */
    public void setProv_ruc(String prov_ruc) {
        this.prov_ruc = prov_ruc;
    }

    /**
     * @return the prov_estado
     */
    public Boolean getProv_estado() {
        return prov_estado;
    }

    /**
     * @param prov_estado the prov_estado to set
     */
    public void setProv_estado(Boolean prov_estado) {
        this.prov_estado = prov_estado;
    }
}
