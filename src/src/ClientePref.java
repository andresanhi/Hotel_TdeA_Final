package src;

// @author Jhony_Angulo
import Pantallas.Menu;
import Pantallas.P_Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import src.ClientePref;

public class ClientePref {

    private static ArrayList<Clientes> cliente = new ArrayList<Clientes>();
    Scanner sc = new Scanner(System.in);

    public boolean validarExistencia(String cc) {
        boolean insertar = false;
        try {
            Conexion con = new Conexion();
            Connection link = con.conectar();
            String SQL = "SELECT documento FROM tblClientes WHERE documento = ?";
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setString(1, cc);
            ResultSet res = pSQL.executeQuery();
            if (!res.next()) {
                insertar = true;
            }
            link.close();
            pSQL.close();
            res.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error validando existencia\n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return (insertar);
    }

    public int crearClientePref(String nombre, int tipo, String cc, int telefono, String mail) {
        // Creo un objeto de la vista que se llama P_Clientes
        P_Clientes pc = new P_Clientes();
        Connection link = null;
        Conexion con = new Conexion();
        String SQL = null;
        //Líneas SQL para insertar datos
        SQL = "INSERT INTO tblClientes(idCliente, nombre, tipo, documento, telefono, email, hospedaje)"
                + "VALUES (DEFAULT,?,?,?,?,?,0)";
        //Inserción en la base de datos en la tabla tblClientes
        try {
            link = con.conectar();
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setString(1, nombre);
            pSQL.setInt(2, tipo);
            pSQL.setString(3, cc);
            pSQL.setInt(4, telefono);
            pSQL.setString(5, mail);

            pSQL.executeUpdate();
            pSQL.close();
            //Después de crearlo se pregunta si quiere crear otro y devuelve a la pantalla la opción.

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al intentar almacenar el cliente:\n"
                    + e, "ERROR", JOptionPane.ERROR_MESSAGE);
            // Después de ejecutar la instrucción se cierra la conexión.
        } finally {
            try {
                if (con != null) {
                    link.close();
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al intentar cerrar la conexión:\n"
                        + ex, "Error en la operación", JOptionPane.ERROR_MESSAGE);
            }
        }
        int opc = JOptionPane.showConfirmDialog(null, "Cliente creado exitosamente\n¿Desea crear otro cliente?", "CONFIRMACIÓN", 0, 1);
        return (opc);
    }

    public double generarDescuento(String tipo, double subtotal, int cc) {
        double dctoFinal = 0;
        double dctoSuite = 0.04, dcto1 = 0;
        double dctoEstandar = 0.025, dcto2 = 0;
        double dctoCamaExtra = 0.10, dcto3 = 0;
        int veces;

        if (cliente.contains(cc) == true) {
            veces = cliente.get(cliente.indexOf(cc)).hospedajes;

            if (veces > 1) {
                if (tipo == "Suite") {
                    dcto1 = subtotal * dctoSuite;
                } else if (tipo == "Estándar") {
                    dcto2 = subtotal * dctoEstandar;
                } else {
                    dcto3 = subtotal * dctoCamaExtra;
                }
            }
        }
        dctoFinal = dcto1 + dcto2 + dcto3;
        return (dctoFinal);
    }

    public DefaultTableModel mostrarClientes() {
        DefaultTableModel modelo = new DefaultTableModel();
        Connection link = null;
        Conexion con = new Conexion();
        String SQL = "SELECT nombre,\n"
                + "CASE WHEN tipo = 1 THEN \"Cédula de ciudadanía\"\n"
                + "     WHEN tipo = 2 THEN \"Cédula extranjería\"\n"
                + "     WHEN tipo = 3 THEN \"Pasaporte\" END as tipo,documento,telefono,email, hospedaje FROM tblclientes";
        try {
            link = con.conectar();
            PreparedStatement pSQL = link.prepareStatement(SQL);
            ResultSet res = pSQL.executeQuery(SQL);
            ModeloTabla mt = new ModeloTabla();
            modelo = mt.generarModelo(res);

            res.close();
            link.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al momento de cargar la grid de clientes\n" + e, "ALERTA", JOptionPane.ERROR_MESSAGE);
        }
        return (modelo);
    }

    public DefaultTableModel buscarCliente(String cc) {
        DefaultTableModel modelo = new DefaultTableModel();
        String SQL = "SELECT nombre,\n"
                + "CASE WHEN tipo = 1 THEN \"Cédula de ciudadanía\"\n"
                + "     WHEN tipo = 2 THEN \"Cédula extranjería\"\n"
                + "     WHEN tipo = 3 THEN \"Pasaporte\" END as tipo,documento,telefono,email, hospedaje FROM tblclientes WHERE documento = ?";
        try {
            Conexion con = new Conexion();
            Connection link = con.conectar();
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setString(1, cc);
            ResultSet rs = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            modelo = mt.generarModelo(rs);
            /*if (!rs.next()) {
                JOptionPane.showConfirmDialog(null, "No se encontró ningún cliente con el documento: " + cc, "ALERTA", JOptionPane.WARNING_MESSAGE);
            }*/
            
            link.close();
            rs.close();
            pSQL.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha presentado un error generando la búsqueda\n" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return (modelo);
    }

    public String validarDocumento(int pos) {
        String tipoDoc = "";
        if (cliente.get(pos).tipo == 1) {
            tipoDoc = "Cédula Ciudadanía";
        } else if (cliente.get(pos).tipo == 2) {
            tipoDoc = "Cédula Extranjería";
        } else if (cliente.get(pos).tipo == 3) {
            tipoDoc = "Pasaporte";
        }
        return (tipoDoc);
    }
}
