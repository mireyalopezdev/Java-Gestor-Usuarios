package BD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class conexion {
    private static Connection cnx = null;

    public static Connection obtener(){
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestor", "root", "");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"Hubo un error y no se pude acceder a la bd \n" + e);
            }
        
        return cnx;
    }

   
}
