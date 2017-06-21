/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1.exercicios;

import br.com.crescer.aula1.exercicios.Interfaces.ICalendarUtils;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author jpedr
 */
public class CalendarUtils implements ICalendarUtils {
    
    @Override
    public DiaSemana diaSemana(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case 1:
                return DiaSemana.DOMINGO;
            case 2:
                return DiaSemana.SEGUNDA_FEIRA;
            case 3:
                return DiaSemana.TERCA_FEIRA;
            case 4:
                return DiaSemana.QUARTA_FEIRA;
            case 5:
                return DiaSemana.QUINTA_FEIRA;
            case 6:
                return DiaSemana.SEXTA_FEIRA;
             case 7:
                return DiaSemana.SABADO;
            default:
                 return null;
         }
    }

    @Override
    public String tempoDecorrido(Date date) {
        int DiffAnos,DiffMeses,DiffDias;
        Calendar cDataAtual,cDataPassada,cDataResultado;
        Date dataAtual = new Date();
        cDataAtual = Calendar.getInstance();
        cDataAtual.setTime(dataAtual);
        cDataPassada = Calendar.getInstance();
        cDataPassada.setTime(date);
        DiffAnos = cDataAtual.get(Calendar.YEAR) - cDataPassada.get(Calendar.YEAR);
        DiffMeses = cDataAtual.get(Calendar.MONTH) - cDataPassada.get(Calendar.MONTH);
        DiffDias = cDataAtual.get(Calendar.DAY_OF_MONTH) -  cDataPassada.get(Calendar.DAY_OF_MONTH);
        cDataResultado = Calendar.getInstance();
        cDataResultado.set(DiffAnos, DiffMeses, DiffDias);
        return cDataResultado.get(Calendar.YEAR)+" ano(s), "+cDataResultado.get(Calendar.MONTH)+" messe(s) e "+cDataResultado.get(Calendar.DAY_OF_MONTH)+" dia(s)";
    }
}
