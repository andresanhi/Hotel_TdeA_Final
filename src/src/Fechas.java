/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Calendar;
 // @author Jhony_Angulo
public class Fechas {
    
    //Recibe 2 parámetros de tipo Calendar
    public static int diferenciaEnDias(Calendar fechaMayor, Calendar fechaMenor) {
        //Realiza la resta de los 2 en milisegundos
        long diferenciaEn_ms = fechaMayor.getTimeInMillis()- fechaMenor.getTimeInMillis();
        //convierte los milisegundos en días
        long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
        //Retorna los días.
        return (int) dias;
    }

}
