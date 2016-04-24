/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Metodo;

import Modelo.Archivo.ArchivoUsuarios;
import Modelo.Objeto.Usuario;
import java.util.ArrayList;

/**
 *
 * @author sqdan
 */
public class MTDS_LoginScreen 
{
    ArrayList <Usuario> arrayUsuarios;
    ArchivoUsuarios archivos;
    
    public MTDS_LoginScreen(ArchivoUsuarios archivos)
    {
        this.archivos = archivos;
        copiarArrayArchivo();
    }
    
    public void copiarArrayArchivo()
    {
        if(archivos.cargarArchivo())
        {
            this.arrayUsuarios = archivos.getArray();
            System.out.println("Archivo Usuarios copiado al array de Usuarios (En Login)");
        }
        else
        {
            System.out.println("Error al cargar el archivo 'Usuarios' (Desde Métodos).");
        }
    }
    
    public boolean comparar(String[] loginInfo)
    {
        boolean userMatch = false;
        boolean passMatch = false;
        boolean allMatch = false;
        
        for(int i = 0; i<arrayUsuarios.size();i++)
        {
            System.out.println("\n------------\nComparación: "+i+"\n"
                    +"Usuario Escrito: "+loginInfo[0]+"\n"
                    +"Usuario Guardado: "+arrayUsuarios.get(i).getUsuario()+"\n"
                    +"Pass Escrito:"+loginInfo[1]+"\n"
                    +"Pass Guardado:"+arrayUsuarios.get(i).getPass());
            if(loginInfo[0].equals(arrayUsuarios.get(i).getUsuario()))
            {
                userMatch = true;
            }
            System.out.println("\nUserMatch? "+userMatch);
            if(loginInfo[0].equals(arrayUsuarios.get(i).getPass()))
            {
                passMatch = true;
            }
            System.out.println("PassMatch? "+passMatch);
            
            if((loginInfo[0].equals(arrayUsuarios.get(i).getUsuario())) && (loginInfo[0].equals(arrayUsuarios.get(i).getPass())))
            {
                allMatch = true;
                System.out.println("allMatch? "+allMatch);
                i = arrayUsuarios.size();
            }
        }
        System.out.println("allMatch? "+allMatch);
        return allMatch;
    }
}
