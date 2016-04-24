/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo.ArchivoUsuarios;
import Modelo.Metodo.MTDS_LoginScreen;
import Vista.Frame.FRM_LoginScreen;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author sqdan
 */
public class CNTRL_LoginScreen implements ActionListener
{
    FRM_LoginScreen frame;
    MTDS_LoginScreen metodos;
    ArchivoUsuarios archivos;

    public CNTRL_LoginScreen(FRM_LoginScreen frame, ArchivoUsuarios archivos) 
    {
        this.frame = frame;
        this.archivos = archivos;
        metodos = new MTDS_LoginScreen(archivos);
    }
    
    public void copiarArchivo()
    {
        metodos.copiarArrayArchivo();
    }
    
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Ingresar"))
        {
            System.out.println("Ingresar");
            if(metodos.comparar(frame.getLoginInfo()))
            {
                frame.mostrarMenu();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "El usuario o clave ingresado es incorrecto.\nPor favor intente de nuevo.");
            }
        }
    }
    
}
