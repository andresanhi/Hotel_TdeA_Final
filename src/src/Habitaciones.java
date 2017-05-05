/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.*;

class Habitaciones {

    int numHabitacion;
    int Capacidad;
    String tipoHabitacion;
    boolean estado;
    double precioXNoche;
    ArrayList<Habitaciones> rooms = new ArrayList<Habitaciones>();

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Habitaciones(int numHabitacion, String tipoHabitacion, int Capacidad, double precioXNoche, boolean estado) {
        this.numHabitacion = numHabitacion;
        this.Capacidad = Capacidad;
        this.tipoHabitacion = tipoHabitacion;
        this.estado = estado;
        this.precioXNoche = precioXNoche;
    }
}
