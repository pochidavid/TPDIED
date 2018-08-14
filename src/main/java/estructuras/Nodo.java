package estructuras;

import modelo.productos.TipoNodo;

import java.util.ArrayList;
import java.util.Arrays;


public class Nodo {
    private String valor;
    public TipoNodo tipoNodo;
    private ArrayList<Arbol> hijos = new ArrayList<Arbol>();;
    private ArrayList<TipoNodo> posiblesHijos = new ArrayList<TipoNodo>();
    private Nodo nodoPadre;
    private Integer id;

    public Nodo(TipoNodo tipoNodo,String valor){
        this.tipoNodo = tipoNodo;
        this.valor = valor;
        generarPosiblesHijos();
    }

    public ArrayList<Arbol> getHijos(){return hijos;}
    public ArrayList<TipoNodo> getPosiblesHijos(){return posiblesHijos;}

    public String getValor() {
        return valor;
    }

    private void generarPosiblesHijos(){
        switch (tipoNodo){
            case TITULO:
                posiblesHijos.addAll(Arrays.asList(new TipoNodo[]{TipoNodo.METADATO, TipoNodo.RESUMEN, TipoNodo.CAPITULO}));
                break;
            case METADATO:
                posiblesHijos.addAll(Arrays.asList(new TipoNodo[]{TipoNodo.AUTOR,TipoNodo.EDITORIAL,TipoNodo.FECHA_PUBLICACION,TipoNodo.PALABRA_CLAVE,
                        TipoNodo.EJERCICIO,TipoNodo.SOLUCION}));
                break;
            case RESUMEN:
                posiblesHijos.addAll(Arrays.asList(new TipoNodo[]{TipoNodo.PARRAFO}));
                break;
            case CAPITULO:
                posiblesHijos.addAll(Arrays.asList(new TipoNodo[]{TipoNodo.SECCION,TipoNodo.METADATO}));
                break;
            case SECCION:
                posiblesHijos.addAll(Arrays.asList(new TipoNodo[]{TipoNodo.PARRAFO}));
                break;
        }
    }

    public Boolean agregarHijo(Arbol arbol){
        if(posiblesHijos.contains(arbol.raiz.tipoNodo)){
            arbol.raiz.setPadre(this);
            arbol.raiz.setId(this.hijosTipo(arbol.raiz.tipoNodo));

            if(hijos.add(arbol)) {
                actualizarPosiblesHijos(arbol.raiz.tipoNodo);
                System.out.println("Se agrego: "+arbol.raiz.imprimirRuta());
                return true;
            }
            return false;
        }
        return false;
    }

    private void actualizarPosiblesHijos(TipoNodo tipo){
        if(!(tipo.equals(TipoNodo.AUTOR) || tipo.equals(TipoNodo.PARRAFO)
                || tipo.equals(TipoNodo.SECCION) || tipo.equals(TipoNodo.EJERCICIO)
                || tipo.equals(tipoNodo.SOLUCION))) posiblesHijos.remove(tipo);
    }

    private void setPadre(Nodo padre){ nodoPadre = padre;}

    public String imprimirRuta() {
        if (nodoPadre != null) return tipoNodo.toString();
        else return (nodoPadre.imprimirRuta() + "." + tipoNodo.toString());
    }

    private Integer hijosTipo(TipoNodo tipo){
        Integer num = 0;

        for(Arbol hijo:hijos){
            if(hijo.raiz.tipoNodo.equals(tipo)) num++;
        }

        return num;
    }

    private void setId(Integer id){this.id = id;}

    @Override
    public String toString() {
        if(id==null||id==0) return tipoNodo.toString();
        else return tipoNodo+"_"+id;
    }
}
