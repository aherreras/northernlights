/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dto;

/**
 *
 * @author User
 */
public class Servicios {
    
    private Integer serv_id;
    private String serv_nombre;
    private String serv_descripcion;
    private double serv_precio;
    private Integer cate_id;

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
     * @return the serv_nombre
     */
    public String getServ_nombre() {
        return serv_nombre;
    }

    /**
     * @param serv_nombre the serv_nombre to set
     */
    public void setServ_nombre(String serv_nombre) {
        this.serv_nombre = serv_nombre;
    }

    /**
     * @return the serv_descripcion
     */
    public String getServ_descripcion() {
        return serv_descripcion;
    }

    /**
     * @param serv_descripcion the serv_descripcion to set
     */
    public void setServ_descripcion(String serv_descripcion) {
        this.serv_descripcion = serv_descripcion;
    }

    /**
     * @return the serv_precio
     */
    public double getServ_precio() {
        return serv_precio;
    }

    /**
     * @param serv_precio the serv_precio to set
     */
    public void setServ_precio(double serv_precio) {
        this.serv_precio = serv_precio;
    }

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
}
