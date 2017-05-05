package hotel;

import java.util.*;

public class Reserva {

    private static ArrayList<Clientesn> cliente = new ArrayList<Clientesn>();
    Scanner sc = new Scanner(System.in);

    public void GenerarReserva() {

        int numreserva = 0, ccn, telefonon, opci = 0;
        int tipohabitacion = 0;
        String fechaingreso = "";
        String nombren = "";
        int cantpersonas = 0;
        int cantnoches = 0;
        boolean creando = true;
        Hotel hl = new Hotel();

        do {
            System.out.println("Ingrese el nombre completo del cliente: ");
            nombren = sc.nextLine();
            System.out.println("Ingrese el número de documento del cliente: ");
            ccn = sc.nextInt();
            System.out.println("Ingrese el teléfono del cliente: ");
            telefonon = sc.nextInt();
            System.out.println("Que tipo de habitación desea: ");
            Hotel hb = new Hotel();
            hb.mostrarHabitaciones();
            tipohabitacion = sc.nextInt();
            hb.validarDisponibilidad(tipohabitacion);
            if (hb.rooms) {

            } else {

            }

            Clientesn cli = new Clientesn(nombren, ccn, telefonon, cantpersonas, cantnoches, fechaingreso);
            cliente.add(cli);
            System.out.println("Presione 1 para crear otro cliente y 2 para regresar al menú principal");
            opci = sc.nextInt();
            switch (opci) {
                case 1:
                    creando = true;
                    break;
                case 2:
                    creando = false;
                    hl.generarMenu();
                    break;
                default:
                    System.out.println("Selección inválida");
                    hl.generarMenu();
                    break;
            }
        } while (creando == true);
    }

}
