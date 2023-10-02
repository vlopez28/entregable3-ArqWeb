package com.integrador.services.dto.carrera;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarreraRequestDto {

    private String nombre;
    private int cantidad;
	
    public String getNombre() {
		return nombre;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDuracion(int cantidad) {
		this.cantidad = cantidad;
	}
	public CarreraRequestDto(String nombre, int cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}

    //verificar funcionamiento de @Data



}