/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo.productos;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

import util.Ordenable;

/**
 * Representa de manera abstracta los materiales de capacitaciÃ³n
 * 
 * @author mdominguez
 * Integrantes del grupo: MANDRACCHIA, Alexis y SANCHEZ, Julian
 * URL github: https://github.com/pochidavid/taller01
 */
public abstract class MaterialCapacitacion implements Ordenable,Comparable {
	protected Integer id;
	
	/**
	 * Titulo del material
	 */
	protected String titulo;

	/**
	 * Costo bÃ¡sico que debe sumarse al precio por el mero hecho de publicarlo en el
	 * portal
	 */
	protected Double costo;
	
        protected Integer calificacion;
        
        protected Date fecha_publicacion;
        
        protected Integer relevancia;

	/**
	 * Constructor por defecto
	 */
	public MaterialCapacitacion() {
		this(0,"en desarrollo",0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un Titulo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id, String titulo) {
		this(id,titulo,0.0);
	}

	/**
	 * Constructor que recibe como argumento un ID y un costo
	 * 
	 * @param id
	 * @param titulo
	 */
	public MaterialCapacitacion(Integer id,String titulo, Double costo) {
		this.id =id;
		this.titulo = titulo;
		this.costo = costo;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Double getCosto() {
		return costo;
	}

	public void setCosto(Double costo) {
		this.costo = costo;
	}

	
	/**
	 * El precio de un material se define segÃºn el tipo del material y toma como
	 * base el costo del mismo
	 * 
	 * @return
	 */
	public abstract Double precio();
	
	/**
	 * Retorna verdadero si es una instancia de libro, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esLibro();

	/**
	 * Retorna verdadero si es una instancia de video, falso en caso contrario
	 * @return
	 */
	public abstract Boolean esVideo();
	
	@Override
	public String toString(){
		return String.format("[Titulo %s; PRECIO: %.1f]", this.getTitulo(), this.precio());
	}

	@Override
	public int valor() {
		return this.precio().intValue();
	}

    //TODO: Notar que estamos invocando un meÌ�todo abstracto (precio) pero funciona.
    //Â¿porque considera que funciona? Agregar un comentario en el coÌ�digo con la respuesta.

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof MaterialCapacitacion)) return false;
		MaterialCapacitacion that = (MaterialCapacitacion) o;
		return Objects.equals(getTitulo(), that.getTitulo());
	}

	@Override
	public int hashCode() {

		return Objects.hash(getTitulo());
	}

	/*
	@Override
	public boolean equals(Object t){
		return ((t instanceof MaterialCapacitacion)&& ((MaterialCapacitacion) t).titulo.toLowerCase().equals(this.titulo.toLowerCase()));
	
	}
	*/

	@Override
	public int compareTo(Object T){
		if(this.equals(T)){
			if(this.precio().equals(((MaterialCapacitacion)T).precio())){
				return 0;
			}
			else{
				return this.precio().compareTo(((MaterialCapacitacion)T).precio());
			}
		}
		else{
			return this.getTitulo().toLowerCase().compareTo(((MaterialCapacitacion)T).getTitulo().toLowerCase());
		}
	}
	
}
