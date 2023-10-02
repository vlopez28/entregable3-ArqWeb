package com.integrador.domain;

import java.util.HashSet;
import java.util.Set;

import com.integrador.services.dto.carrera.CarreraRequestDto;
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
public class Carrera {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int carreraId;
	@Column
	private String nombre;

	@Column
	private int duracion;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "carrera")
	private Set<EstudianteCarrera> estudiantes;

	
	public Carrera() {
		// this.estudiantes = null;

	}

	public Carrera(CarreraRequestDto request) {
		this.nombre = request.getNombre();
		this.duracion = request.getDuracion();
		this.estudiantes = new HashSet<EstudianteCarrera>();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Set<EstudianteCarrera> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<EstudianteCarrera> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public int getId_carrera() {
		return carreraId;
	}

	public int getDuracion() {
		return duracion;
	}

	@Override
	public String toString() {
		return "Carrera [id_carrera=" + carreraId + ", nombre=" + nombre + "]";
	}

}

