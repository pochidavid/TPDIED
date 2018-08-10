package modelo;

import modelo.productos.MaterialCapacitacion;
import modelo.productos.MaterialCapacitacionComparator;

import java.util.PriorityQueue;

public class Usuario {
    PriorityQueue<MaterialCapacitacion> wishList = new PriorityQueue<MaterialCapacitacion>(10, new MaterialCapacitacionComparator());

    public boolean addWhishlist(MaterialCapacitacion mc){
        return wishList.add(mc);
    }

}
