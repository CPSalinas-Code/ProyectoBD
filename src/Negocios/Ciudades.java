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
public class Ciudades {
    public String id_ciudad;
    public String nombre_ciudades;
    public String estado;
    public String pais;
    public String num_habitantes;

    public Ciudades(String id_ciudad, String nombre_ciudades, String estado, String pais, String num_habitantes) {
        this.id_ciudad = id_ciudad;
        this.nombre_ciudades = nombre_ciudades;
        this.estado = estado;
        this.pais = pais;
        this.num_habitantes = num_habitantes;
    }

    public Ciudades() {
    }

    public String getId_ciudad() {
        return id_ciudad;
    }

    public String getNombre_ciudades() {
        return nombre_ciudades;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public String getNum_habitantes() {
        return num_habitantes;
    }

    public void setId_ciudad(String id_ciudad) {
        this.id_ciudad = id_ciudad;
    }

    public void setNombre_ciudades(String nombre_ciudades) {
        this.nombre_ciudades = nombre_ciudades;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setNum_habitantes(String num_habitantes) {
        this.num_habitantes = num_habitantes;
    }
    
    
    
}
