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

    public CNTRL_MenuPrincipal(FRM_MenuPrincipal frame, ArchivoUsuarios archivos) 
    {
        this.frame = frame;
        login = new FRM_LoginScreen(archivos);
        mantenimientoUsuarios = new FRM_MantenimientoUsuarios(archivos);
    }
    
    public void mostrarVentanaLogin()
    {
        login.setVisible(true);
    }

    public void crearPrimerUsuario() 
    {
        mantenimientoUsuarios.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) 
    {
    }    
}
