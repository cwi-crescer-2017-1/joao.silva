/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1.exercicios;

import br.com.crescer.aula1.exercicios.Interfaces.IParcelator;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author jpedr
 */
public class Parcelator implements IParcelator{

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        Map<String, BigDecimal> parcelaVencimento = new TreeMap<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd"); 
        double mensal = (valorParcelar.doubleValue()*(taxaJuros/100+1.0))/numeroParcelas;
        BigDecimal mensalidade  = BigDecimal.valueOf(mensal);
        calendar.setTime(dataPrimeiroVencimento);
            for(int i=0; i<numeroParcelas; i++){
            String data = simpleDateFormat.format(calendar.getTime());
            parcelaVencimento.put(data, mensalidade);
            calendar.add(Calendar.MONTH, 1);
        }
        return parcelaVencimento;
    }
}
