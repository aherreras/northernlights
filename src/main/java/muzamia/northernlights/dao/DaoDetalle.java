/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package muzamia.northernlights.dao;

import java.util.List;
import muzamia.northernlights.dto.Detalle;

/**
 *
 * @author User
 */
public interface DaoDetalle {
    
    public List<Object[]> verDetalle(Integer id);
    
    public String registrarDetalle(Detalle detalle);

}
