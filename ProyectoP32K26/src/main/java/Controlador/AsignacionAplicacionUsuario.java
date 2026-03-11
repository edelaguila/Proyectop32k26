package Controlador;

/**
 * Corresponde a la tabla asignacionaplicacionusuario de la base de datos.
 * Karina Alejandra Arriaza Ortiz 9959-24-14190
 * @author VA
 */
public class AsignacionAplicacionUsuario {
    
    // Identificador de la asignación
    private int id;
    
    // Código de la aplicación asignada
    private int aplcodigo;
    
    // Código del usuario al que se le asigna la aplicación
    private int usucodigo;

    // Constructor vacío
    public AsignacionAplicacionUsuario() {
    }

    // Constructor con todos los atributos
    public AsignacionAplicacionUsuario(int id, int aplcodigo, int usucodigo) {
        this.id = id;
        this.aplcodigo = aplcodigo;
        this.usucodigo = usucodigo;
    }

    // Obtiene el id de la asignación
    public int getId() {
        return id;
    }

    // Establece el id de la asignación
    public void setId(int id) {
        this.id = id;
    }

    // Obtiene el código de la aplicación
    public int getAplcodigo() {
        return aplcodigo;
    }

    // Establece el código de la aplicación
    public void setAplcodigo(int aplcodigo) {
        this.aplcodigo = aplcodigo;
    }

    // Obtiene el código del usuario
    public int getUsucodigo() {
        return usucodigo;
    }

    // Establece el código del usuario
    public void setUsucodigo(int usucodigo) {
        this.usucodigo = usucodigo;
    }

    // Método que devuelve la información del objeto en forma de texto
    @Override
    public String toString() {
        return "AsignacionAplicacionUsuario{" +
                "id=" + id +
                ", aplcodigo=" + aplcodigo +
                ", usucodigo=" + usucodigo +
                '}';
    }
}