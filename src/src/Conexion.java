/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    static String dbh = "Bdhotel2";
    //almacenamiento de la cadena de conexión
    static String url = "jdbc:mysql://127.0.0.1/" + dbh;
    static String user = "root";
    static String pass = "";

    //constructor en blanco
    public Conexion() {
    }

    //función para conectarce a la base de datos
    public Connection conectar() {
        Connection link = null;
        //capturador de errores  
        try {
            //driver de la conexión        
            Class.forName("com.mysql.jdbc.Driver");
            //enlace base de datos        
            link = DriverManager.getConnection(url, user, pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error creando la conexión\n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);

        }
        //retornar cadena de conexión    
        return link;
    }

}
