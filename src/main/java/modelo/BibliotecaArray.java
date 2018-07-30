package modelo;

import java.util.Arrays;
import java.util.Collection;

import modelo.productos.MaterialCapacitacion;
import util.ListaServiceRadix;
import util.ListasService;


/**
 * Esta clase implementa la interface Biblioteca y todas sus operaciones, gestionando todos los
 * @see MaterialCapacitacion en un arreglo.
 * @author mdominguez
 *
 */
public class BibliotecaArray implements Biblioteca{
	
	
	/**
	 * Arreglo donde se almacenan todos los materiales de capacitacion
	 */
	private MaterialCapacitacion[] materialCapacitacion;
	/**
	 * Variable interna de control que se utiliza para llevar registro de cuantos materiales 
	 * se llevan insertados. Se utiliza para evitar insertar un nuevo material fuera de rango
	 * y tambien para responder la consulta acerca de cuantos materiales hay insertados
	 */
	private Integer cantidadMaterial;

	private ListasService listasService;

	
	public BibliotecaArray() {
		cantidadMaterial=0;
		this.materialCapacitacion= new MaterialCapacitacion[5];
		listasService = new ListaServiceRadix(materialCapacitacion);
	}

	@Override
	public void agregar(MaterialCapacitacion material) {
		if(cantidadMaterial != materialCapacitacion.length){
			materialCapacitacion[cantidadMaterial] = material;
			cantidadMaterial++;
		}
	}

	@Override
	public Integer cantidadMateriales() {
		return this.cantidadMaterial;
	}



	@Override
	public Integer cantidadLibros() {
		Integer cantidad = 0;

		for(int i = 0; i < cantidadMaterial; i++){
			if(materialCapacitacion[i].esLibro()) cantidad++;
		}
		return cantidad;
	}



	@Override
	public Integer cantidadVideos() {
		Integer cantidad = 0;

		for(int i = 0; i < cantidadMaterial; i++){
			if(materialCapacitacion[i].esVideo()) cantidad++;
		}
		return cantidad;
	}

	@Override
	public void imprimir() {		
		listasService.imprimir();
	}
		

	@Override
	public void ordenarPorPrecio(Boolean b) {
		if(b) listasService.ordenar();
	}


	@Override
	public Collection<MaterialCapacitacion> materiales() {
		return Arrays.asList(this.materialCapacitacion);
	}

	@Override
	public MaterialCapacitacion buscar(Integer costo) {
		return null;
	}
}
