package src;

import Pantallas.P_Ingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reserva {

    //Inserta en la BDD una reserva
    public int generarReserva(int esreserva, int tipo, String documento, String nombre, int tel, int numAcom, String fingreso, String fsalida, String tipohab, int noches, int numHabitacion) {
        int NumRes = 0;
        try {
            // Se crea la cadena de conexión y la sentencia SQL
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "INSERT INTO tblreservas (idReservas, cliente, tipo, documento, telefono, num_acompanantes,fecha_ingreso,fecha_salida,noches,tipo_habitacion, es_reserva, numFactura, numHabitacion,estado)"
                    + "VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,NULL,?,0)";
            // Se compila la sentencia SQL y se setean parámetros.
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setString(1, nombre);
            pSQL.setInt(2, tipo);
            pSQL.setString(3, documento);
            pSQL.setInt(4, tel);
            pSQL.setInt(5, numAcom);
            pSQL.setString(6, fingreso);
            pSQL.setString(7, fsalida);
            pSQL.setInt(8, noches);
            pSQL.setString(9, tipohab);
            pSQL.setInt(10, esreserva);
            pSQL.setInt(11, numHabitacion);

            // Se ejecuta la sentencia SQL
            pSQL.executeUpdate();

            try {
                // Se crea sentencia SQL2 para consulta el máximo id de las reservas
                String SQL2 = "SELECT MAX(idReservas) as IdReserva FROM tblReservas";
                PreparedStatement pSQL2 = link.prepareStatement(SQL2);
                ResultSet rs = pSQL2.executeQuery();
                if (rs.next()) {
                    //Se toma el valor del máximo id de las reservas
                    NumRes = Integer.valueOf(rs.getString("IdReserva"));
                }
                pSQL2.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error recuperando número de reserva" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            link.close();
            pSQL.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando la reserva\n" + e, "ERRROR", JOptionPane.ERROR_MESSAGE);
        }
        //Se retorna el número de la reserva creada
        return (NumRes);
    }

    //Busca y muestra todas las reservas.
    public DefaultTableModel mostrarReservas() {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            //Se crea cadena de conexión y sentencia SQL para consultar las reservas sin activar (estado = 0)
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT idreservas,cliente,\n"
                    + " CASE WHEN tipo = 1 THEN \"Cédula de ciudadanía\"\n"
                    + "     WHEN tipo = 2 THEN \"Cédula extranjería\"\n"
                    + "     WHEN tipo = 3 THEN \"Pasaporte\" END as tipo, documento, telefono, numHabitacion, tipo_habitacion ,num_acompanantes, fecha_ingreso, fecha_salida, noches\n"
                    + "      FROM tblReservas\n"
                    + "WHERE estado = 0";
            //Se compila sentencia SQL
            PreparedStatement pSQL = link.prepareStatement(SQL);
            //Se almacena en resultset el resultado de la query
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            //se pasa el result set por el modelo tabla para su conversión
            modelo = mt.generarModelo(rs);

            // Se cierran variables de conexiones
            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando las reservas" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        // Se retorna el modelo
        return (modelo);
    }

    //Busca una reserva, recibe como parámetro el número de la reserva
    public DefaultTableModel buscarReserva(int numReserva) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            // Se crea la cadena de conexión y la sentencia SQL para buscar una reserva.
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT * FROM tblReservas WHERE idReservas = ?";
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setInt(1, numReserva);
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            modelo = mt.generarModelo(rs);

            //JOptionPane.showMessageDialog(null, "No se encontraron reservas con el número " + numReserva, "ATENCIÓN", 1);                
            // Se cierran las variables de conexión.
            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando la reserva " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        // se retorna el modelo.
        return (modelo);
    }
 
    // Devuelve las reservas a facturar, con estado = 1 es decir, activas.
    public DefaultTableModel buscarReservaFV(String doc) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            // Se crea la sentencia SQL y la cadena de conexión.
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT r.numHabitacion, h.tipo_habitacion, r.noches,r.num_acompanantes, h.precio_noche,\n"
                    + "       CASE WHEN c.hospedaje>1 AND h.tipo_habitacion = \"Suite\" THEN (r.noches*h.precio_noche) * 0.04\n"
                    + "            WHEN c.hospedaje>1 AND h.tipo_habitacion = \"Estándar\" THEN (r.noches*h.precio_noche)* 0.025\n"
                    + "            ELSE 0\n"
                    + "            END as Descuento\n"
                    + "            ,(r.noches * h.precio_noche)  as Subtotal,r.idreservas\n"
                    + "            FROM tblReservas r \n"
                    + "            INNER JOIN tblhabitaciones h ON r.numHabitacion = h.num_habitacion\n"
                    + "            LEFT JOIN tblclientes c ON r.documento = c.documento\n"
                    + "            WHERE r.documento = ? AND numFactura IS NULL AND r.estado = 1";
            // se compila la sentencia SQL
            PreparedStatement pSQL = link.prepareStatement(SQL);
            // Se pone parámetros
            pSQL.setString(1, doc);
            //Almacena resultado en un result set
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            //Pasa resultset al modelo tabla para convertirlo en modelo.
            modelo = mt.generarModelo(rs);

            //JOptionPane.showMessageDialog(null, "No se encontraron reservas activas con el número " + numReserva, "ATENCIÓN", 1);                
            
            //Cierra la cadena de conexión.
            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando la reserva " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        //Retorna el modelo
        return (modelo);
    }

    //Busca el cliente al que se le va a facturar
    public String buscarCliente(String doc) {
        String cliente = null;
        try {
            //Crea la cadena de conexión.
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT cliente\n"
                    + "FROM tblReservas\n"
                    + "WHERE documento = ? ";
            //Compila la cadena de conexión.
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setString(1, doc);
            //Almacena el resultado en un result set.
            ResultSet rs = pSQL.executeQuery();
            if (rs.next()) {
                cliente = rs.getString("cliente");
            }

            //JOptionPane.showMessageDialog(null, "No se encontraron reservas activas con el número " + numReserva, "ATENCIÓN", 1);                
            //Cierra las conexiones a la base de datos.
            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando el cliente " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        //Retorna el cliente
        return (cliente);
    }

    //Elimina una reserva, recibe como parámetro el código de la reserva.
    public void eliminarReserva(int codRes) {
        try {
            //Crea la cadena de conexión a la base de datos y la sentencia SQL
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "DELETE FROM tblreservas WHERE idreservas = ?";
            //Compila la sentencia SQL
            PreparedStatement pSQL = link.prepareStatement(SQL);
            //Setea el parámetro
            pSQL.setInt(1, codRes);
            //Ejecuta la sentencia SQL
            pSQL.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha eliminado la reserva satisfactoriamente", "CONFIRMACIÓN", 1);

            //Cierra las conexiones.
            link.close();
            pSQL.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error eliminando la reserva " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    //Activa una reserva, recibe como parámetro el código de reserva a activar.
    public void activarReserva(int codRes) {
        try {
            //Crea la cadena de conexión y la sentencia SQL que va actualizar en BDD
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "UPDATE tblreservas SET estado = 1 WHERE idreservas = ?";
            //Compila la sentencia SQL
            PreparedStatement pSQL = link.prepareStatement(SQL);
            //Se asigna el parámetro
            pSQL.setInt(1, codRes);
            //Se ejecuta
            pSQL.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se ha activado la reserva satisfactoriamente", "CONFIRMACIÓN", 1);

            //Cierra la cadena de conexión.
            link.close();
            pSQL.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error actualizando el estado de la reserva " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
