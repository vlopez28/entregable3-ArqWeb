package com.integrador.services.dto.estudiantePorCarreraCiudad;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.Carrera;
import com.integrador.domain.Estudiante;
import com.integrador.domain.EstudianteCarrera;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EstudiantesPorCarrerasPorCiudadResponseDto {
	private String nombre;
	private String apellido;
	private int LU;
	private String ciudad;
	private String nombreCarrera;
	
	public EstudiantesPorCarrerasPorCiudadResponseDto(EstudianteCarrera ec) {
		this.nombre = ec.getEstudiante().getNombre();
		this.apellido = ec.getEstudiante().getApellido();
		this.LU = ec.getEstudiante().getLU();
		this.ciudad = ec.getEstudiante().getCiudadResidencia();
		this.nombreCarrera = ec.getCarrera().getNombre();
	}
	
}
