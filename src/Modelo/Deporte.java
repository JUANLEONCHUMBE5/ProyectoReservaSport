package Modelo;

public class Deporte {

    private int idDeporte;
    private String descripcion;
     private float precioMinuto;
    private String estado;

    public Deporte() {
    }

    public int getIdDeporte() {
        return idDeporte;
    }

    public void setIdDeporte(int idDeporte) {
        this.idDeporte = idDeporte;
    }


    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrecioMinuto() {
        return precioMinuto;
    }

    public void setPrecioMinuto(float precioMinuto) {
        this.precioMinuto = precioMinuto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

 
 
    
    
     public Object[] RegistroDeporte(int numeracion) {
        Object[] fila = {numeracion,idDeporte , descripcion,precioMinuto};
        return fila;
    }

}
