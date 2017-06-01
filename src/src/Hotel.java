package src;

import com.sun.xml.internal.ws.api.addressing.WSEndpointReference;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import src.Habitaciones;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Hotel {

    Scanner sc = new Scanner(System.in);
    private static ArrayList<Habitaciones> rooms = new ArrayList<>();

    public void generarMenu() {
        String nombreHotel, nit;
        int opc = 0;
        nombreHotel = "HOSTAL EL PASANTE";
        nit = "12345567";
        String banner = "==================";

        System.out.println(banner + " SISTEMA DE INFORMACIÓN " + " " + banner + "\n" + banner + "    " + nombreHotel + "    " + banner);
        System.out.println("1. Reservar\n2. Registrar Ingreso\n3. Imprimir Factura\n4. Cliente Preferencial\n5. Salir");
        System.out.println(banner + banner + banner + "=======    ");
        opc = sc.nextInt();

        switch (opc) {
            case 1:
                //Reserva r = new Reserva();
                //r.GenerarReserva();
                break;
            case 2:
                Ingreso c = new Ingreso();
                c.generarIngreso();
                break;
            case 3:
                //Factura f = new Factura();
                //f.generarFactura();
                break;
            case 4:
                ClientePref cp = new ClientePref();
                //cp.crearClientePref();
                break;
            case 5:
                System.out.println("Gracias por utilizar nuestros servicios, ADIOS");
                System.exit(0);
                break;
            default:
                System.out.println("Esta opción no es válida");
                break;
        }
    }

    public DefaultTableModel mostrarHabitaciones(String fIngreso) {
        DefaultTableModel modelo = new DefaultTableModel();
        try {
            String SQL = "SELECT num_habitacion,capacidad, h.tipo_habitacion, \n"
                    +"CASE WHEN r.fecha_ingreso >= ? AND r.fecha_ingreso <= ? THEN 'Ocupada' ELSE 'Disponible' END as estado, precio_noche\n"
                    +"FROM tblHabitaciones h\n"
                    +"LEFT JOIN tblreservas r ON h.num_habitacion = r.numhabitacion";
            Conexion con = new Conexion();
            Connection link = con.conectar();
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setString(1, fIngreso);
            pSQL.setString(2, fIngreso);
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            modelo = mt.generarModelo(rs);

            link.close();
            pSQL.close();
            rs.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al momento de cargar la grid de habitaciones\n" + e, "ALERTA", JOptionPane.ERROR_MESSAGE);
        }
        return(modelo);
    }

    public Object buscarDisponiblidad() {
        Object[] precios = null;
        try {
            String SQL = "";
            Conexion con = new Conexion();
            Connection link = con.conectar();
            PreparedStatement pSQL = link.prepareStatement(SQL);
            ResultSet rs = pSQL.executeQuery();
            int ta = rs.getMetaData().getColumnCount();
            while (rs.next()) {
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    precios[i] = rs.getString(i + 1);
                }
            }

        } catch (Exception e) {
        }
        return (precios);
    }

}
