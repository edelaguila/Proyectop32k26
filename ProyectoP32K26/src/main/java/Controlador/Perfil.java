package controlador;

public class Perfil {

    private int perCodigo;
    private String perNombre;
    private String perEstado;

    public Perfil() {
    }

    public Perfil(int perCodigo) {
        this.perCodigo = perCodigo;
    }

    public Perfil(String perNombre, String perEstado) {
        this.perNombre = perNombre;
        this.perEstado = perEstado;
    }

    public Perfil(int perCodigo, String perNombre, String perEstado) {
        this.perCodigo = perCodigo;
        this.perNombre = perNombre;
        this.perEstado = perEstado;
    }

    public int getPerCodigo() {
        return perCodigo;
    }

    public void setPerCodigo(int perCodigo) {
        this.perCodigo = perCodigo;
    }

    public String getPerNombre() {
        return perNombre;
    }

    public void setPerNombre(String perNombre) {
        this.perNombre = perNombre;
    }

    public String getPerEstado() {
        return perEstado;
    }

    public void setPerEstado(String perEstado) {
        this.perEstado = perEstado;
    }

    @Override
    public String toString() {
        return "Perfil{" +
                "perCodigo=" + perCodigo +
                ", perNombre=" + perNombre +
                ", perEstado=" + perEstado +
                '}';
    }
}