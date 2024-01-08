/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.dao;

import java.util.List;
import muzamia.northernlights.dto.Detalle;
import muzamia.northernlights.dto.Facturas;
/**
 *
 * @author User
 */
public interface DaoFacturas {
    
    public List<Facturas> listarFacturas();
    
    public Integer registrarFactura(Facturas facturas);
    
}
