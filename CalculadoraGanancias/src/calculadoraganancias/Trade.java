/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraganancias;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 *
 * @author gera
 */
public class Trade {
    
    public String tipo, opened, closed, par;
    public float limit, cantidad, comision, precioFinal;
    
    public Trade(int linea, Contenido contenido){
        par = contenido.contenido.get(1).get(linea);
        tipo = contenido.contenido.get(2).get(linea);
        opened = contenido.contenido.get(7).get(linea);
        closed = contenido.contenido.get(8).get(linea);
        
        cantidad = Float.parseFloat(contenido.contenido.get(3).get(linea).replace(" ", ""));
        limit = Float.parseFloat(contenido.contenido.get(4).get(linea).replace(" ", ""));
        comision = Float.parseFloat(contenido.contenido.get(5).get(linea).replace(" ", ""));
        precioFinal = Float.parseFloat(contenido.contenido.get(6).get(linea).replace(" ", ""));
    }
    
    public static ArrayList<Trade> generarTrades(Contenido contenido){
        
        ArrayList<Trade> res = new ArrayList<>();
        Trade t;
        for(int i=1 ; i<contenido.contenido.get(1).size(); i++){
            t = new Trade(i,contenido);
            res.add(t);
        }
        
        return res;
    }
    
    public String[] obtenerValoresTabla(){
        String[] cabezera = new String[8];
        cabezera[0] = par;
        cabezera[1] = tipo;
        cabezera[2] = String.valueOf(cantidad);
        cabezera[3] = String.valueOf(limit);
        cabezera[4] = String.valueOf(comision);
        cabezera[5] = String.valueOf(precioFinal);
        cabezera[6] = opened;
        cabezera[7] = closed;
        
        return cabezera;
    }
    
    @Override
    public String toString(){
        DecimalFormat df = new DecimalFormat("#");
        df.setMaximumFractionDigits(8);
        
        StringBuilder sb = new StringBuilder();
        sb.append("---------------------------------------------\n");
        sb.append("Par: " + par + "\n");
        sb.append("Cantidad: " + cantidad + "\n");
        sb.append("Fecha de apertura: " + opened + "\n");
        sb.append("Fecha de cierre: " + closed + "\n");
        sb.append("Cantidad: " + df.format(cantidad) + "\n");
        sb.append("Limit: " + df.format(limit) + "\n");
        sb.append("Comision: " + df.format(comision) + "\n");
        sb.append("Costo final: " + df.format(precioFinal) + "\n");
        sb.append("---------------------------------------------\n");
                
        return sb.toString();
    }
}
