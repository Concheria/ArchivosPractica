/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Objeto;

import java.io.Serializable;

/**
 *
 * @author sqdan
 */
public class Usuario implements Serializable
{
    private String nombre;
    private String usuario;
    private String pass;
    private String tipo;

    public Usuario(String nombre, String usuario, String pass, String tipo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.pass = pass;
        this.tipo = tipo;
    }
    
    public Usuario(String[] infoUsuario) {
        this.nombre = infoUsuario[0];
        this.usuario = infoUsuario[1];
        this.pass = infoUsuario[2];
        this.tipo = infoUsuario[3];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public String getInfo()
    {
        String info;
        
        info = "Nombre: "+getNombre()+"\n"
                +"Usuario: "+getUsuario()+"\n"
                +"Pass: "+getPass()+"\n"
                +"Tipo: "+getTipo()+"\n";
        
        return info;
    }
}
