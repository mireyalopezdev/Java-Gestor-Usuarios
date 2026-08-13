
package Controllers;

import javax.swing.JTable;

public interface PeticionesDAO {
    
    boolean addUser(String user, String pass);    
    boolean updateUser(String user, String pass, int id);
    boolean deleteUser(int id);

    void selectUser(JTable mostrar);
}
