/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadoraganancias;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 *
 * @author gera
 */
public class LectorCSV {
    
    private Contenido contenido = new Contenido(); 
    private File archivo;
    
    public LectorCSV(File archivo){
        this.archivo = archivo;
        cargarArchivo();
    }
    
    public LectorCSV() {
        // Obtener la ruta del archivo
        JFileChooser fChooser = new JFileChooser();
        fChooser.showOpenDialog(null);        
        
        archivo = fChooser.getSelectedFile();
        cargarArchivo();
    }
    
    private void cargarArchivo(){
        System.out.println("Archivo elegido " + archivo.getAbsolutePath());        
        obtenerContenidos();
    }
    
    private void obtenerContenidos(){
        
        try ( BufferedReader br = new BufferedReader(new FileReader(archivo)) ){
            
            //Leer encabezados
            String[] encabezados = br.readLine().split(",");
            
            contenido.contenido = new ArrayList<>();
            
            for(int i=0 ; i<encabezados.length; i++){
//                System.out.println(encabezados[i]);
                
                contenido.contenido.add(new ArrayList<>());
                contenido.contenido.get(i).add(encabezados[i]);                
            }
            
            // Leer contenidos 
            String linea;
            String[] tokens;
            while ((linea = br.readLine()) != null){
                
                if(linea.equalsIgnoreCase(" ")) // El caracter no es un espacio - fue sacado con debug
                    continue;
                
                tokens = linea.split(",");
                for(int i=0 ; i<tokens.length; i++){
                    contenido.contenido.get(i).add(tokens[i]);
                }
            }
        
        } catch (IOException ex) {
            ex.printStackTrace();                    
        }
        
    }
    
    public Contenido getContenido(){
        return contenido;
    }
    
    
}
