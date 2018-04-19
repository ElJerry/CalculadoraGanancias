/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraganancias;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;

/**
 *
 * @author gera
 */
public class SeparadorPares {
    
    
    public static ArrayList<Par> separarPares(ArrayList<Trade> trades){        
        Map<String, Par> pares = new HashMap<String, Par>();
        
        for(Trade t : trades){            
            if(!pares.containsKey(t.par)){
                System.out.println("Cree: " + t.par);
                pares.put(t.par, new Par(t.par));
            }
            
            pares.get(t.par).add(t);          
        }
        
        // Sacar cada objeto Par del mapa
        ArrayList<Par> paresSeparados = new ArrayList<>();
        
        for(Par par : pares.values()){
            paresSeparados.add(par);
        }
        
        Collections.sort(paresSeparados);
        
        return paresSeparados;
    }
    
}
