/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import BD.conexion;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author zooe_
 */
public class ControllerRequest  implements PeticionesDAO{
    private conexion con = new conexion();        
    private Connection cnx = con.obtener();    

    
    public boolean ExistUser(String user){
        String query = "SELECT COUNT(*) FROM usuarios WHERE user = ? ";
        try{
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return rs.getInt(1) > 0 ;
            }
        }catch (SQLException ex){
            System.out.println("Error al validar existencia de usuario:  "+ ex);
        }
        return false;
    }
    
    @Override
    public boolean addUser(String user, String pass) {
        if(ExistUser(user)){
           JOptionPane.showMessageDialog(null, "El nombre de usuario ya existe, ingrese otro.", "Usuario Duplicado", JOptionPane.WARNING_MESSAGE);
          return false;
        }
        String query = "INSERT INTO usuarios (user, password, fecha) VALUES(?,?,CURRENT_TIMESTAMP)";

        try{
            PreparedStatement ps = cnx.prepareStatement(query);
            ps.setString(1, user);           
            ps.setString(2, pass);
            
           int filasAfectadas = ps.executeUpdate();
            if (filasAfectadas > 0) {
                JOptionPane.showMessageDialog(null, "Se ingresó un usuario exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
            }
            return false;
        }catch(SQLException ex){
            System.out.println("Ocurrio un error al insertar. " + ex);
             return false;
        }
    }

    @Override
    public boolean updateUser(String user, String pass, int id) {
        try{
            String query = "UPDATE usuarios SET user = ?, password = ? WHERE iduser = ?";
            PreparedStatement Prep = cnx.prepareStatement(query);
            Prep.setString(1, user);
            Prep.setString(2, pass);
            Prep.setInt(3, id);
            
            Prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo el usuario exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            return true;
        }catch(SQLException ex){
            System.out.println("Ocurrio un error al actualizar" + ex);
            return false;
        }
    }

    @Override
    public boolean deleteUser(int id) {
        try{
               
                String query = "DELETE FROM  usuarios WHERE iduser = ?";
                PreparedStatement PS = cnx.prepareStatement(query);
                PS.setInt(1, id);
                PS.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se elimino el usuario exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                return true;
        }catch(SQLException ex){
            System.out.println("Ocurrio un error al eliminar" + ex);
                return false;
        }
    }

    @Override
    public void selectUser(JTable mostrar) {
                //ASIGNA UNA VARIABLE  QUE TENDRA EL MODELO POR DEFECTO DE LA TABLA
                DefaultTableModel model = new DefaultTableModel(){
                
                @Override
                public boolean isCellEditable(int row, int column){
                    return false;
                }
                };
                //ORDENA DATOS SEGUN LAS COLUMNAS
                TableRowSorter<TableModel> orderTable = new TableRowSorter<TableModel>(model);
                mostrar.setRowSorter(orderTable);
                String query = "SELECT *FROM usuarios";
                
                
                model.addColumn("Id");                
                model.addColumn("Usuario");
                model.addColumn("Contraseña");
                model.addColumn("Fecha creacion");
                
                
                
                mostrar.setModel(model);
                String []Datos = new String[4]; //ALMACEN TEMPORAL DE DATOS.
                try{
                   Statement st = cnx.createStatement();
                   ResultSet rs = st.executeQuery(query);
                    while(rs.next()){
                        Datos[0]=rs.getString("iduser");                        
                        Datos[1]=rs.getString("user");
                        Datos[2]=rs.getString("password");
                        Datos[3]=rs.getString("fecha");
                        model.addRow(Datos);
                    }
                    
                }catch(SQLException ex){
                    System.out.println("Ocurrio un error al mostrar los datos " + ex);
                }
    }
    
}
