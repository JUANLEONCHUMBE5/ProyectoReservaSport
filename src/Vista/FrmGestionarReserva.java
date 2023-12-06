
package Vista;

import Controlador.Ctrl_CampoDeportivo;
import Controlador.Ctrl_Cliente;
import Controlador.Ctrl_Campo_Deporte;
import Controlador.Ctrl_Deporte;
import Controlador.Ctrl_Reserva;
import Controlador.VentaPDF;
import Formatos.Mensajes;
import Modelo.CampoDeportivo;
import Modelo.Cliente;
import Modelo.Deporte;
import Modelo.Reserva;
import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class FrmGestionarReserva extends javax.swing.JInternalFrame {
    Cliente cli = new Cliente();
     Ctrl_Cliente controlcli = new Ctrl_Cliente();
     
     
     CampoDeportivo cpd = new CampoDeportivo();
     Ctrl_CampoDeportivo controlcpd = new Ctrl_CampoDeportivo();
     
     Deporte depor= new Deporte();
     Ctrl_Deporte controldepor=new Ctrl_Deporte();
     
     
     Ctrl_Campo_Deporte relacion= new Ctrl_Campo_Deporte();
     
      Reserva rsa = new Reserva();
     Ctrl_Reserva controlrsa= new Ctrl_Reserva();
     
     
     FrmReserva frmres= new FrmReserva();
     
    public FrmGestionarReserva() {

        initComponents();
         MostrarDatos2();
        
        this.setTitle("Nueva Reserva");
   
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblGestionarReserva = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel3.setBackground(new java.awt.Color(76, 61, 49));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblGestionarReserva.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(tblGestionarReserva);

        jPanel3.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 1240, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 1292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 618, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 60, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    
     public void MostrarDatos2(){
     Connection con = Conexion.conectar();
        Statement st;
        
    
        
     String[] titulos={"Nro","ID Reserva","ID Cliente ","ID Campo","ID Deporte","Fecha","Hora Inicio","Hora Fin","Duración","1° Pago","2° Pago","Pago Total"};
     DefaultTableModel modelo = new DefaultTableModel(null,titulos);
     tblGestionarReserva.setModel(modelo);
        String sql = "select idReserva,idCliente,idCampo,idDeporte,fecha,horaInicio,horaFin,duracion,primerPago,segundoPago,pagototal,estado from tb_reserva where estado='S';";
     Reserva rsa= new Reserva();
     int cantreg=0;
     try{
         st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
         while(rs.next()){
             
             cantreg++;
             rsa.setIdReserva(rs.getInt(1));
             rsa.setIdCliente(rs.getInt(2));
             rsa.setIdCampo(rs.getInt(3));
             rsa.setIdDeporte(rs.getInt(4));
             
             rsa.setFechaReserva(rs.getDate(5));
             
             LocalTime horaInicio = rs.getTime(6).toLocalTime();
             rsa.setHoraInicio(horaInicio);
             
             
             LocalTime horaFin = rs.getTime(7).toLocalTime();
             rsa.setHoraFin(horaFin);
            
             rsa.setDuracion(rs.getInt(8));
             rsa.setPrimerPago(rs.getFloat(9));
             rsa.setSegundoPago(rs.getFloat(10));
             rsa.setPagototal(rs.getFloat(11));
             rsa.setEstado(rs.getString(12));

             
             
             modelo.addRow(rsa.RegistroReserva(cantreg));
         }//fin while
        
        
         con.close();         
     }catch(Exception e){
         Mensajes.M1("ERROR no se pueden mostrar la tabla ...."+e);
     }
 }  
     public void MostrarDatos(){
     Connection con = Conexion.conectar();
        Statement st;
        
    
        
     String[] titulos={"Nro","ID Reserva","ID Cliente ","ID Campo","ID Deporte","Fecha","Hora Inicio","Hora Fin","Duración","1° Pago","2° Pago","Pago Total"};
     DefaultTableModel modelo = new DefaultTableModel(null,titulos);
     tblGestionarReserva.setModel(modelo);
        String sql = "select idReserva,idCliente,idCampo,idDeporte,fecha,horaInicio,horaFin,duracion,primerPago,segundoPago,pagototal,estado from tb_reserva where estado='S';";
     Reserva rsa= new Reserva();
     int cantreg=0;
     try{
         st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
         while(rs.next()){
             
             cantreg++;
             rsa.setIdReserva(rs.getInt(1));
             rsa.setIdCliente(rs.getInt(2));
             rsa.setIdCampo(rs.getInt(3));
             rsa.setIdDeporte(rs.getInt(4));
             
             rsa.setFechaReserva(rs.getDate(5));
             
             LocalTime horaInicio = rs.getTime(6).toLocalTime();
             rsa.setHoraInicio(horaInicio);
             
             
             LocalTime horaFin = rs.getTime(7).toLocalTime();
             rsa.setHoraFin(horaFin);
            
             rsa.setDuracion(rs.getInt(8));
             rsa.setPrimerPago(rs.getFloat(9));
             rsa.setSegundoPago(rs.getFloat(10));
             rsa.setPagototal(rs.getFloat(11));
             rsa.setEstado(rs.getString(12));

             
             
             modelo.addRow(rsa.RegistroReserva(cantreg));
         }//fin while
        
        
         con.close();         
     }catch(Exception e){
         Mensajes.M1("ERROR no se pueden mostrar la tabla ...."+e);
     }
 }  
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable tblGestionarReserva;
    // End of variables declaration//GEN-END:variables


  


 
   
}