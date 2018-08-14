package modelo.productos;

import modelo.productos.TipoNodo;

public class Criterio {
    private TipoNodo donde;
    private TipoCriterio tipo;
    private String valor;

    public TipoNodo getDonde() {
        return donde;
    }

    public void setDonde(TipoNodo donde) {
        this.donde = donde;
    }

    public TipoCriterio getTipo() {
        return tipo;
    }

    public void setTipo(TipoCriterio tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
