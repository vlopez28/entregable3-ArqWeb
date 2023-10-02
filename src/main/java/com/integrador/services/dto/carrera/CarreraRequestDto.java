package com.integrador.services.dto.carrera;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CarreraRequestDto {

    private String nombre;
    private int duracion;
	
    public String getNombre() {
		return nombre;
	}
	public int getDuracion() {
		return duracion;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public CarreraRequestDto(String nombre, int duracion) {
		super();
		this.nombre = nombre;
		this.duracion = duracion;
	}

    //verificar funcionamiento de @Data



}