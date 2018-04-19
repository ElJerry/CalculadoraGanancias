/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraganancias;

/**
 *
 * @author gera
 */
public class CalculadoraGanancias {

    public static void main(String[] args) {
        
        LectorCSV lector = new LectorCSV();
        Contenido contenido = lector.getContenido();
        
//        System.out.println("Contenido " + contenido.contenido.size());
//        System.out.println("Ccantidad " + contenido.contenido.get(1).size());
//
//        for(int i=0 ; i<9; i++){
//            System.out.println("Cantidad " + i + ": " + contenido.contenido.get(i).size());
//        }
//        
//        System.out.println("contenido conflictuoso");
//        for(String e : contenido.contenido.get(0)){
//            System.out.print(e + " ");
//            System.out.println(e.length());
//        }
        
        for(int i=1 ; i<contenido.contenido.get(1).size(); i++){
            Trade t = new Trade(i, contenido);
            System.out.println(t);
        }
    }
    
}
