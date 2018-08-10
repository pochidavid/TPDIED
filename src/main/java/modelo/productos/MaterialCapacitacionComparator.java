package modelo.productos;

import java.util.Comparator;

public class MaterialCapacitacionComparator implements Comparator<MaterialCapacitacion> {
    @Override
    public int compare(MaterialCapacitacion o1, MaterialCapacitacion o2) {
        if((o1.getRelevancia().equals(RelevanciaEnum.ALTA) &&
                (o2.getRelevancia().equals(RelevanciaEnum.MEDIA)||o2.getRelevancia().equals(RelevanciaEnum.BAJA)))||
                (o1.getRelevancia().equals(RelevanciaEnum.MEDIA) && o2.getRelevancia().equals(RelevanciaEnum.BAJA)))
            return 1;
        else
            if(o1.getRelevancia().equals(o2.getRelevancia())){
                if(o1.getCalificacion().compareTo(o2.getCalificacion()) != 0)
                    return o1.getCalificacion().compareTo(o2.getCalificacion());
                else
                    return o1.precio().compareTo(o2.precio());
            }
            else
                return -1;
    }
}
