package Modelo;


public class CampoDeportivo {

    private int idCampo;
    private String nombre;
    private String ubicacion;
     private String estado;
    // Resto de tus atributos y métodos

    public CampoDeportivo() {
    }

    public int getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(int idCampo) {
        this.idCampo = idCampo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

  
    
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public Object[] RegistroCampoDeportivo(int numeracion) {
        Object[] fila = {numeracion, idCampo, nombre, ubicacion};
        return fila;
    }
    }

