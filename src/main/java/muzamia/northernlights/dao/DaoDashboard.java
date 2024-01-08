/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package muzamia.northernlights.dao;

import java.util.List;

/**
 *
 * @author User
 */
public interface DaoDashboard {
    
    public List<Object[]> listarDashboard();
    
    public List<Object[]> listarDashboardCl();
    
    public List<Object[]> listarDashboardPr();
    
    public List<Object[]> listarDashboardSv();
    
    public List<Object[]> listarDashboardMt();
    
    public List<Object[]> getCajaId();
    
}
