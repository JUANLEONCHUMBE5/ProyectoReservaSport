    
package Controlador;
import Formatos.Mensajes;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Modelo.Deporte;



public class Ctrl_Deporte {
    
    
        public boolean guardar(Deporte dep) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement ps = cn.prepareStatement("insert into tb_deporte(descripcion,precioMinuto,estado) values (?,?,'S');");
            
            
            ps.setString(1,dep.getDescripcion());
            ps.setFloat(2,dep.getPrecioMinuto());
            
            
            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
  

        } catch (SQLException e) {
            System.out.println("Error al guardar deporte: " + e);
        }
            return respuesta;   
    }
        
        
         public boolean existeDeporte(String descripcion) {
        boolean respuesta = false;
        String sql = "select descripcion from tb_deporte where descripcion = '" + descripcion + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
        return respuesta;
    }
        
       
   //metodo que recupera un registro de la tabla categoria mediante su id
 public Deporte ConsultarID(int idDeporte){
     Deporte depor = null;
     Connection con = Conexion.conectar();
      Statement st; 
      String sql = "select idDeporte,descripcion,precioMinuto,"
                 + "estado from tb_deporte where estado='S' and idDeporte="+idDeporte+";";

     try{
           st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
         
         if(rs.next()){
             depor = new Deporte();
             depor.setIdDeporte(rs.getInt(1));
             depor.setDescripcion(rs.getString(2));
             depor.setPrecioMinuto(rs.getFloat(3));
             depor.setEstado(rs.getString(4));
         }
         rs.close();
     }catch(Exception e){
         Mensajes.M1("ERROR no se puede consultar el registro ..."+e);
     }
     return depor;
 }
 
//metodo para que se extraigan datos en la reserva
  public Deporte ConsultarDeporteReserva(String descripcion){
     Deporte depor = null;
     Connection con = Conexion.conectar();
      Statement st;
      String sql ="select * from tb_deporte where estado='S' and descripcion='"+descripcion+"';";

     try{
           st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
         
         if(rs.next()){
             depor = new Deporte();
             depor.setIdDeporte(rs.getInt(1));
             depor.setDescripcion(rs.getString(2));
             depor.setPrecioMinuto(Float.parseFloat(rs.getString(3)));
            
            
         }
         rs.close();
     }catch(Exception e){
         Mensajes.M1("ERROR no se puede consultar el registro ..."+e);
     }
     return depor;
 }
 
 //método que actualiza un registro  de la tabla categoria por medio de su id
 public void ActualizarRegistro(Deporte depor){
     Connection cn = conexion.Conexion.conectar();
     try{
        PreparedStatement ps = cn.prepareStatement("update tb_deporte set descripcion=?,precioMinuto=? where idDeporte=?;");

     
         ps.setString(1,depor.getDescripcion());
         ps.setFloat(2,depor.getPrecioMinuto());
         ps.setInt(3,depor.getIdDeporte());
         ps.executeUpdate();
         Mensajes.M1("Registro actualizado correctamente...");
         ps.close();
     }catch(Exception  ex){
         Mensajes.M1("ERROR no se puede actualizar el registro..."+ex);
     }
 }

    
 
  //método que elimina (inhabilita) un registro de la tabla categorias
 public void EliminarRegistro(int idDepo){
     
     Connection cn = conexion.Conexion.conectar();
     try{
         PreparedStatement ps = cn.prepareStatement("update tb_deporte set estado='N' where idDeporte=?;");
         ps.setInt(1,idDepo);
         ps.executeUpdate();
         Mensajes.M1("Registro eliminado de la tabla ");
         ps.close();
     }catch(Exception ex){
         Mensajes.M1("ERROR no se puede eliminar el registro.."+ex);
     }
 } 
 
 
 
 
}
