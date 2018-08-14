package estructuras;

import modelo.productos.Criterio;
import modelo.productos.TipoNodo;

public class Arbol {
    public Nodo raiz;

    public Arbol(TipoNodo tipoNodo, String valor){
        raiz = new Nodo(tipoNodo,valor);
    }

    //buscarNodo()

    public Boolean cumpleCriterio(Criterio criterio){
        if(criterio.getDonde().equals(raiz.tipoNodo))
        switch(criterio.getTipo()){
            case CONTIENE: return raiz.getValor().contains(criterio.getValor());
            case ES: return raiz.getValor().equals(criterio.getValor());
        }
        else
            for(Arbol arbol:raiz.getHijos()) if (arbol.cumpleCriterio(criterio)) return true;
        return false;
    }

    public Boolean cumpleCriterios(Criterio[] criterios){
        for (Criterio criterio:criterios){
            if(!cumpleCriterio(criterio)) return false;
        }
        return true;
    }
}
