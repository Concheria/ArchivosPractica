/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Archivo.ArchivoUsuarios;

import Vista.Frame.FRM_LoginScreen;
import Vista.Frame.FRM_MantenimientoUsuarios;
import Vista.Frame.FRM_MenuPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author sqdan
 */
public class CNTRL_MenuPrincipal implements ActionListener
{    
    FRM_MenuPrincipal frame;
    FRM_LoginScreen login;
    FRM_MantenimientoUsuarios mantenimientoUsuarios;
    ArchivoUsuarios archivos;

    public CNTRL_MenuPrincipal(FRM_MenuPrincipal frame, ArchivoUsuarios archivos) 
    {
        this.frame = frame;
        this.archivos = archivos;
        login = new FRM_LoginScreen(archivos, this);
        mantenimientoUsuarios = new FRM_MantenimientoUsuarios(archivos, this);
    }
    
    public void mostrarMenu()
    {
        frame.setVisible(true);
    }
    
    public void mostrarVentanaLogin()
    {
        login.setVisible(true);
    }

    public void crearPrimerUsuario() 
    {
        mantenimientoUsuarios.primerUsuarioConfig();
        mantenimientoUsuarios.setVisible(true);
    }
    
    public void cargarArchivo()
    {
        mantenimientoUsuarios.cargarArchivo();
    }
    
    public void finishFirstRun()
    {
        archivos.cargarArchivo();
        login.copiarArchivo();
        login.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
    }    
}
