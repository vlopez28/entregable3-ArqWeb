package com.integrador.services.dto.estudianteCarrera;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.Carrera;
import com.integrador.domain.CarreraEstudianteId;
import com.integrador.domain.Estudiante;
import com.integrador.domain.EstudianteCarrera;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EstudianteCarreraResponseDto {

	private CarreraEstudianteId idEstudianteCarrera;

	private Estudiante estudiante;

	private Carrera carrera;
	
	private Timestamp fecha_inscripcion;
	
	private Timestamp fecha_egreso;
	
	private int antiguedad;
	
	private Boolean graduado;

	public EstudianteCarreraResponseDto(EstudianteCarrera ec) {
		this.idEstudianteCarrera = ec.getIdEstudianteCarrera();
		this.estudiante = ec.getEstudiante();
		this.carrera = ec.getCarrera();
		this.fecha_inscripcion = ec.getAnio_inscripcion();
		this.fecha_egreso = ec.getAnio_egreso();
		this.antiguedad = ec.getAntiguedad(fecha_inscripcion);
		this.graduado = ec.isGraduado();
	}
	
	
	
}
