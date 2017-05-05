package src;

import java.util.*;

public class Hotel {

    Scanner sc = new Scanner(System.in);
    private static ArrayList<Habitaciones> rooms = new ArrayList<>();

    public void generarMenu(){
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
                //r.generarReserva;
                Pruea p = new Pruea();
                p.iniciarprueba();
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

    public void generarHabitaciones() {
        //ArrayList<Habitaciones> rooms = new ArrayList<Habitaciones>();
        Habitaciones ha1 = new Habitaciones(1, "Suite   ", 2, 215000, true);
        rooms.add(ha1);
        //habitazione.add(ha1);
        Habitaciones ha2 = new Habitaciones(2, "Suite   ", 2, 215000, true);
        rooms.add(ha2);
        Habitaciones ha3 = new Habitaciones(3, "Estándar", 2, 132000, true);
        rooms.add(ha3);
        Habitaciones ha4 = new Habitaciones(4, "Estándar", 3, 180000, true);
        rooms.add(ha4);
        Habitaciones ha5 = new Habitaciones(5, "Estándar", 4, 230000, true);
        rooms.add(ha5);
        Habitaciones ha6 = new Habitaciones(6, "Estándar", 4, 230000, true);
        rooms.add(ha6);
    }

    public void mostrarHabitaciones() {
        String estado;
        System.out.println("Número\tTipo\t\tCapacidad\tPrecioNoche\tEstado");
        for (int i = 0; i < rooms.size(); i++) {
            if (rooms.get(i).estado == true) {
                estado = "Disponible";
            } else {
                estado = "Ocupada";
            }
            System.out.println(rooms.get(i).numHabitacion + "\t" + rooms.get(i).tipoHabitacion + "\t" + rooms.get(i).Capacidad + " personas\t" + "$ " + (int) rooms.get(i).precioXNoche + "\t" + estado);
        }
        /*Iterator it = rooms.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }*/
    }
}
