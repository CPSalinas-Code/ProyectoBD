/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

/**
 *
 * @author Christian
 */
public class ConsultaPermiso {
    public String accion;
    public String permiso;
    public String TOorFROM;
    public String nombreUser;

    public ConsultaPermiso(String accion, String permiso, String TOorFROM, String nombreUser) {
        this.accion = accion;
        this.permiso = permiso;
        this.TOorFROM = TOorFROM;
        this.nombreUser = nombreUser;
    }

    public ConsultaPermiso() {
    }

    public String getAccion() {
        return accion;
    }

    public String getPermiso() {
        return permiso;
    }

    public String getTOorFROM() {
        return TOorFROM;
    }

    public String getNombreUser() {
        return nombreUser;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public void setNombreUser(String nombreUser) {
        this.nombreUser = nombreUser;
    }

    public void setPermiso(String permiso) {
        this.permiso = permiso;
    }

    public void setTOorFROM(String TOorFROM) {
        this.TOorFROM = TOorFROM;
    }
       
    
}
