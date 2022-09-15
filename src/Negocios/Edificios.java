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
public class Edificios {
    public String id_edificio;
    public String nombre_edificio;
    public String direccion_edificios;
    public String num_pisos;
    
    public Edificios(String id_edificio, String nombre_edificio, String direccion_edificios, String num_pisos) {
        this.id_edificio = id_edificio;
        this.nombre_edificio = nombre_edificio;
        this.direccion_edificios = direccion_edificios;
        this.num_pisos = num_pisos;
    }
    public Edificios() {
        
    }

    public String getId_edificio() {
        return id_edificio;
    }

    public String getNombre_edificio() {
        return nombre_edificio;
    }

    public String getDireccion_edificios() {
        return direccion_edificios;
    }

    public String getNum_pisos() {
        return num_pisos;
    }

    public void setNombre_edificio(String nombre_edificio) {
        this.nombre_edificio = nombre_edificio;
    }

    public void setId_edificio(String id_edificio) {
        this.id_edificio = id_edificio;
    }

    public void setDireccion_edificios(String direccion_edificios) {
        this.direccion_edificios = direccion_edificios;
    }

    public void setNum_pisos(String num_pisos) {
        this.num_pisos = num_pisos;
    }
    
    
}
