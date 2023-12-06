    
package Controlador;
import Formatos.Mensajes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Modelo.Campo_Deporte;
import Modelo.Deporte;
import java.util.ArrayList;
import java.util.List;



public class Ctrl_Campo_Deporte {
    
    

       
  public boolean guardar(Campo_Deporte campo_deporte) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            PreparedStatement ps = cn.prepareStatement("INSERT INTO tb_campodeportivo_deporte (idCampo, idDeporte) VALUES (?, ?);");
            ps.setInt(1, campo_deporte.getIdCampo());
            ps.setInt(2, campo_deporte.getIdDeporte());

            if (ps.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            Mensajes.M1("Error al guardar relación campo-deporte: " + e);
        }
        return respuesta;
    }
 
 public List<Deporte> obtenerDeportesPorCampo(int idCampo) {
        List<Deporte> deportes = new ArrayList<>();
        Connection cn = conexion.Conexion.conectar();
        try {
            
            
            String sql  = "SELECT d.* FROM tb_deporte d " 
                        + "INNER JOIN tb_campodeportivo_deporte cd ON d.idDeporte = cd.idDeporte " 
                        + "WHERE cd.idCampo = ?;";
            PreparedStatement ps = cn.prepareStatement(sql);
            ps.setInt(1, idCampo);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Deporte deporte = new Deporte();
                deporte.setIdDeporte(rs.getInt("idDeporte"));
                deporte.setDescripcion(rs.getString("descripcion"));
                deporte.setPrecioMinuto(rs.getFloat("precioMinuto"));
                deporte.setEstado(rs.getString("estado"));

                deportes.add(deporte);
            }
            cn.close();
        } catch (SQLException e) {
            Mensajes.M1("Error al obtener deportes por campo: " + e);
        }
        return deportes;
    }
 
}
