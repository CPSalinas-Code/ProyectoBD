/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import Negocios.Personas;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class MetodosConexion {

    static Connection conn = null;
    static Statement stmt = null;
    static ResultSet rest = null;
    static String consulta;

    public boolean insertar(Object objeto) {
        boolean validar = false;
        String tabla = objeto.getClass().getSimpleName();
        String valores = "";
        consulta = "insert into usuario1." + tabla + " values (";
        System.out.println(consulta);
        try {
            for (Field f : objeto.getClass().getDeclaredFields()) {
                valores += "'" + (String) f.get(objeto) + "'" + ",";
                System.out.println(valores);
            }
            valores = valores.substring(0, valores.length() - 1);
            valores = valores + ")";
            consulta = consulta + valores;
            System.out.println(consulta);
            stmt = conn.createStatement();
            rest = stmt.executeQuery(consulta);
            System.out.println("Tablas ingresadas correctamente");
            validar = true;
        } catch (Exception e) {
            System.out.println("ERROR AL INSERTAR LOS DATOS Persona");
            validar = false;
        }
        return validar;
    }

    public String [] obtenerDatosPersona(int cont) {
        String dat[] = new String[6];
        Object objeto= null;
        try {
            /*stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from usuario1.Personas");
            rest.next();
            objeto= null;
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    objeto=rest.getString(1);
                    objeto+=rest.getString(2);
                    objeto+=rest.getString(3);
                    objeto+=rest.getString(4);
                    objeto+=rest.getString(5);
                    objeto+=rest.getString(6);
                    cont--;
                }
            }*/
            
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from usuario1.Personas");
            rest.next();
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    cont--;

                }
            }
            dat[0] = rest.getString(1);
            dat[1] = rest.getString(2);
            dat[2] = rest.getString(3);
            dat[3] = rest.getString(4);
            dat[4] = rest.getString(5);
            dat[5] = rest.getString(6);

        } catch (Exception e) {
            System.out.println("Clase MetodosConexion: ERROR AL OBTENER LOS DATOS de Personas");
            dat[0] = null;
        }
        return dat;
    }

    public String[] obtenerDatosEdificio(int cont) {
        String dat[] = new String[4];
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from usuario1.Edificios");
            rest.next();
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    cont--;

                }
            }
            dat[0] = rest.getString(1);
            dat[1] = rest.getString(2);
            dat[2] = rest.getString(3);
            dat[3] = rest.getString(4);

        } catch (Exception e) {
            System.out.println("Clase MetodosConexion: ERROR AL OBTENER LOS DATOS de Edificios");
            //JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS DATOS de Edificios");
            dat[0] = null;

        }
        return dat;
    }

    public String[] obtenerDatosCiudades(int cont) {
        String dat[] = new String[5];
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from usuario1.Ciudades");
            rest.next();
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    cont--;

                }
            }
            dat[0] = rest.getString(1);
            dat[1] = rest.getString(2);
            dat[2] = rest.getString(3);
            dat[3] = rest.getString(4);
            dat[4] = rest.getString(5);

        } catch (Exception e) {
            System.out.println("Clase MetodosConexions: ERROR AL OBTENER LOS DATOS de Ciudades");
            //JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS DATOS de Ciudades");
            dat[0] = null;
        }
        return dat;
    }

    public String[] obtenerUsuarios(int cont) {
        String dat[] = new String[1];
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from all_users");
            rest.next();
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    cont--;
                }
            }
            dat[0] = rest.getString(1);

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER LOS USUARIOS");
            //JOptionPane.showConfirmDialog(null, e);
            dat[0] = null;

        }
        return dat;
    }

    public String[] obtenerDatosPrivilegios(int cont, String nombreTab) {
        String dat[] = new String[3];
        try {
            stmt = conn.createStatement();
            System.out.println(nombreTab);
            rest = stmt.executeQuery("select * from dba_sys_privs where grantee = '" + nombreTab + "'");
            rest.next();
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    cont--;
                }
            }
            dat[0] = rest.getString(1);
            dat[1] = rest.getString(2);
            dat[2] = rest.getString(3);

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER LOS PERMISOS DE LA TABLA SOLICITADA");
            //JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS PERMISOS DE LA TABLA SOLICITADA");
            dat[0] = null;

        }
        return dat;
    }

    public String[] obtenerNombreTablas(int cont) {
        String dat[] = new String[3];
        try {
            stmt = conn.createStatement();
            //System.out.println(nombreTab);
            rest = stmt.executeQuery("select table_name from user_tables");
            rest.next();
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    cont--;
                }
            }
            dat[0] = rest.getString(1);

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER LOS PERMISOS DE LA TABLA SOLICITADA");
            //JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS PERMISOS DE LA TABLA SOLICITADA");
            dat[0] = null;

        }
        return dat;
    }

    public String[] obtenerCampos(int cont, String nombreTab) {
        String dat[] = new String[1];
        try {
            stmt = conn.createStatement();
            //System.out.println(nombreTab);
            rest = stmt.executeQuery("select column_name from all_tab_columns where table_name = '" + nombreTab + "' ");
            rest.next();
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    cont--;
                }
            }
            dat[0] = rest.getString(1);

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER LOS PERMISOS DE LA TABLA SOLICITADA");
            //JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS PERMISOS DE LA TABLA SOLICITADA");
            dat[0] = null;

        }
        return dat;
    }

    public String[] obtenerDatosResultado(int cont, Object objeto, int numeroDatos) {
        String dat[] = new String[numeroDatos];
        String cadenaConsulta="";
        try {
            int contador = 0;
            String camposConsulta="";
            String nombreTablaConsulta="";
            String whereConsulta="";
            String orderConsulta="";
            for (Field f : objeto.getClass().getDeclaredFields()) {
                if (contador ==0){
                    camposConsulta=(String) f.get(objeto);
                }else if(contador==1){
                    nombreTablaConsulta=(String) f.get(objeto);
                }else if(contador==2){
                    whereConsulta=(String) f.get(objeto);
                }else if(contador==3){
                    orderConsulta=(String) f.get(objeto);
                }
                contador++;
            }
            if(whereConsulta.isEmpty() && orderConsulta.isEmpty()){
                cadenaConsulta = "select "+camposConsulta+" from "+nombreTablaConsulta;
            }else if (whereConsulta.isEmpty() && orderConsulta.isEmpty()==false){
                cadenaConsulta = "select "+camposConsulta+" from "+nombreTablaConsulta+" order by "+orderConsulta;
            }else if (whereConsulta.isEmpty()==false && orderConsulta.isEmpty()){
                cadenaConsulta = "select "+camposConsulta+" from "+nombreTablaConsulta+" where "+whereConsulta;
            }else if (whereConsulta.isEmpty()==false && orderConsulta.isEmpty()==false){
                cadenaConsulta = "select "+camposConsulta+" from "+nombreTablaConsulta+" where "+whereConsulta+" order by "+orderConsulta;
            }
            stmt = conn.createStatement();
            //System.out.println(nombreTab);
            rest = stmt.executeQuery(cadenaConsulta);
            rest.next();
            if (cont > 0) {
                while (cont != 0) {
                    rest.next();
                    cont--;
                }
            }
            int contadorPosiscion = 0;
            while (contadorPosiscion < numeroDatos) {
                dat[contadorPosiscion] = rest.getString(contadorPosiscion + 1);
                contadorPosiscion++;
            }

        } catch (Exception e) {
            System.out.println("ERROR AL OBTENER LOS PERMISOS DE LA TABLA SOLICITADA");
            //JOptionPane.showMessageDialog(null, "ERROR AL OBTENER LOS PERMISOS DE LA TABLA SOLICITADA");
            dat[0] = null;

        }
        return dat;
    }

    public int numeroRegistros(String nombreTa) {
        int numeroRegistros = 0;
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from usuario1." + nombreTa);
            while (rest.next()) {
                numeroRegistros++;
            }
        } catch (Exception e) {
            System.out.println("ERROR AL Contar LOS DATOS numeroRegistros");
            //JOptionPane.showMessageDialog(null, "ERROR AL Contar LOS DATOS numeroRegistros");
            numeroRegistros = 0;

        }
        return numeroRegistros;
    }

    public int numeroUsuarios(String nombreTa) {
        int numeroRegistros = 0;
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from " + nombreTa);
            while (rest.next()) {
                numeroRegistros++;
            }
        } catch (Exception e) {
            System.out.println("ERROR AL Contar LOS DATOS numeroUsuarios");
            //JOptionPane.showMessageDialog(null, "ERROR AL Contar LOS DATOS numeroUsuarios");
            numeroRegistros = 0;

        }
        return numeroRegistros;
    }

    public int numeroPrivilegios(String nombreTa, String nombreUser) {
        int numeroRegistros = 0;
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from dba_sys_privs where grantee = '" + nombreUser + "'");
            while (rest.next()) {
                numeroRegistros++;
            }
        } catch (Exception e) {
            System.out.println("Clase MetodosConexion: Error al contar los priveliegios del usuario");
            //JOptionPane.showMessageDialog(null, "Error al contar los priveliegios del usuario");
            numeroRegistros = 0;

        }
        return numeroRegistros;
    }

    public int numeroTablas(String nombreTa, String nombreUser) {
        int numeroRegistros = 0;
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select table_name from user_tables");
            while (rest.next()) {
                numeroRegistros++;
            }
        } catch (Exception e) {
            System.out.println("Error al contar numero de tablas del usuario");
            //JOptionPane.showMessageDialog(null, "Error al contar numero de tablas del usuario");
            numeroRegistros = 0;

        }
        return numeroRegistros;
    }

    public int numeroCampos(String nombreTab) {
        int numeroRegistros = 0;
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select column_name from all_tab_columns where table_name = '" + nombreTab + "' ");
            while (rest.next()) {
                numeroRegistros++;
            }
        } catch (Exception e) {
            System.out.println("Error al contar numero de campos de tabla");
            //JOptionPane.showMessageDialog(null, "Error al contar numero de campos de tabla");
            numeroRegistros = 0;
        }
        return numeroRegistros;
    }

    public int numeroRegistroResultado(String cadenaConsulta) {
        int numeroRegistros = 0;
        try {
            stmt = conn.createStatement();
            rest = stmt.executeQuery(cadenaConsulta);
            while (rest.next()) {
                numeroRegistros++;
            }
        } catch (Exception e) {
            System.out.println("Error al contar los registros Resultantes de la consulta total");
            //JOptionPane.showMessageDialog(null, "Error al contar los registros Resultantes dela consulta total");
            numeroRegistros = 0;

        }
        return numeroRegistros;
    }

    public boolean eliminarRegistro(String id, String nomTabla) {
        boolean validar = false;
        String identificador;
        try {
            if (nomTabla.equals("Ciudades")) {
                identificador = nomTabla.substring(0, nomTabla.length() - 2);
                System.out.println(id);
            } else {
                identificador = nomTabla.substring(0, nomTabla.length() - 1);
                System.out.println(id);
            }
            int numReg = numeroRegistros(nomTabla);
            stmt = conn.createStatement();
            rest = stmt.executeQuery("delete from usuario1." + nomTabla + " where id_" + identificador + " = '" + id + "'");
            int numRegDespues = numeroRegistros(nomTabla);
            if (numReg == numRegDespues) {
                //JOptionPane.showMessageDialog(null, "Registro no Encontrado");
                validar = false;
            } else {
                //JOptionPane.showMessageDialog(null, "Registro Eliminado");
                validar = true;
            }
            //System.out.println(rest);
            //JOptionPane.showMessageDialog(null, "Registro Eliminado");
        } catch (Exception e) {
            System.out.println("Clase MetodoConexion: ID no encontrado");
            //JOptionPane.showConfirmDialog(null, e);
            validar = false;

        }
        return validar;
    }

    public ArrayList recuperarDat(String clave, String nombreTabla) {
        ArrayList dat = new ArrayList<>();
        //String dat[] = new String[6];
        String id;
        try {
            if (nombreTabla.equals("Ciudades")) {
                id = nombreTabla.substring(0, nombreTabla.length() - 2);
                System.out.println(id);
            } else {
                id = nombreTabla.substring(0, nombreTabla.length() - 1);
                System.out.println(id);
            }
            int numReg = numeroRegistros(nombreTabla);
            stmt = conn.createStatement();
            rest = stmt.executeQuery("select * from usuario1." + nombreTabla + " where id_" + id + " = '" + clave + "'");
            rest.next();
            if (nombreTabla.equals("Personas")) {
                dat.add(rest.getString(1));
                dat.add(rest.getString(2));
                dat.add(rest.getString(3));
                dat.add(rest.getString(4));
                dat.add(rest.getString(5));
                dat.add(rest.getString(6));
            } else if (nombreTabla.equals("Edificios")) {
                dat.add(rest.getString(1));
                dat.add(rest.getString(2));
                dat.add(rest.getString(3));
                dat.add(rest.getString(4));
            } else if (nombreTabla.equals("Ciudades")) {
                dat.add(rest.getString(1));
                dat.add(rest.getString(2));
                dat.add(rest.getString(3));
                dat.add(rest.getString(4));
                dat.add(rest.getString(5));
            }

        } catch (Exception e) {
            System.out.println("ID no encontrado");
            //JOptionPane.showConfirmDialog(null, "ID no encontrado");
            //dat=null;

        }
        return dat;
    }

    public boolean updateDatos(String[] datos, String nombreTabla) {
        boolean validar = false;
        String consultaUPDATE = "";
        if (nombreTabla.equals("Personas")) {
            consultaUPDATE = "update usuario1." + nombreTabla + " set nombre_persona = '" + datos[1] + "', apellido_persona = '" + datos[2]
                    + "', direccion_persona = '" + datos[3] + "', telefono_persona = '" + datos[4] + "', f_nacimiento = '" + datos[5] + "' where id_persona = '"
                    + datos[0] + "'";
        } else if (nombreTabla.equals("Edificios")) {
            consultaUPDATE = "update usuario1." + nombreTabla + " set nombre_edificio = '" + datos[1] + "', direccion_edificio = '" + datos[2]
                    + "', num_pisos = '" + datos[3] + "' where id_edificio = '" + datos[0] + "'";
        } else if (nombreTabla.equals("Ciudades")) {
            consultaUPDATE = "update usuario1." + nombreTabla + " set nombre_ciudad = '" + datos[1] + "', estado = '" + datos[2]
                    + "', pais = '" + datos[3] + "', num_habitantes = '" + datos[4] + "' where id_ciudad = '" + datos[0] + "'";
        }

        try {
            System.out.println(consultaUPDATE);
            int numReg = numeroRegistros(nombreTabla);
            stmt = conn.createStatement();
            rest = stmt.executeQuery(consultaUPDATE);
            //JOptionPane.showMessageDialog(null, "Datos Modificados");
            validar = true;
        } catch (Exception e) {
            System.out.println("Modificaexception");
            //JOptionPane.showConfirmDialog(null, "Datos no Modificados");
            validar = false;

        }
        return validar;
    }

    public boolean crearUsuario(String login, String password) {
        boolean validar = false;
        String consultaCrear = "create user " + login + " identified by " + password + " default tablespace tablespace_1";
        String permisos = "grant connect,resource to " + login;
        try {
            System.out.println(consultaCrear);
            stmt = conn.createStatement();
            rest = stmt.executeQuery(consultaCrear);
            rest = stmt.executeQuery(permisos);
            validar = true;
        } catch (Exception e) {
            System.out.println("Crear User Exception");
            validar = false;
        }
        return validar;
    }

    public boolean consultaPermisos(Object objeto) {
        boolean validar = false;
        String consult="";
        
        try {
            
            for (Field f : objeto.getClass().getDeclaredFields()) {

                consult += (String) f.get(objeto) + " ";
                
            }
            System.out.println(consult);
            
            
            System.out.println(consult);
            stmt = conn.createStatement();
            rest = stmt.executeQuery(consult);
            validar = true;
        } catch (Exception e) {
            System.out.println("Consulta Provilegio Error");
            validar = false;
        }
        return validar;
    }

}
