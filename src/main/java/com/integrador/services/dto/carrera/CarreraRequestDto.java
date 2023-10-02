package com.integrador.services.dto.carrera;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarreraRequestDto {

    private String nombre;
    private int duracion;
   // private int cantidad;
	
    
    
    public int getDuracion() {
		return duracion;
	}
//	public void setCantidad(int cantidad) {
//		this.cantidad = cantidad;
//	}
	public String getNombre() {
		return nombre;
	}
//	public int getCantidad() {
//		return cantidad;
//	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	
//	
//	public CarreraRequestDto(String nombre, int duracion, int cantidad) {
//		super();
//		this.nombre = nombre;
//		this.duracion = duracion;
//		this.cantidad = cantidad;
//	}
	public CarreraRequestDto(String nombre, int duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
	}
	
	
	
//	public CarreraRequestDto(String nombre, int cantidad) {
//		super();
//		this.nombre = nombre;
//		this.cantidad = cantidad;
//	}

    //verificar funcionamiento de @Data



}