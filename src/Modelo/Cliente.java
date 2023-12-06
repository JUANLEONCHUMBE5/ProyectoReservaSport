package Modelo;


public class Cliente {

   
    private int idCliente;
    private int DNI;
    private String nombre;
    private String telefono;
    private String direccion;
    private String indicador;

    
     public Cliente() {
        
        
    }
  
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIndicador() {
        return indicador;
    }

    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }
     
     public Object[] RgistroCliente(int numeracion){
        Object[] fila={numeracion,idCliente,DNI,nombre,telefono,direccion};
        return fila;
    }
    

}
