
package Controlador;

import Modelo.Reserva;
import com.mysql.jdbc.Statement;
import java.sql.Date;
import java.time.LocalTime;
import Formatos.Mensajes;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




public class Ctrl_Reserva {
    
    

       
  public boolean guardar(Reserva rsa) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO tb_reserva (idCliente,idCampo,idDeporte,fecha"
                    + ",horaInicio,horaFin,duracion,primerPago,segundoPago,pagototal,estado) VALUES (?,?,?,?,?,?,?,?,?,?,'S');");
            
            
            ps.setInt(1, rsa.getIdCliente());
            ps.setInt(2, rsa.getIdCampo());
            ps.setInt(3, rsa.getIdDeporte());
             ps.setDate(4, new java.sql.Date(rsa.getFechaReserva().getTime()));
            ps.setTime(5, java.sql.Time.valueOf(rsa.getHoraInicio()));
        ps.setTime(6, java.sql.Time.valueOf(rsa.getHoraFin()));
            ps.setInt(7, rsa.getDuracion());
            ps.setFloat(8, rsa.getPrimerPago());
            ps.setFloat(9, rsa.getSegundoPago());
            ps.setFloat(10, rsa.getPagototal());
            


            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            Mensajes.M1("Error al guardar la reserva: " + e);
        }
        return respuesta;
    }
  
  
  
  
     //metodo que recupera un registro de la tabla categoria mediante su id
 public Reserva ConsultarRegistro(int idReserva){
     Reserva rsa = null;
     Connection con = Conexion.conectar();
      Statement st;
      String sql = "select idReserva,indicador from tb_reserva where indicador='S' and idReserva="+idReserva+";";

     try{
           st = (Statement) con.createStatement();
            ResultSet rs = st.executeQuery(sql);
         
         if(rs.next()){
             rsa = new Reserva();
             rsa.setIdCliente(rs.getInt(1));
             rsa.setEstado(rs.getString(2));
         }
         rs.close();
     }catch(Exception e){
         Mensajes.M1("ERROR no se puede consultar el registro ..."+e);
     }
     return rsa;
 }
  
 public int auto_increm(String sql){
        int id = 1;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Conexion db = new Conexion();
        try{    
                ps = db.conectar().prepareStatement(sql);
                rs = ps.executeQuery();
                while(rs.next()){
                    id = rs.getInt(1)+1;
                }
        }catch(Exception ex){
            System.out.println("idmaximo"+ex.getMessage());
            id = 1;
        }
        finally{
            try{
                ps.close();
                rs.close();
               
            }catch(Exception ex){}
        }
        return id;
    }
 
 
 
   public int id_reserva_auto(){
        
       
        int id_max2 = 1;
        try{
            id_max2 = auto_increm("SELECT MAX(idReserva) FROM tb_reserva;");
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return id_max2;
    }
 
}
