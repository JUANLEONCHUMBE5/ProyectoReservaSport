
package Controlador;
import Formatos.Mensajes;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Cliente;



public class Ctrl_Cliente {
    
    
        public boolean guardar(Cliente cli) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement ps = cn.prepareStatement("insert into tb_cliente(DNI,nombre,telefono,direccion,indicador) values (?,?,?,?,'S');");
            
            ps.setInt(1, cli.getDNI());
            ps.setString(2, cli.getNombre());
            ps.setString(3, cli.getTelefono());
            ps.setString(4,cli.getDireccion());
       
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
  

        } catch (SQLException e) {
            System.out.println("Error al guardar cliente: " + e);
        }
            return respuesta;   
    }
        
        
         public boolean existeCliente(int DNI) {
        boolean respuesta = false;
        String sql = "select DNI from tb_cliente where DNI = '" + DNI + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar cliente: " + e);
        }
        return respuesta;
    }
        
   //metodo que recupera un registro de la tabla categoria mediante su id
 public Cliente ConsultarRegistro(int DNI){
     Cliente cli = null;
     Connection con = Conexion.conectar();
      Statement st;
      String sql = "select idCliente,DNI,nombre,telefono,direccion,"
                 + "indicador from tb_cliente where indicador='S' and DNI="+DNI+";";

     try{
           st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
         
         if(rs.next()){
             cli = new Cliente();
             cli.setIdCliente(rs.getInt(1));
             cli.setDNI(rs.getInt(2));
             cli.setNombre(rs.getString(3));
             cli.setTelefono(rs.getString(4));
             cli.setDireccion(rs.getString(5));
             cli.setIndicador(rs.getString(6));
         }
         rs.close();
     }catch(Exception e){
         Mensajes.M1("ERROR no se puede consultar el registro ..."+e);
     }
     return cli;
 }
 
 //método que actualiza un registro  de la tabla categoria por medio de su id
 public void ActualizarRegistro(Cliente cli){
     Connection cn = conexion.Conexion.conectar();
     try{
        PreparedStatement ps = cn.prepareStatement("update tb_cliente set DNI=?,nombre=?,telefono=?,direccion=? where idCliente=?;");
        
        
         ps.setInt(1,cli.getDNI());
         ps.setString(2,cli.getNombre());
         ps.setString(3,cli.getTelefono());
         ps.setString(4,cli.getDireccion());
         ps.setInt(5,cli.getIdCliente());
         ps.executeUpdate();
         Mensajes.M1("Registro actualizado correctamente...");
         ps.close();
     }catch(Exception  ex){
         Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
     }
 }
    
 
  //método que elimina (inhabilita) un registro de la tabla categorias
 public void EliminarRegistro(int idcli){
     
     Connection cn = conexion.Conexion.conectar();
     try{
         PreparedStatement ps = cn.prepareStatement("update tb_cliente set indicador='N' where idCliente=?;");
         ps.setInt(1,idcli);
         ps.executeUpdate();
         Mensajes.M1("Registro eliminado de la tabla ");
         ps.close();
     }catch(Exception ex){
         Mensajes.M1("ERROR no se puede eliminar el registro.."+ex);
     }
 } 
 
 
 
 
}
