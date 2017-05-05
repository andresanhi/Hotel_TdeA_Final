package src;

// * @author Jhony_Angulo
import java.util.*;

public class Ingreso {

    Scanner sc = new Scanner(System.in);

    public void generarIngreso() {
        Hotel h = new Hotel();
        int numReserva;
        int pos;
        int opc = 0;
        System.out.println("Si tiene número de reserva presione 1, de lo contrario presione 2");
        opc = sc.nextInt();
        switch (opc) {
            case 1:
                System.out.println("Ingrese el número de la reserva");
                numReserva = sc.nextInt();
                //pos = reservas.contains(numReserva);
                //reservas.set(pos).fechaIngreso = Date;
                System.out.println("Código\tTipoHabitacion\tNoches\tAcompañantes");
            //System.out.println(reservas.get(pos).numero + reservas.get(pos).tipoHabitacion + reservas.get(pos).noches +" noches" + reservas.get(pos).cantPersonas);
            break;
            case 2:
                System.out.println("Seleccione la habitación que desea");
                h.mostrarHabitaciones();      
        }
    }
}
