/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo.ArchivoUsuarios;
import Modelo.Metodo.MTDS_MantenimientoUsuarios;

import Vista.Frame.FRM_MantenimientoUsuarios;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sqdan
 */
public class CNTRL_MantenimientoUsuarios implements ActionListener
{
    FRM_MantenimientoUsuarios frame;
    MTDS_MantenimientoUsuarios metodos;
    ArchivoUsuarios archivos;
    
    public CNTRL_MantenimientoUsuarios(FRM_MantenimientoUsuarios frame, ArchivoUsuarios archivos)
    {
        this.frame = frame;
        metodos = new MTDS_MantenimientoUsuarios(this,archivos);
        System.out.println("Creado el controlador de mantenimiento de Usuarios");
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Agregar"))   
        {
            System.out.println("Agregar Usuario");
            metodos.agregarUsuario(frame.getInfo());
            metodos.escribirArrayArchivo();
        }
        if(e.getActionCommand().equals("Buscar"))
        {
            System.out.println("Buscar Usuario");
        }
        if(e.getActionCommand().equals("Modificar"))
        {
          System.out.println("Modificar Usuario");
        }
        if(e.getActionCommand().equals("Eliminar"))
        {
            System.out.println("Eliminar Usuario");
        }
    }
}
