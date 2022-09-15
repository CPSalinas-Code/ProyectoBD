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
public class Personas {
    public String id_persona;
    public String nombre;
    public String apellido;
    public String direccion; 
    public String telefono;
    public String f_nacimiento;
    
    public Personas() {
        
    }
    
    public Personas(String id_persona, String nombre, String apellido, String direccion, String telefono, String f_nacimiento) {
        this.id_persona = id_persona;
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.telefono = telefono;
        this.f_nacimiento = f_nacimiento;
    }

    public String getId_persona() {
        return id_persona;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getDireccion() {
        return direccion;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getF_nacimiento() {
        return f_nacimiento;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setF_nacimiento(String f_nacimiento) {
        this.f_nacimiento = f_nacimiento;
    }
    
    
    
}
