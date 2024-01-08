/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package muzamia.northernlights.dao;

import java.util.List;
import muzamia.northernlights.dto.Usuarios;

/**
 *
 * @author User
 */
public interface DaoUsuarios {
    
    public Usuarios getUsuario(String cod);
    
    public Integer getID(String cod);
    
    public List<Object[]> Listar_Usuarios();
    
}
