package com.integrador.services.dto.estudianteCarrera;

import java.sql.Timestamp;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.integrador.domain.Carrera;
import com.integrador.domain.CarreraEstudianteId;
import com.integrador.domain.Estudiante;

import lombok.Data;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class EstudianteCarreraRequestDto {

//	private CarreraEstudianteId idEstudianteCarrera;
//
//	private Estudiante estudiante;
//
//	private Carrera carrera;
	private int id_estudiante;
	
	private int id_carrera;
	
	
	
	private Timestamp fecha_inscripcion;
	
	private Timestamp fecha_egreso;
	
	private int antiguedad;
	
	private Boolean graduado;
	
	
	
//
//	public EstudianteCarreraRequestDto(CarreraEstudianteId idEstudianteCarrera, Estudiante estudiante, Carrera carrera,
//			Timestamp fecha_inscripcion, Timestamp fecha_egreso, int antiguedad, Boolean graduado) {
//		super();
//		this.idEstudianteCarrera = idEstudianteCarrera;
//		this.estudiante = estudiante;
//		this.carrera = carrera;
//		this.fecha_inscripcion = fecha_inscripcion;
//		this.fecha_egreso = fecha_egreso;
//		this.antiguedad = antiguedad;
//		this.graduado = graduado;
//	}

	public int getId_estudiante() {
		return id_estudiante;
	}

	public int getId_carrera() {
		return id_carrera;
	}

	public boolean verificarGraduado(Timestamp anio_egreso) {
		return !(anio_egreso == null);
	}
	
//	public CarreraEstudianteId getIdEstudianteCarrera() {
//		
//		return idEstudianteCarrera;
//	}
//
//	public Estudiante getEstudiante() {
//		return estudiante;
//	}
//
//	public Carrera getCarrera() {
//		return carrera;
//	}
	
	

	public Timestamp getFecha_inscripcion() {
		return fecha_inscripcion;
	}
//
//	public int getId_estudiante() {
//		return id_estudiante;
//	}
//
//	public int getId_carrera() {
//		return id_carrera;
//	}

	public Timestamp getFecha_egreso() {
		return fecha_egreso;
	}

	public Integer getAntiguedad(Timestamp anio_inscripcion) {
		Calendar fechaInscripcion = Calendar.getInstance();
		fechaInscripcion.setTimeInMillis(this.fecha_inscripcion.getTime());
		return Calendar.getInstance().get(Calendar.YEAR) - fechaInscripcion.get(Calendar.YEAR);
	}

	public Boolean getGraduado() {
		return graduado;
	}
	
	
	
	
}
