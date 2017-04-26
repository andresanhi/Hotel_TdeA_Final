package hotel;

// @author Jhony_Angulo
import java.util.*;

public class ClientePref {

    private static ArrayList<Clientes> cliente = new ArrayList<Clientes>();
    Scanner sc = new Scanner(System.in);

    public void crearClientePref() {
        Hotel h = new Hotel();
        int cc = 0;
        int telefono = 0;
        int hospedajes = 0;
        String nombre = "";
        boolean creando = true;
        int opc = 0;

        do {
            System.out.println("Ingrese el nombre completo del cliente: ");
            nombre = sc.nextLine();
            System.out.println("Ingrese el número de documento del cliente: ");
            cc = sc.nextInt();
            System.out.println("Ingrese el teléfono del cliente: ");
            telefono = sc.nextInt();
            Clientes cl = new Clientes(cc, nombre, telefono, hospedajes);
            cliente.add(cl);
            System.out.println("Cliente creado exitosamente");
            System.out.println("Presione 1 para crear otro cliente y 2 para regresar al menú principal");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    //creando = true;
                    break;
                case 2:
                    creando = false;
                    h.generarMenu();
                    break;
                default:
                    System.out.println("Selección inválida");
                    h.generarMenu();
                    break;
            }
        } while (creando == true);
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
}
