/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraganancias;

import java.util.ArrayList;

/**
 *
 * @author gera
 */
public class CalculadoraGanancias {

    public static void main(String[] args) {
        
        LectorCSV lector = new LectorCSV();
        Contenido contenido = lector.getContenido();
        
        // Generar trades
        ArrayList<Trade> trades = Trade.generarTrades(contenido);
        System.out.println("Cantidad de trades: " + trades.size());
        
        ArrayList<Par> paresSeparados = SeparadorPares.separarPares(trades);
        
        for(Par p : paresSeparados){
            System.out.println("================" + p.getNombre() + "================");
            for(Trade t : p.getTrades()){
                System.out.println(t);
            }
        }
        
    }
    
}
