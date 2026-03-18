package Controlador;

/**
 * Corresponde a la tabla asignacionaplicacionusuario de la base de datos.
 * Karina Alejandra Arriaza Ortiz 9959-24-14190
 * Modificada según estructura del script.
 */

public class AsignacionAplicacionUsuario {

    // Llaves primaria/foránea
    private int Aplcodigo;
    private int Usucodigo;

    // Permisos de la aplicación (varchar(1))
    private String APLUins;
    private String APLUsel;
    private String APLUupd;
    private String APLUdel;
    private String APLUrep;

    // Constructor vacío
    public AsignacionAplicacionUsuario() {
    }

    // Constructor con todos los atributos
    public AsignacionAplicacionUsuario(int Aplcodigo, int Usucodigo, String APLUins, String APLUsel, String APLUupd, String APLUdel, String APLUrep) {
        this.Aplcodigo = Aplcodigo;
        this.Usucodigo = Usucodigo;
        this.APLUins = APLUins;
        this.APLUsel = APLUsel;
        this.APLUupd = APLUupd;
        this.APLUdel = APLUdel;
        this.APLUrep = APLUrep;
    }

    // GET Y SET

    public int getAplcodigo() {
        return Aplcodigo;
    }

    public void setAplcodigo(int Aplcodigo) {
        this.Aplcodigo = Aplcodigo;
    }

    public int getUsucodigo() {
        return Usucodigo;
    }

    public void setUsucodigo(int Usucodigo) {
        this.Usucodigo = Usucodigo;
    }

    public String getAPLUins() {
        return APLUins;
    }

    public void setAPLUins(String APLUins) {
        this.APLUins = APLUins;
    }

    public String getAPLUsel() {
        return APLUsel;
    }

    public void setAPLUsel(String APLUsel) {
        this.APLUsel = APLUsel;
    }

    public String getAPLUupd() {
        return APLUupd;
    }

    public void setAPLUupd(String APLUupd) {
        this.APLUupd = APLUupd;
    }

    public String getAPLUdel() {
        return APLUdel;
    }

    public void setAPLUdel(String APLUdel) {
        this.APLUdel = APLUdel;
    }

    public String getAPLUrep() {
        return APLUrep;
    }

    public void setAPLUrep(String APLUrep) {
        this.APLUrep = APLUrep;
    }

    // Método toString
    @Override
    public String toString() {
        return "AsignacionAplicacionUsuario{" +
                "Aplcodigo=" + Aplcodigo +
                ", Usucodigo=" + Usucodigo +
                ", APLUins='" + APLUins + '\'' +
                ", APLUsel='" + APLUsel + '\'' +
                ", APLUupd='" + APLUupd + '\'' +
                ", APLUdel='" + APLUdel + '\'' +
                ", APLUrep='" + APLUrep + '\'' +
                '}';
    }
}