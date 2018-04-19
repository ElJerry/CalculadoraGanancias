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
public class Par implements Comparable<Par>{
    
    private String nombre;
    private ArrayList<Trade> trades;

    public Par(String nombre){
        this.nombre = nombre;
        trades = new ArrayList<>();
    }
    
    public void add(Trade t){
        trades.add(t);
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Trade> getTrades() {
        return trades;
    }

    public void setTrades(ArrayList<Trade> trades) {
        this.trades = trades;
    }

    @Override
    public int compareTo(Par o) {
        return nombre.compareTo(o.nombre);
    }
    
}
