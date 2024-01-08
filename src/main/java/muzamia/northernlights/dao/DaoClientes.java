/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package muzamia.northernlights.dao;

import java.util.List;
import muzamia.northernlights.dto.Clientes;

/**
 *
 * @author User
 */
public interface DaoClientes {
    
    public Clientes getCliente(Integer dni);
    
    public Integer getID(Integer dni);
    
    public List<Object[]> listaClientes();
    
}
