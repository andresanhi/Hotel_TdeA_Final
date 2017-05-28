/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    public String db = "basereserva";
    //almacenamiento de la cadena de coneccion
    public String url = "jdbc:mysql://127.0.0.1/" + db;
    public String user = "root";
    public String pass = "";

    //constructor en blanco
    public Conexion() {
    }

    //funcion para conectarce a la base de datos
    public Connection conectar() {
        Connection link = null;
        //capturador de errores  
        try {
            //driver de la conexión        
            Class.forName("org.gjt.mm.mysql.Driver");
            //enlace base de datos        
            link = DriverManager.getConnection(this.url, this.user, this.pass);

        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showConfirmDialog(null, e);

        }
        //retornar cadena de conexión    
        return link;
    }
 
}
