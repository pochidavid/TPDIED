/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estructuras;
import java.util.ArrayList;
import modelo.productos.TipoNodo;

/**
 *
 * @author Matías E. Bertoluzzi
 */
public class ArbolN_ario {
    String raiz;
    TipoNodo tipo;
    ArrayList<ArbolN_ario> hijos;
    
    public ArbolN_ario(String str, TipoNodo tip){
        raiz = str;
        tipo = tip;
        hijos = new ArrayList<>();
    }
    public String raiz(){
        return raiz;
    }
    public TipoNodo tipo(){
        return tipo;
    }
    public boolean agregarHijo(ArbolN_ario nodo){
        return hijos.add(nodo);
    }
    public ArbolN_ario buscar(String val){
        ArbolN_ario aux;
        if(raiz.equals(val))
            return this;
        else{
            if(hijos.isEmpty())
                return new ArbolN_ario("F4LL0",TipoNodo.TITULO);
            else
                for(ArbolN_ario hij : hijos){
                    aux = hij.buscar(val);
                    if(!aux.raiz().equals("F4LL0"))
                        return aux;
                }
        }
        return new ArbolN_ario("F4LL0",TipoNodo.TITULO);   
    }
}
