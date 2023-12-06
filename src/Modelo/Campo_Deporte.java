package Modelo;

public class Campo_Deporte {
    private int idCampoDeporte;
    private int idCampo;
    private int idDeporte;
    private CampoDeportivo campoDeportivo;  // Referencia al campo deportivo
    private Deporte deporte;  // Referencia al deporte

    

    public Campo_Deporte() {
    }

    public int getIdCampoDeporte() {
        return idCampoDeporte;
    }

    public void setIdCampoDeporte(int idCampoDeporte) {
        this.idCampoDeporte = idCampoDeporte;
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

    public CampoDeportivo getCampoDeportivo() {
        return campoDeportivo;
    }

    public void setCampoDeportivo(CampoDeportivo campoDeportivo) {
        this.campoDeportivo = campoDeportivo;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }
    
    public Object[] RegistroRelacion(int numeracion) {
        Object[] fila = {numeracion,idCampoDeporte ,idCampo, idDeporte};
        return fila;
    }
}

