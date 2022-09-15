/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocios;

import Datos.ConexionBD;
import Datos.MetodosConexion;
import Negocios.Ciudades;
import Negocios.Edificios;
import Negocios.Personas;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class Administrador {

    public ConexionBD conec = new ConexionBD();

    public Administrador() {

    }

    public void conectarInicio() {
        conec.conectarBD();
    }

    public boolean pasarDatosPersona(String ID, String nombre, String apellido, String direccion, String fecha, String telefono) {
        Personas persona = new Personas(ID, nombre, apellido, direccion, fecha, telefono);
        boolean validar = false;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        validar = metodos.insertar(persona);
        return validar;

    }

    public boolean pasarDatosCiudad(String IDCiudad, String nombreCiudad, String estado, String pais, String num_habitantes) {
        Ciudades ciudad = new Ciudades(IDCiudad, nombreCiudad, estado, pais, num_habitantes);
        boolean validar = false;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        validar = metodos.insertar(ciudad);
        return validar;
    }

    public boolean pasarDatosEdificio(String IDEdificio, String nombreEdificio, String direccionEdificio, String num_pisos) {
        Edificios edificio = new Edificios(IDEdificio, nombreEdificio, direccionEdificio, num_pisos);
        boolean validar = false;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        validar = metodos.insertar(edificio);
        return validar;
    }

    public Personas obtenerDatosPersona(int cont) throws IllegalArgumentException, IllegalAccessException {
        String[] datos = new String[6];
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        datos = metodos.obtenerDatosPersona(cont);
        Personas persona  = new Personas (datos[0],datos[1],datos[2],datos[3],datos[4],datos[5]);
        //datos = 
        return persona;
    }

    public Edificios obtenerDatosEdificio(int cont) {
        String dat[] = new String[4];
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        dat = metodos.obtenerDatosEdificio(cont);
        Edificios edificio = new Edificios(dat[0],dat[1],dat[2],dat[3]);
        return edificio;
    }

    public String[] obtenerDatosPrivilegios(int cont, String nombreTab) {
        String dat[] = new String[3];
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        dat = metodos.obtenerDatosPrivilegios(cont, nombreTab);
        return dat;

    }

    public Ciudades obtenerDatosCiudades(int cont) {
        String dat[] = new String[5];
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        dat = metodos.obtenerDatosCiudades(cont);
        Ciudades ciudad= new Ciudades(dat[0],dat[1],dat[2],dat[3],dat[4]);
        return ciudad;
    }

    public String[] obtenerNombreTablas(int cont) {
        String dat[] = new String[3];
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        dat = metodos.obtenerNombreTablas(cont);
        return dat;

    }

    public String[] obtenerCampos(int cont, String nombreTabla) {
        String dat[] = new String[1];
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        dat = metodos.obtenerCampos(cont, nombreTabla);
        return dat;
    }

    public String[] obtenerDatosResult(int cont, String campos, String nombreTabla, String condicionWhere, String condicionOrder, int numDatos) {
        ConsultaSelect consulta = new ConsultaSelect(campos, nombreTabla, condicionWhere, condicionOrder);
        String dat[] = new String[1];
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        dat = metodos.obtenerDatosResultado(cont, consulta, numDatos);
        return dat;
    }

    public String[] instanciaRetorno(Object objeto) throws IllegalArgumentException, IllegalAccessException {
        String[] datos = new String[6];
        int contadorPosicion=0;
        for (Field f : objeto.getClass().getDeclaredFields()) {
            datos[contadorPosicion]=(String) f.get(objeto);   
        }
        return datos;
    }

    public int numeroReg(String nombreT) {
        int numRegistros = 0;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        numRegistros = metodos.numeroRegistros(nombreT);
        return numRegistros;
    }

    public int numeroPrivilegios(String nombreT, String nombreUser) {
        int numRegistros = 0;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        numRegistros = metodos.numeroPrivilegios(nombreT, nombreUser);
        return numRegistros;
    }

    public int numeroUsuarios(String nombreT) {
        int numRegistros = 0;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        numRegistros = metodos.numeroUsuarios(nombreT);
        return numRegistros;
    }

    public int numeroTablas(String nombreT) {
        int numRegistros = 0;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        numRegistros = metodos.numeroTablas(nombreT, conexion.getLogin());
        return numRegistros;
    }

    public int numeroCampos(String nombreT) {
        int numRegistros = 0;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        numRegistros = metodos.numeroCampos(nombreT);
        return numRegistros;
    }

    public String[] obtenerUsuarios(int cont) {
        String dat[] = new String[1];
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        dat = metodos.obtenerUsuarios(cont);
        return dat;
    }

    public boolean eliminarReg(String clave, String nombreT) {
        boolean validar = false;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        validar = metodos.eliminarRegistro(clave, nombreT);
        return validar;
    }

    public void editarReg(String clave, String nombreT) {
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        //metodos.editarRegistro(clave,nombreT);
    }

    public ArrayList recuperarDatos(String claveP, String nombreT) {
        ArrayList datosP = new ArrayList<>();
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        datosP = metodos.recuperarDat(claveP, nombreT);
        return datosP;
    }

    public boolean updateDatos(String[] lista, String nombreTab) {
        boolean validar = false;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        validar = metodos.updateDatos(lista, nombreTab);
        return validar;
    }

    public boolean crearUser(String login, String pass) {
        boolean validar = false;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        validar = metodos.crearUsuario(login, pass);
        return validar;
    }

    public Object cambiarUser(String login, String pass) {
        boolean validar = false;
        ConexionBD conexion = new ConexionBD(login, pass);
        return conexion.conectarBD();
        //MetodosConexion metodos = new MetodosConexion();
        //validar =metodos.cambiarUsuario(login,pass);
    }

    public boolean consultaPermisos(String accion, String permiso, String TOorFrom, String nombreUser) {
        ConsultaPermiso consulta = new ConsultaPermiso(accion, permiso, TOorFrom, nombreUser);
        boolean validar = false;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        validar = metodos.consultaPermisos(consulta);
        return validar;
    }

    public void consultaSelect(String consulta) {
        boolean validar = false;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        //metodos.consultaSelect(consulta);
        //return validar;
    }

    public int numeroRegistroResult(String consulta) {
        int numRegistros = 0;
        ConexionBD conexion = new ConexionBD();
        conexion.conectarBD();
        MetodosConexion metodos = new MetodosConexion();
        numRegistros = metodos.numeroRegistroResultado(consulta);
        return numRegistros;
    }
}
