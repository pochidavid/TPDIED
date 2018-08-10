/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import com.opencsv.*;
import modelo.Biblioteca;
import modelo.BibliotecaList;
import modelo.productos.Libro;
import modelo.productos.MaterialCapacitacion;
import modelo.productos.RelevanciaEnum;
import modelo.productos.Video;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Alexis
 */
public class GestorMaterial {

    private static String directory = "."+ File.separator+"tpDatos.csv";
    public static BibliotecaList biblioteca = new BibliotecaList();
    
    public static void guardar(MaterialCapacitacion material){
        try {
            String [] materialS = material.toArrayString();

            CSVWriter writer = new CSVWriter(new FileWriter(directory,true));
            
            writer.writeNext(materialS);
            
            writer.close();

            biblioteca.agregar(material);

        } catch (IOException ex) {
            Logger.getLogger(GestorMaterial.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static MaterialCapacitacion obtener(Integer id){
        return null;
    }
    
    public static void guardarBiblioteca() throws IOException{
        
        List<String[]> materiales = new ArrayList<String[]>();
        biblioteca.materiales().stream().forEach((material) -> {
            materiales.add(material.toArrayString());
        });
        
        try (CSVWriter writer = new CSVWriter(new FileWriter(directory,true))) {
            writer.writeAll(materiales);
        }
            
        
    }

    public static void cargarBiblioteca() throws IOException {
        CSVReader csvReader = null;
        Integer id;
        String titulo;
        Double costo;
        Double precioCompra;
        Integer paginas;
        Integer duracion;
        Integer calificacion;
        Date fechaPubl;
        RelevanciaEnum relevancia;

        try {
            csvReader = new CSVReader(new FileReader(directory));

            String[] fila = null;
            while((fila = csvReader.readNext()) != null) {
                System.out.println(fila[0]
                        + " | " + fila[1]
                        + " |  " + fila[2]);

                id = Integer.parseInt(fila[1]);
                titulo = fila[2];
                calificacion = Integer.parseInt(fila[4]);
                costo = Double.parseDouble(fila[5]);
                precioCompra = Double.parseDouble(fila[6]);
                DateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss z yyyy");
                fechaPubl = formatter.parse(fila[7]);
                relevancia = RelevanciaEnum.valueOf(fila[8]);

                if(fila[0].equals("Libro")){
                    //Libro(Integer id, String titulo, Double costo, Double precioCompra, Integer paginas)
                    //{"Libro",id.toString(),titulo,paginas.toString(),calificacion.toString(),costo.toString(),this.precio().toString(),fecha_publicacion.toString(),relevancia.toString()};
                    paginas = Integer.parseInt(fila[3]);
                    biblioteca.agregar(new Libro(id,titulo,costo,precioCompra,paginas,fechaPubl,calificacion,relevancia));

                }else if(fila[0].equals("Video")){
                        //Video(Integer id, String titulo, Double costo, Integer duracion)
                        //{"Video",id.toString(),titulo,duracion.toString(),calificacion.toString(),costo.toString(),this.precio().toString(),fecha_publicacion.toString(),relevancia.toString()};
                        duracion = Integer.parseInt(fila[3]);
                        biblioteca.agregar(new Video(id,titulo,costo,duracion));

                }
            }

            csvReader.close();
        } catch (FileNotFoundException e) {
            CSVWriter writer = new CSVWriter(new FileWriter(directory,true));
            writer.close();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
