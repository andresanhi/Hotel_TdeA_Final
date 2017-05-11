/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Sebastian_Ramirez
 */
public class Reservas {

    String nombren, fechaingreso;
    int ccn, telefonon, cantpersonas, cantnoches, numHabitacion, numReserva;

    public Reservas(String nombren, int ccn, int telefonon, int cantpersonas, int cantnoches, String fechaingreso, int numHabitacion, int numReserva) {
        this.numHabitacion = numHabitacion;
        this.nombren = nombren;
        this.ccn = ccn;
        this.telefonon = telefonon;
        this.cantpersonas = cantpersonas;
        this.cantnoches = cantnoches;
        this.fechaingreso = fechaingreso;
        this.numReserva = numReserva;
    }
}
