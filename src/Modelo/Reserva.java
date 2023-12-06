
package Modelo;

import java.time.LocalTime;
import java.util.Date;

public class Reserva {
    
    
    private int idReserva;
    private String nombreCliente;
    private String nombreCampo;
    private String nombreDeporte;
    
    private Date fechaReserva;
    LocalTime horaInicio;
    LocalTime horaFin;
    int duracion;
    float primerPago ;
    float segundoPago ;
    float pagototal ;
    private String estado;
    
    private int idCliente;
    private int idCampo;
    private int idDeporte;

    
    public Reserva() {
    }

    public Reserva(int idReserva, int idCliente, int idCampo, int idDeporte, Date fechaReserva, LocalTime horaInicio, LocalTime horaFin, int duracion, float primerPago, float segundoPago, float pagototal, String estado) {
        this.idReserva = idReserva;
        this.idCliente = idCliente;
        this.idCampo = idCampo;
        this.idDeporte = idDeporte;
        this.fechaReserva = fechaReserva;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.duracion = duracion;
        this.primerPago = primerPago;
        this.segundoPago = segundoPago;
        this.pagototal = pagototal;
        this.estado = estado;
        
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public int getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(int idDeporte) {
        this.idDeporte = idDeporte;
    }

    public Date getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(Date fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public float getPrimerPago() {
        return primerPago;
    }

    public void setPrimerPago(float primerPago) {
        this.primerPago = primerPago;
    }

    public float getSegundoPago() {
        return segundoPago;
    }

    public void setSegundoPago(float segundoPago) {
        this.segundoPago = segundoPago;
    }

    public float getPagototal() {
        return pagototal;
    }

    public void setPagototal(float pagototal) {
        this.pagototal = pagototal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    

    
     public Object[] RegistroReserva(int numeracion) {
        Object[] fila = {numeracion,idReserva ,idCliente, idCampo,idDeporte,fechaReserva,horaInicio,horaFin,duracion,primerPago,segundoPago,pagototal};
        return fila;
    }
    
    
    
    
    
    
}
