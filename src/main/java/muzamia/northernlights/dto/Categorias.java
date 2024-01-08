/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class Categorias {
    
    private Integer cate_id;
    private String cate_descripcion;

    /**
     * @return the cate_id
     */
    public Integer getCate_id() {
        return cate_id;
    }

    /**
     * @param cate_id the cate_id to set
     */
    public void setCate_id(Integer cate_id) {
        this.cate_id = cate_id;
    }

    /**
     * @return the cate_descripcion
     */
    public String getCate_descripcion() {
        return cate_descripcion;
    }

    /**
     * @param cate_descripcion the cate_descripcion to set
     */
    public void setCate_descripcion(String cate_descripcion) {
        this.cate_descripcion = cate_descripcion;
    }
}
