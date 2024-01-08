/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package muzamia.northernlights.dao;

import java.util.List;
import muzamia.northernlights.dto.Productos;

/**
 *
 * @author User
 */
public interface DaoProductos {
    
    public List<Productos> listarProductos(Integer categoria_id);
    
    public Double obtenerPrecio(Integer id);
    
    public List<Object[]> listaProductos();
    
}
