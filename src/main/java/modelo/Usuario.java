package modelo;

import modelo.productos.MaterialCapacitacion;
import modelo.productos.MaterialCapacitacionComparator;

import java.util.PriorityQueue;

public class Usuario {
    private static PriorityQueue<MaterialCapacitacion> wishList = new PriorityQueue<MaterialCapacitacion>(10, new MaterialCapacitacionComparator());

    public static void addWishList(MaterialCapacitacion material) {
        wishList.add(material);
    }

    public static PriorityQueue<MaterialCapacitacion> getWishList() {
        return wishList;
    }
}
