/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.crescer.aula1.exercicios;

import br.com.crescer.aula1.exercicios.Interfaces.IParcelator;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


/**
 *
 * @author jpedr
 */
public class Parcelator implements IParcelator{

    @Override
    public Map<String, BigDecimal> calcular(BigDecimal valorParcelar, int numeroParcelas, double taxaJuros, Date dataPrimeiroVencimento) {
        Map<String, BigDecimal> parcelaVencimento = new LinkedHashMap<>();
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy"); 
        BigDecimal BigQtdParcelas = BigDecimal.valueOf(numeroParcelas);
        BigDecimal BigTaxaJuros = BigDecimal.valueOf(taxaJuros);
        BigDecimal totalAPagar;
        totalAPagar = valorParcelar.multiply(BigTaxaJuros.divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE));
        BigDecimal mensalidade;
        mensalidade = totalAPagar.divide(BigQtdParcelas, 2, RoundingMode.HALF_UP);
        calendar.setTime(dataPrimeiroVencimento);
        BigDecimal sobra = mensalidade.multiply(BigQtdParcelas).subtract(totalAPagar);
        for(int i=0; i<numeroParcelas; i++){
            String data = simpleDateFormat.format(calendar.getTime());
            parcelaVencimento.put(data, mensalidade.subtract(sobra));
            sobra = BigDecimal.ZERO;
            calendar.add(Calendar.MONTH, 1);
        }
        return parcelaVencimento;
    }
}
