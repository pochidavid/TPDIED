package modelo.productos;

import java.util.Date;

public class Video extends MaterialCapacitacion {
	
	private static double costo_segundo = 0.15;
	private Integer  duracion;
	
	public Video(){
		
	}
	public Video(Integer id, String titulo){
		super(id,titulo);
	}
	public Video(Integer id, String titulo, Double costo){
		super(id,titulo,costo);
	}
	public Video(Integer id, String titulo, Double costo, Integer duracion){
		super(id,titulo,costo);
		this.duracion=duracion;
	}
	public Video(Integer id, String titulo, Double costo, Integer duracion, Date fechaPub, Integer calificacion, RelevanciaEnum relevancia, Boolean activo){
		this(id,titulo,costo,duracion);
		this.fecha_publicacion = fechaPub;
		this.calificacion = calificacion;
		this.relevancia = relevancia;
		this.activo = activo;
	}

	@Override
	public Double precio() {
		return this.costo + (this.duracion*costo_segundo);
	}

	@Override
	public Boolean esLibro() {
		return false;
	}

	@Override
	public Boolean esVideo() {
		return true;
	}
	@Override
	public boolean equals(Object T){ //me cambi� el tipo de retorno a eso de Boolean
		return (T instanceof Video && super.equals(T));
	}

    @Override
    public String[] toArrayString() {
        String[] string = {"Video",id.toString(),titulo,duracion.toString(),calificacion.toString(),costo.toString(),this.precio().toString(),fecha_publicacion.toString(),relevancia.toString(),activo.toString()};
        return string;
    }
}
