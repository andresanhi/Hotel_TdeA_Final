/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.util.Calendar;
 // @author Jhony_Angulo
public class Fechas {
    
    public static int diferenciaEnDias(Calendar fechaMayor, Calendar fechaMenor) {
        long diferenciaEn_ms = fechaMayor.getTimeInMillis()- fechaMenor.getTimeInMillis();
        long dias = diferenciaEn_ms / (1000 * 60 * 60 * 24);
        return (int) dias;
    }

}
