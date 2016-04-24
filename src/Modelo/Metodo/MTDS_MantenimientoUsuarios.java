/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Metodo;

import Controlador.CNTRL_MantenimientoUsuarios;
import Modelo.Archivo.ArchivoUsuarios;
import Modelo.Objeto.Usuario;
import java.util.ArrayList;

/**
 *
 * @author sqdan
 */
public class MTDS_MantenimientoUsuarios
{
    ArrayList <Usuario> arrayUsuarios;
    CNTRL_MantenimientoUsuarios controlador;
    ArchivoUsuarios archivos;
    
    public MTDS_MantenimientoUsuarios(CNTRL_MantenimientoUsuarios controlador,ArchivoUsuarios archivos)
    {
        arrayUsuarios = new ArrayList<Usuario>();
        this.archivos = archivos;
        this.controlador = controlador;
        copiarArrayArchivo();
    }
    
    public void copiarArrayArchivo()
    {
        if(archivos.cargarArchivo())
        {
            this.arrayUsuarios = archivos.getArray();
            System.out.println("Archivo Usuarios copiado al array de Usuarios (En Mantenimiento Usuarios)");
        }
        else
        {
            System.out.println("Error al cargar el archivo 'Usuarios' (Desde Métodos).");
        }
    }
    
    public void escribirArrayArchivo()
    {
        archivos.crearArchivo();
        archivos.addObject(arrayUsuarios);
        System.out.println("Se ha enviado la información del array al archivo.");
    }
    
    public void agregarUsuario(String[] infoUsuario)
    {
        Usuario usuarioTemp = new Usuario(infoUsuario);
        
        System.out.println("Usuario Temp:\nUsuario: "+usuarioTemp.getUsuario()+"\nPass: "+usuarioTemp.getPass());
        
        System.out.println("Creado Usuario Temporal:\n"+usuarioTemp.getInfo());
        
        arrayUsuarios.add(usuarioTemp);
        
        System.out.println("Se ha añadido el usuario al array de Usuarios:\n"+arrayUsuarios.get((arrayUsuarios.size() - 1)).getInfo());
    }
}
