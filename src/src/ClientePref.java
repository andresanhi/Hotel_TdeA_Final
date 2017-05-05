package src;

// @author Jhony_Angulo
import Pantallas.Menu;
import java.util.*;
import javax.swing.JOptionPane;

public class ClientePref {

    private static ArrayList<Clientes> cliente = new ArrayList<Clientes>();
    Scanner sc = new Scanner(System.in);

    public void crearClientePref(String nombre, int cc, int telefono) {
        Hotel h = new Hotel();
        int hospedajes = 0;
        Clientes cl = new Clientes(cc, nombre, telefono, hospedajes);
        cliente.add(cl);
    }

    public double generarDescuento(String tipo, double subtotal, int cc) {
        double dctoFinal = 0;
        double dctoSuite = 0.04, dcto1 = 0;
        double dctoEstandar = 0.025, dcto2 = 0;
        double dctoCamaExtra = 0.10, dcto3 = 0;
        int pos, veces;

        if (cliente.contains(cc) == true) {
            pos = cliente.indexOf(cc);
            veces = cliente.get(pos).hospedajes;

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
    
    public void pintarClientes (){
        Iterator it = cliente.iterator();
        while(it.hasNext()){
            Clientes c = (Clientes) it.next();
            System.out.println(c.nombre + "\t" + c.cc + "\t" + c.telefono + "\t" + c.hospedajes);
        }
    }
}
