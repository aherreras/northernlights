/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package muzamia.northernlights.web.validator;

import java.util.List;
import jakarta.servlet.http.HttpServletRequest;
import muzamia.northernlights.dao.DaoDetOperacion;
import muzamia.northernlights.dao.DaoOperacion;
import muzamia.northernlights.dao.impl.DaoDetOperacionImpl;
import muzamia.northernlights.dao.impl.DaoOperacionImpl;
import muzamia.northernlights.dto.DetOperacion;
import muzamia.northernlights.dto.Operacion;

/**
 *
 * @author User
 */
public class OperacionesValidator {
    
    public String valida(HttpServletRequest request,
            Operacion operacion, DetOperacion detOperacion) {
        StringBuilder sb = new StringBuilder("<ul>");

        DaoOperacion operacionImpl = new DaoOperacionImpl();
        DaoDetOperacion detOperacionImpl = new DaoDetOperacionImpl();
        
//        Integer[] idproducto = Integer.parseInt(request.getParameterValues("pidproducto").toString());
//        Integer[] cantidad = DeString.aInteger(
//                request.getParameterValues("dcantidad"));
//        int ctos = 0;
//
//        // mensajería
//        if (idproducto == null) {
//            sb.append("<li>ID(s) incorrectos</li>");
//        } else {
//            ctos = idproducto.length;
//        }
//
//        if (cantidad == null) {
//            sb.append("<li>Cantidad por Producto incorrectos</li>");
//        } else if (ctos != cantidad.length) {
//            sb.append("<li>Cantidades no son Equivalentes</li>");
//        }
//
//        // encapsulamiento
//        for (int i = 0; i < ctos; i++) {
//            Movimientos m = new Movimientos();
//
//            m.setIdproducto(idproducto[i]);
//            m.setCantidad(-1 * cantidad[i]); // negativo disminuye stock
//
//            detOperacions.add(m);
//        }

        // retorno
        String result = (sb.length() != 4) // "<ul>"
                ? sb.append("</ul>").toString()
                : null;

        return result;
    }
    
}
