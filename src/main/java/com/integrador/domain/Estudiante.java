package com.integrador.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.integrador.services.dto.estudiante.EstudianteRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Estudiante {
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name = "estudiante_id")
	private int estudianteId;
	@Column
	private int dni;
	@Column
	private String nombre;
	@Column
	private String apellido;
	@Column
	private int edad;
	@Column
	private String genero;
	
	@Column (name="ciudad")
	private String ciudadResidencia;
	
	@Column
	private int LU;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estudiante")
	private Set<EstudianteCarrera> carreras;
	
	public Estudiante() {
		
	}
	public Estudiante(EstudianteRequestDto request) {
		this.nombre = request.getNombre();
		this.apellido = request.getApellido();
		this.edad = request.getEdad();
		this.genero = request.getGenero();
		this.dni = request.getDni();
		this.ciudadResidencia = request.getCiudadResidencia();
		this.LU = request.getLU();
		/*this.carreras = new HashSet<EstudianteCarrera>();*/
	}

	
	
	
	
	public int getEstudianteId() {
		return estudianteId;
	}





	public int getDni() {
		return dni;
	}





	public String getNombre() {
		return nombre;
	}





	public String getApellido() {
		return apellido;
	}





	public int getEdad() {
		return edad;
	}





	public String getGenero() {
		return genero;
	}





	public String getCiudadResidencia() {
		return ciudadResidencia;
	}





	public int getLU() {
		return LU;
	}





	public Set<EstudianteCarrera> getCarreras() {
		return carreras;
	}





	@Override
	public String toString() {
		return "Estudiante [id_estudiante=" + estudianteId + ", dni=" + dni + ", nombre=" + nombre + ", apellido="
				+ apellido + ", edad=" + edad + ", genero=" + genero + ", ciudadResidencia=" + ciudadResidencia
				+ ", LU=" + LU + ", carreras=" + carreras + "]";
	}
	


	
	
}
