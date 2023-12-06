
package Controlador;
import Formatos.Mensajes;
import conexion.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import Vista.FrmPantallaPrincipal;



public class Ctrl_Usuario {
    
        public void guardarUsuario(String alias, String password){ //registeruser
        Conexion db = new Conexion();
        String sql = "insert into tb_usuario(alias, password,indicador) values ('" + alias +"', '" + password +"', 'S');";
        Statement st;
        Connection conexion = db.conectar();
        try
        {
            st = conexion.createStatement();
            int rs = st.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Guardado correctamente");
        }catch(SQLException e)
        {
            System.out.println(e);
        }
    }
    
   public void consultarUsuario(String alias, String pass) { //login
    Conexion db = new Conexion();
    try {
        Connection cn = db.conectar();
        // Utiliza una consulta parametrizada para buscar un usuario por nombre
        String query = "SELECT alias, password FROM tb_usuario WHERE alias = ?";
        PreparedStatement pst = cn.prepareStatement(query);
        pst.setString(1, alias);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            // Se encontró un usuario con el nombre de usuario ingresado
            String passCorrecto = rs.getString("password");

            if (pass.equals(passCorrecto)) {
                JOptionPane.showMessageDialog(null, "Login correcto. Bienvenido " + alias);
                 FrmPantallaPrincipal menu = new FrmPantallaPrincipal();
                menu.setVisible(true);
              

            } else {
                JOptionPane.showMessageDialog(null, "Contraseña incorrecta");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Usuario no encontrado");
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Error: " + e);
    }
    }

   
        public boolean guardar(Usuario usu) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement ps = cn.prepareStatement("insert into tb_usuario(alias,password,nombre,telefono,indicador) values (?,?,?,?,'S');");
            
            ps.setString(1, usu.getAlias());
            ps.setString(2, usu.getPassword());
            ps.setString(3, usu.getNombre());
            ps.setInt(4, usu.getTelefono());
            
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
  

        } catch (SQLException e) {
            System.out.println("Error al guardar datoz del usuario: " + e);
        }
            return respuesta;   
    }
        
        
         public boolean existeUsuario(String alias) {
        boolean respuesta = false;
        String sql = "select alias from tb_usuario where usuario = '" + alias + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar usuario: " + e);
        }
        return respuesta;
    }
        
   //metodo que recupera un registro de la tabla categoria mediante su id
 public Usuario ConsultarRegistro(int idusu){
     Usuario usu = null;
     Connection con = Conexion.conectar();
      Statement st;
      String sql = "select idUsuario,alias,password,nombre,telefono,"
                 + "indicador from tb_usuario where indicador='S' and idUsuario="+idusu+";";

     try{
           st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
         
         if(rs.next()){
             usu = new Usuario();
             usu.setIdUsuario(rs.getInt(1));
             usu.setAlias(rs.getString(2));
             usu.setPassword(rs.getString(3));
             usu.setNombre(rs.getString(4));
             usu.setTelefono(rs.getInt(5));          
             usu.setIndicador(rs.getString(6));
         }
         rs.close();
     }catch(Exception e){
         Mensajes.M1("ERROR no se puede consultar el registro ..."+e);
     }
     return usu;
 }
 
 //método que actualiza un registro  de la tabla categoria por medio de su id
 public void ActualizarRegistro(Usuario usu){
     Connection cn = conexion.Conexion.conectar();
     try{
        PreparedStatement ps = cn.prepareStatement("update tb_usuario set alias=?,password=?,nombre=?,telefono=? where idUsuario=?;");

         ps.setString(1,usu.getAlias());
         ps.setString(2,usu.getPassword());
         ps.setString(3,usu.getNombre());
         ps.setInt(4,usu.getTelefono());        
         ps.setInt(5,usu.getIdUsuario());
         ps.executeUpdate();
         Mensajes.M1("Registro actualizado correctamente...");
         ps.close();
     }catch(Exception  ex){
         Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
     }
 }
    
 
  //método que elimina (inhabilita) un registro de la tabla categorias
 public void EliminarRegistro(int idusu){
     
     Connection cn = conexion.Conexion.conectar();
     try{
         PreparedStatement ps = cn.prepareStatement("update tb_usuario set indicador='N' where idUsuario=?;");
         ps.setInt(1,idusu);
         ps.executeUpdate();
         Mensajes.M1("Registro eliminado de la tabla ");
         ps.close();
     }catch(Exception ex){
         Mensajes.M1("ERROR no se puede eliminar el registro.."+ex);
     }
 } 
 
 
 
 
}
