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

    private static ArrayList<Reservas> reservas = new ArrayList<Reservas>();
    Scanner sc = new Scanner(System.in);

    public int generarReserva(int esreserva,int tipo, String documento, String nombre, int tel, int numAcom, String fingreso, String fsalida, String tipohab, double precionoche, int noches) {
        int NumRes = 0;
        try {
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "INSERT INTO tblreservas (idReservas, cliente, tipo, documento, telefono, num_acompanantes,fecha_ingreso,fecha_salida,noches,tipo_habitacion, precioXnoche,es_reserva)"
                         +"VALUES (DEFAULT,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setString(1, nombre);
            pSQL.setInt(2,tipo);
            pSQL.setString(3, documento);
            pSQL.setInt(4, tel);
            pSQL.setInt(5, numAcom);
            pSQL.setString(6, fingreso);
            pSQL.setString(7, fsalida);            
            pSQL.setInt(8, noches);
            pSQL.setString(9, tipohab);
            pSQL.setDouble(10,precionoche);
            pSQL.setInt(11, esreserva);
            
            pSQL.executeUpdate();
            
            /*try {
                String SQL2 = "SELECT MAX(idReservas) as IdReserva FROM tblReservas";
                PreparedStatement pSQL2 = link.prepareStatement(SQL2);
                ResultSet rs = pSQL2.executeQuery();
                if(rs.next()){
                    NumRes = Integer.valueOf(rs.getString("IdReserva"));
                }
                pSQL2.close();
                rs.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error recuperando número de reserva" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            }*/
            System.out.println("Reserva insertado");
            link.close();
            pSQL.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error guardando la reserva\n" + e, "ERRROR", JOptionPane.ERROR_MESSAGE);
        }
        return(NumRes);
    }

    public static ArrayList<Reservas> getReservas() {
        return reservas;
    }

    public DefaultTableModel mostrarReservas() {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] titulos = {"N° Reserva", "Cédula/Nit", "Nombre", "# Habitación", "# Acompañantes", "FechaIngreso", "Noches"};
        modelo.setColumnIdentifiers(titulos);
        String[] filaReserva = new String[modelo.getColumnCount()];
        for (int i = 0; i < reservas.size(); i++) {
            filaReserva[0] = String.valueOf(reservas.get(i).numReserva);
            filaReserva[1] = String.valueOf(reservas.get(i).ccn);
            filaReserva[2] = reservas.get(i).nombren;
            filaReserva[3] = String.valueOf(reservas.get(i).numHabitacion);
            filaReserva[4] = String.valueOf(reservas.get(i).cantpersonas);
            filaReserva[5] = reservas.get(i).fechaingreso;
            filaReserva[6] = String.valueOf(reservas.get(i).cantnoches);
            modelo.addRow(filaReserva);
        }
        return (modelo);
    }

    public DefaultTableModel buscarReserva(int numReserva) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] titulos = {"N° Reserva", "Cédula/Nit", "Nombre", "# Habitación", "# Acompañantes", "FechaIngreso", "Noches"};
        modelo.setColumnIdentifiers(titulos);
        String[] filaReserva = new String[modelo.getColumnCount()];
        Iterator it = reservas.iterator();
        while (it.hasNext()) {
            Reservas re = (Reservas) it.next();
            if (re.numReserva == numReserva) {
                int pos = reservas.indexOf(re);
                filaReserva[0] = String.valueOf(reservas.get(pos).numReserva);
                filaReserva[1] = String.valueOf(reservas.get(pos).ccn);
                filaReserva[2] = reservas.get(pos).nombren;
                filaReserva[3] = String.valueOf(reservas.get(pos).numHabitacion);
                filaReserva[4] = String.valueOf(reservas.get(pos).cantpersonas);
                filaReserva[5] = reservas.get(pos).fechaingreso;
                filaReserva[6] = String.valueOf(reservas.get(pos).cantnoches);
                modelo.addRow(filaReserva);
            } else {
                JOptionPane.showMessageDialog(null, "No se encontraron datos para esta reserva", "ATENCIÓN", 0);
            }
        }
        return (modelo);
    }

    public void eliminarReserva(int codRes) {

    }

    public void activarReserva(int codRes) {

    }
}
