package src;

import Pantallas.P_Ingreso;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import src.Reservas;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reserva {

    public int generarReserva(int esreserva, int tipo, String documento, String nombre, int tel, int numAcom, String fingreso, String fsalida, String tipohab, double precionoche, int noches) {
        int NumRes = 0;
        try {
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "INSERT INTO tblreservas (idReservas, cliente, tipo, documento, telefono, num_acompanantes,fecha_ingreso,fecha_salida,noches,tipo_habitacion, precioXnoche,es_reserva, numFactura)"
                    + "VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?,NULL)";
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
            pSQL.setDouble(10, precionoche);
            pSQL.setInt(11, esreserva);

            pSQL.executeUpdate();

            try {
                String SQL2 = "SELECT MAX(idReservas) as IdReserva FROM tblReservas";
                PreparedStatement pSQL2 = link.prepareStatement(SQL2);
                ResultSet rs = pSQL2.executeQuery();
                if (rs.next()) {
                    NumRes = Integer.valueOf(rs.getString("IdReserva"));
                }
                pSQL2.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error recuperando número de reserva" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }
            System.out.println("Reserva insertado");
            link.close();
            pSQL.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando la reserva\n" + e, "ERRROR", JOptionPane.ERROR_MESSAGE);
        }
        return (NumRes);
    }

    public DefaultTableModel mostrarReservas() {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT * FROM tblReservas";
            PreparedStatement pSQL = link.prepareStatement(SQL);
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            modelo = mt.generarModelo(rs);

            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error generando las reservas" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return (modelo);
    }

    public DefaultTableModel buscarReserva(int numReserva) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT * FROM tblReservas WHERE idReservas = ?";
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setInt(1, numReserva);
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            modelo = mt.generarModelo(rs);

            //JOptionPane.showMessageDialog(null, "No se encontraron reservas con el número " + numReserva, "ATENCIÓN", 1);                
            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error buscando la reserva " + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return (modelo);
    }

    public void eliminarReserva(int codRes) {

    }

    public void activarReserva(int codRes) {

    }
}
