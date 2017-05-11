package src;

// @author Jhony_Angulo
import Pantallas.Menu;
import Pantallas.P_Clientes;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import src.ClientePref;

public class ClientePref {

    private static ArrayList<Clientes> cliente = new ArrayList<Clientes>();
    Scanner sc = new Scanner(System.in);

    public boolean validarExistencia(int cc) {
        boolean insertar = true;
        boolean control = true;
        Iterator<Clientes> it = cliente.iterator();
        while (it.hasNext()) {
            Clientes i = (Clientes) it.next();
            if (i.cc == cc) {
                insertar = false;
            }
        }
        return (insertar);
    }

    public int crearClientePref(String nombre, int tipo, int cc, int telefono, String mail) {
        // Creo un objeto de la vista que se llama P_Clientes
        P_Clientes pc = new P_Clientes();
        int hospedajes = 0;
        //Creo el objeto que voy a guardar en el ArrayList llamado cliente.
        Clientes cl = new Clientes(tipo, cc, nombre, telefono, mail, hospedajes);
        cliente.add(cl);
        //Después de crearlo pregunto si quiere crear otro y ahí es donde tengo el dilema.
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
        String[] titulos = {"Nombre", "TipoDocumento", "N°Documento", "Teléfono", "Email", "Hospedajes"};
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
        }
        return (modelo);
        //P_Clientes pc = new P_Clientes();
        //pc.setVisible(true);
        //pc.mostrarClientes(titulos, clientes);
        //pc.mostrarClientes(modelo);
        /*Iterator it = cliente.iterator();
        while (it.hasNext()) {
            Clientes c = (Clientes) it.next();
            System.out.println(c.nombre + c.tipo + "\t" + "\t" + c.cc + "\t" + c.telefono + "\t" + c.hospedajes);
        }*/
    }

    public DefaultTableModel buscarCliente(int cc) {
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
