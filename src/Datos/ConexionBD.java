/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Datos;

import static Datos.MetodosConexion.conn;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Christian
 */
public class ConexionBD {
    static String bd = "XE";
    static String url = "jdbc:oracle:thin:@localhost:1521:XE";
    static String login = "usuario1";
    static String password = "clave1";

    public ConexionBD() {
    }

    public ConexionBD(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public Connection conectarBD() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection(url, login, password);
            System.out.println("Conectado exitosamente");
        } catch (ClassNotFoundException | SQLException e) {
            conn = null;
        }
        return conn;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    

    
}
