package java_code.util;

/**
 *
 * @author User
 */
public class Convertir {
    
    public static StringBuilder toPDF (String[][] parm) {
        StringBuilder sb = new StringBuilder();
        
        try {
            for (int i = 0; i < parm.length; i++) {
                sb.append("<");
                sb.append(parm[i]);
                sb.append(">");
                
                
                
                sb.append("</");
                sb.append(parm[i]);
                sb.append(">");
            }
        } catch (Exception e) {
        }
        
        return sb;
    }
}
