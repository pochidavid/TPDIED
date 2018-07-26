/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import com.opencsv.CSVWriter;
import static interfaces.Inicial.biblioteca;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.productos.MaterialCapacitacion;
import modelo.BibliotecaArray;


/**
 *
 * @author Alexis
 */
public class GestorMaterial {
    private static String directory = "E:\\tpDatos.csv";
    
    public static void guardar(MaterialCapacitacion material){
        try {
            String [] materialS = material.toArrayString();

            CSVWriter writer = new CSVWriter(new FileWriter(directory));
            
            writer.writeNext(materialS);
            
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(GestorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static MaterialCapacitacion obtener(Integer id){
        return null;
    }
    
    public static void guardarbibloteca() throws IOException{
        
        List<String[]> materiales = new ArrayList<String[]>();
        biblioteca.materiales().stream().forEach((material) -> {
            materiales.add(material.toArrayString());
        });
        
        try (CSVWriter writer = new CSVWriter(new FileWriter(directory))) {
            writer.writeAll(materiales);
        }
            
        
    }
}
