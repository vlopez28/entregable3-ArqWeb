package com.integrador.domain;

import java.sql.Timestamp;
import java.util.Calendar;

import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
//import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data @EqualsAndHashCode
//@Table(name ="estudiante_carrera")
public class EstudianteCarrera{
	@EmbeddedId 
	private CarreraEstudianteId idEstudianteCarrera;
	
	@ManyToOne(targetEntity = Estudiante.class, fetch = FetchType.LAZY)
	@MapsId("estudianteId")
	@JoinColumn(name = "estudiante_id")
	private Estudiante estudiante;

	@ManyToOne (targetEntity = 	Carrera.class, fetch = FetchType.LAZY)
	@MapsId("carreraId")
	@JoinColumn(name = "carrera_id")
	private Carrera carrera;
	
	@Column
	private Timestamp fecha_inscripcion;
	
	@Column
	private Timestamp fecha_egreso;
	
	@Column  //actual - inscripcion
	private int antiguedad;
	
	@Column
	private Boolean graduado;

	public EstudianteCarrera() {
		
	}
	
	 public EstudianteCarrera( EstudianteCarreraRequestDto request, Estudiante e, Carrera c, CarreraEstudianteId idEstudianteCarrera) {
		super();
	 	this.idEstudianteCarrera = idEstudianteCarrera;
	 	this.estudiante = e;
	 	this.carrera = c;
	 	this.fecha_inscripcion = request.getFecha_inscripcion();
	 	this.fecha_egreso = request.getFecha_egreso();
	 	this.graduado = request.verificarGraduado(request.getFecha_egreso());
	 	this.antiguedad = request.getAntiguedad(request.getFecha_inscripcion());
	}
	

	public boolean isGraduado() {
		return graduado;
	}
	
	public boolean verificarGraduado(Timestamp anio_egreso) {
		return !(anio_egreso == null);
	}

	public void setGraduado(boolean graduado) {
		this.graduado = graduado;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Carrera getCarrera() {
		return carrera;
	}

	public void setCarrera(Carrera carrera) {
		this.carrera = carrera;
	}

	public Timestamp getAnio_inscripcion() {
		return this.fecha_inscripcion;
	}

	public Timestamp getAnio_egreso() {
		return this.fecha_egreso;
	}

	public void setAnio_inscripcion(Timestamp anio_inscripcion) {
		this.fecha_inscripcion = anio_inscripcion;
	}

	public void setAnio_egreso(Timestamp anio_egreso) {
		this.fecha_egreso = anio_egreso;
	}

	public Integer getAntiguedad(Timestamp anio_inscripcion) {
		Calendar fechaInscripcion = Calendar.getInstance();
		fechaInscripcion.setTimeInMillis(this.fecha_inscripcion.getTime());
		return Calendar.getInstance().get(Calendar.YEAR) - fechaInscripcion.get(Calendar.YEAR);
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}

	public CarreraEstudianteId getIdEstudianteCarrera() {
		return idEstudianteCarrera;
	}

	@Override
	public String toString() {
		return "EstudianteCarrera [idEstudianteCarrera=" + idEstudianteCarrera + ", fecha_inscripcion=" + fecha_inscripcion + ", fecha_egreso=" + fecha_egreso
				+ ", antiguedad=" + antiguedad + "]";
	}

	public void setIdEstudianteCarrera(CarreraEstudianteId idComp) {
		// TODO Auto-generated method stub
		
	}

	public void setFecha_inscripcion(Timestamp inscrip) {
		// TODO Auto-generated method stub
		
	}

	
}
