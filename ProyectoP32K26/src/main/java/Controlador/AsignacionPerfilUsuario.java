/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

/**
 *
 * @author Roli isaias Cedillo Chay 9959-24-1672
 */
import java.sql.Timestamp;

public class AsignacionPerfilUsuario{
   private int Usucodigo;
    private int Percodigo;

    public AsignacionPerfilUsuario() {}

    public AsignacionPerfilUsuario(int Usucodigo, int Percodigo) {
        this.Usucodigo = Usucodigo;
        this.Percodigo = Percodigo;
    }

    // Getters y Setters
    public int getUsucodigo() {
        return Usucodigo;
    }

    public void setUsucodigo(int Usucodigo) {
        this.Usucodigo = Usucodigo;
    }

    public int getPercodigo() {
        return Percodigo;
    }

    public void setPercodigo(int Percodigo) {
        this.Percodigo = Percodigo;
    }

    

}