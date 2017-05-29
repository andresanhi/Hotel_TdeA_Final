package src;

// @author Jhony_Angulo
import Pantallas.Menu;
import Pantallas.P_Clientes;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import src.ClientePref;

public class ClientePref {

    private static ArrayList<Clientes> cliente = new ArrayList<Clientes>();
    Scanner sc = new Scanner(System.in);

    public boolean validarExistencia(String cc) {
        /*boolean insertar = true;
        boolean control = true;
        Iterator<Clientes> it = cliente.iterator();
        while (it.hasNext()) {
            Clientes i = (Clientes) it.next();
            if (i.cc == cc) {
                insertar = false;
            }
        }*/
        boolean insertar = true;
        Connection link = null;
        Conexion con = new Conexion();
        String SQL = null;
        ResultSet res = null;
        SQL = "SELECT cc FROM tblClientes WHERE cc = '" + cc + "'";
        try {
            link = con.conectar();
            PreparedStatement pSQL = link.prepareStatement(SQL);
            res = pSQL.executeQuery();
            while (res.next()) {
                String cc_tbl = res.getString("cc");
                if (cc == cc_tbl) {
                    insertar = false;
                }
            }
            link.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error validando existencia\n" + e,"ERROR",JOptionPane.ERROR_MESSAGE);
        }
        return (insertar);
    }

    public int crearClientePref(String nombre, int tipo, String cc, int telefono, String mail) {
        // Creo un objeto de la vista que se llama P_Clientes
        P_Clientes pc = new P_Clientes();
        Connection link = null;
        Conexion con = new Conexion();
        String SQL = null;
        int res = 0;
        int hospedajes = 0;
        //Creo el objeto que voy a guardar en el ArrayList llamado cliente.
        /*Clientes cl = new Clientes(tipo, cc, nombre, telefono, mail, hospedajes);
        cliente.add(cl);*/
        //Líneas SQL para insertar datos
        SQL = "INSERT INTO tblClientes(idClientes, nombre, tipo, documento, telefono, email, hospedaje)"
                + "VALUES (default,?,?,?,?,?,?)";
        //Inserción en la base de datos en la tabla tblClientes
        try {
            link = con.conectar();
            PreparedStatement pSQL = link.prepareStatement(SQL);
            pSQL.setString(1, nombre);
            pSQL.setInt(2, tipo);
            pSQL.setString(3, cc);
            pSQL.setInt(4, telefono);
            pSQL.setString(5, mail);
            pSQL.setInt(6, hospedajes);

            res = pSQL.executeUpdate();
            pSQL.close();

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
        //Después de crearlo se pregunta si quiere crear otro y devuelve a la pantalla la opción.
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
        /*String[] titulos = {"Nombre", "TipoDocumento", "N°Documento", "Teléfono", "Email", "Hospedajes"};
        modelo.setColumnIdentifiers(titulos);
        String[] filacliente = new String[modelo.getColumnCount()];
        String tipoDoc = "";
        for (int i = 0; i < cliente.size(); i++) {
            tipoDoc = validarDocumento(i);
            filacliente[0] = cliente.get(i).nombre;
            filacliente[1] = tipoDoc;
            filacliente[2] = String.valueOf(cliente.get(i).cc);
            filacliente[3] = String.valueOf(cliente.get(i).telefono);
            filacliente[4] = cliente.get(i).email;
            filacliente[5] = String.valueOf(cliente.get(i).hospedajes);
            modelo.addRow(filacliente);
        }*/
        Connection link = null;
        Conexion con = new Conexion();
        String SQL = "SELECT nombre,tipo,documento,telefono,email, hospedaje FROM tblClientes";
        ResultSet res = null;
        try {
            link = con.conectar();
            PreparedStatement pSQL = link.prepareStatement(SQL);
            res = pSQL.executeQuery();
            ModeloTabla mt = new ModeloTabla();
            modelo = mt.generarModelo(res);
            link.close();
        } catch (SQLException e) { 
            JOptionPane.showMessageDialog(null, "Error al momento de cargar la grid de clientes\n" + e,"ALERTA", JOptionPane.ERROR_MESSAGE);
        }
        return (modelo);
    }

    public DefaultTableModel buscarCliente(String cc) {
        DefaultTableModel modelo = new DefaultTableModel();
        String[] titulos = {"Nombre", "TipoDocumento", "N°Documento", "Teléfono", "Email", "Hospedajes"};
        modelo.setColumnIdentifiers(titulos);
        String[] filacliente = new String[modelo.getColumnCount()];
        String tipoDoc = "";
        Iterator it = cliente.iterator();
        while (it.hasNext()) {
            Clientes c = (Clientes) it.next();
            System.out.println(c.cc);
            /*if (c.cc == cc) {
                System.out.println("Cliente existe");
                tipoDoc = validarDocumento(c.tipo);
                filacliente[0] = c.nombre;
                filacliente[1] = tipoDoc;
                filacliente[2] = String.valueOf(c.cc);
                filacliente[3] = String.valueOf(c.telefono);
                filacliente[4] = c.email;
                filacliente[5] = String.valueOf(c.hospedajes);
                modelo.addRow(filacliente);
            } else {
                System.out.println("Cliente no existe");
            }*/
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
