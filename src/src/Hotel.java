package src;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Hotel {

    public DefaultTableModel mostrarHabitaciones(String fIngreso, String fSalida) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            //Crea la cadena de conexión y la sentencia SQL para buscar las habitaciones.
            String SQL = "SELECT h.num_habitacion,h.capacidad, h.tipo_habitacion, \n"
                    + "CASE WHEN A.numHabitacion IS NOT NULL THEN 'Ocupada' ELSE 'Disponible' END as estado,\n"
                    + "h.precio_noche\n"
                    + "FROM tblhabitaciones h\n"
                    + "LEFT JOIN \n"
                    + "(SELECT DISTINCT numHabitacion\n"
                    + "FROM tblreservas\n"
                    + "WHERE fecha_ingreso >= ? AND fecha_salida <= ?) A ON h.num_habitacion = A.numHabitacion";
            Conexion con = new Conexion();
            Connection link = con.conectar();
            //compila la sentencia SQL
            PreparedStatement pSQL = link.prepareStatement(SQL);
            //Asigna parámetros a la sentencia.
            pSQL.setString(1, fIngreso);
            pSQL.setString(2, fSalida);
            //Almacena resultado en un result set
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            //Pasa el result set al modelo tabla para obtenerlo como modelo
            modelo = mt.generarModelo(rs);

            //Cierra las variables de conexiones
            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al momento de cargar la grid de habitaciones\n" + e, "ALERTA", JOptionPane.ERROR_MESSAGE);
        }
        //Retornamos el modelo
        return (modelo);
    }

}
