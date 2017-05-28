package src;

import Pantallas.P_Ingreso;
import src.Reservas;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reserva {

    private static ArrayList<Reservas> reservas = new ArrayList<Reservas>();
    Scanner sc = new Scanner(System.in);

    public void generarReserva() {

        int numreserva = 0, ccn, telefonon, opci = 0, numHabitacion = 1;
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
            /*if (hb.rooms) {

            } else {

            }*/

            Reservas cli = new Reservas(nombren, ccn, telefonon, cantpersonas, cantnoches, fechaingreso, numHabitacion, numreserva);
            reservas.add(cli);
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
    
    public void eliminarReserva(int codRes){
        
    }
    
    public void activarReserva(int codRes){
        
    }
}
