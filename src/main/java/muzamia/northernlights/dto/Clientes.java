/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class Clientes {
    
    private Integer clie_id;
    private String clie_nombres;
    private String clie_apellidos;
    private Integer clie_dni;
    private Boolean clie_estado;

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
     * @return the clie_nombres
     */
    public String getClie_nombres() {
        return clie_nombres;
    }

    /**
     * @param clie_nombres the clie_nombres to set
     */
    public void setClie_nombres(String clie_nombres) {
        this.clie_nombres = clie_nombres;
    }

    /**
     * @return the clie_apellidos
     */
    public String getClie_apellidos() {
        return clie_apellidos;
    }

    /**
     * @param clie_apellidos the clie_apellidos to set
     */
    public void setClie_apellidos(String clie_apellidos) {
        this.clie_apellidos = clie_apellidos;
    }

    /**
     * @return the clie_dni
     */
    public Integer getClie_dni() {
        return clie_dni;
    }

    /**
     * @param clie_dni the clie_dni to set
     */
    public void setClie_dni(Integer clie_dni) {
        this.clie_dni = clie_dni;
    }

    /**
     * @return the clie_estado
     */
    public Boolean getClie_estado() {
        return clie_estado;
    }

    /**
     * @param clie_estado the clie_estado to set
     */
    public void setClie_estado(Boolean clie_estado) {
        this.clie_estado = clie_estado;
    }
}
