/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo.Archivo;

import Modelo.Objeto.Usuario;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.util.ArrayList;

/**
 *
 * @author sqdan
 */
public class ArchivoUsuarios
{
    ObjectOutputStream archivoSalida;
    ObjectInputStream archivoEntrada;
    
    public ArchivoUsuarios()
    {
        if(cargarArchivo())
        {
            System.out.println("El archivo 'Usuarios' se ha cargado de forma exitosa.");
        }
        else
        {
            System.out.println("Error al cargar el archivo 'Usuarios'.");
        }
    }
    
    public boolean cargarArchivo()
    {
        boolean existe = false;
        
        try
        {
            archivoEntrada = new ObjectInputStream(new FileInputStream("Archivos/Usuarios.dat"));
            existe = true;
            System.out.println("El archivo 'Usuarios' se ha cargado de forma exitosa.");
        }
        catch(Exception e)
        {
            System.out.println("Error al cargar el archivo 'Usuarios':\n"+e);
        }
        
        return existe;
    }
    
    public void crearArchivo()
    {
        try
        {
            archivoSalida = new ObjectOutputStream(new FileOutputStream("Archivos/Usuarios.dat"));
            System.out.println("El archivo 'Usuarios' se ha creado de forma exitosa.");
        }
        catch(Exception e)
        {
            System.out.println("Error al crear el archivo 'Usuarios':\n"+e);
        }
    }
    
    public void addObject(ArrayList<Usuario> usuarios)
    {
            try
            {
                archivoSalida.writeObject(usuarios);
                System.out.println("Se escribió en forma correcta la información en el archivo");
            }
            catch(Exception e)
            {
                System.out.println("Error al escribir la información en el archivo:\n"+e);
            }
    }
    
    public ArrayList<Usuario> getArray()
    {
        ArrayList <Usuario> array = new ArrayList<>();
        
        try
        {
            while(true)
            {
                array = ((ArrayList<Usuario>)archivoEntrada.readObject());
            }
        }
        catch(Exception e)
        {
            System.out.println("Error al devolver el archivo 'Usuarios':\n"+e);
        }
        
        return array;        
    }
}
