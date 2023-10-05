package com.integrador.services.dto.carreraConInscriptos;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.Carrera;
import com.integrador.domain.EstudianteCarrera;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CarreraConInscriptosResponseDto {
	
	private String nombre;
	private Long cantidad;
	public String getNombre() {
		return nombre;
	}
	public Long getCantidad() {
		return cantidad;
	}
	public CarreraConInscriptosResponseDto(String nombre, Long cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
	
		

	}
	
	
