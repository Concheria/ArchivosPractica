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
import javax.swing.JOptionPane;

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
        this.archivos = archivos;
        System.out.println("Creado el controlador de mantenimiento de Usuarios");
    }
    
    public void cargarArchivo()
    {
        metodos.copiarArrayArchivo();
    }
    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand().equals("Agregar"))   
        {
            agregarUsuario();
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
    
    public void agregarUsuario()
    {
        System.out.println("Agregar Usuario");
            metodos.agregarUsuario(frame.getInfo());
            metodos.escribirArrayArchivo();
            if(frame.firstRun)
            {
                if(archivos.cargarArchivo())
                {
                    frame.normalConfig();
                    frame.setVisible(false);
                    frame.finishFirstRun();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Ha ocurrido un error al guardar el Usuario.\nIntente de nuevo");
                    agregarUsuario();
                }
            }
    }
}
