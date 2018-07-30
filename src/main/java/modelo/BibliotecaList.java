package modelo;

import modelo.productos.MaterialCapacitacion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class BibliotecaList implements Biblioteca {
    private ArrayList<MaterialCapacitacion> materiales;

    public BibliotecaList() {
        this.materiales = new ArrayList<>();
    }

    @Override
    public void agregar(MaterialCapacitacion material) {
        materiales.add(material);
    }

    @Override
    public Integer cantidadMateriales() {
        return materiales.size();
    }

    @Override
    public Integer cantidadLibros() {
        Integer cantidad = 0;

        for(MaterialCapacitacion material:materiales){
            if(material != null && material.esLibro()) cantidad++;
        }

        return cantidad;
    }

    @Override
    public Integer cantidadVideos() {
        Integer cantidad = 0;

        for(MaterialCapacitacion material:materiales){
            if(material != null && material.esVideo()) cantidad++;
        }

        return cantidad;
    }

    @Override
    public Collection<MaterialCapacitacion> materiales() {
        return this.materiales;
    }

    @Override
    public void imprimir() {
        for(MaterialCapacitacion material:materiales){
            System.out.println(material);
        }
    }

    @Override
    public void ordenarPorPrecio(Boolean b) {
        if(b) {
            Collections.sort(materiales, (m1,m2) -> (int) (m1.precio()-m2.precio()));
        }else{
            Collections.sort(materiales);
        }
    }

    @Override
    public MaterialCapacitacion buscar(Integer costo) {
        Collections.sort(materiales, (m1,m2) -> (int) (m1.precio()-m2.precio()));
        return buscadorBinario(0, materiales.size()-1, costo);

    }

    private MaterialCapacitacion buscadorBinario(int i, int f, Integer costo) {
        Integer pibote = (f-i)/2+i;

        if(materiales.get(pibote).getCosto().intValue() < costo && i != f) return buscadorBinario(pibote+1,f,costo);
        if(materiales.get(pibote).getCosto().intValue() > costo && i != f) return buscadorBinario(i,pibote,costo);
        if(materiales.get(pibote).getCosto().intValue() == costo) return materiales.get(pibote);
        throw new RuntimeException("Material de precio " + costo + " no encontrado");
    }
}
