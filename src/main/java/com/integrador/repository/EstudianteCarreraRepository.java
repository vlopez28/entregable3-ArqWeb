package com.integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.integrador.domain.Estudiante;
import com.integrador.domain.EstudianteCarrera;
import com.integrador.services.dto.carrera.CarreraResponseDto;
import com.integrador.services.dto.carreraConInscriptos.CarreraConInscriptosResponseDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraResponseDto;
import com.integrador.services.dto.estudiantePorCarreraCiudad.EstudiantesPorCarrerasPorCiudadResponseDto;


public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Integer> {
																		
	
	@Query("SELECT new com.integrador.services.dto.carreraConInscriptos.CarreraConInscriptosResponseDto (c.nombre, COUNT(c.carreraId)) FROM Carrera c JOIN EstudianteCarrera ec ON ec.carrera.carreraId = c.carreraId GROUP BY c.carreraId ORDER BY COUNT(c.carreraId) DESC")
	public List<CarreraConInscriptosResponseDto> carrerasConInscriptosPorCantInsc();
	
	@Query ("SELECT ec FROM EstudianteCarrera ec JOIN Estudiante e ON e.estudianteId = ec.idEstudianteCarrera.estudianteId WHERE e.ciudadResidencia = :ciudadResidencia AND ec.carrera.nombre = :carrera")
	public List<EstudianteCarrera> estudiantesPorCarreraFiltradoCiudad(String ciudadResidencia, String carrera);
	

	@Query( value = "SELECT nombreCarrera, anio, SUM(cantidadInscriptos) AS inscriptos,  SUM(cantidadEgresados) AS egresados "
			+ "FROM ("
			+ "(SELECT c.nombre AS nombreCarrera, COUNT(ec.estudiante_id) AS cantidadInscriptos, 0 AS cantidadEgresados,EXTRACT(YEAR FROM ec.fecha_inscripcion) AS anio "
			+ "FROM estudiante_carrera ec JOIN Carrera c on c.carrera_id= ec.carrera_id "
			+ "GROUP BY nombreCarrera, anio ) " + "UNION ALL "
			+ "(SELECT c1.nombre AS nombreCarrera, 0 AS cantidadInscriptos ,COUNT(ec1.estudiante_id) AS cantidadEgresados, EXTRACT(YEAR FROM ec1.fecha_egreso) AS anio "
			+ "FROM estudiante_carrera ec1 JOIN Carrera c1 on c1.carrera_id=ec1.carrera_id "
			+ "GROUP BY nombreCarrera, anio ) )s " + "WHERE anio IS NOT NULL "
			+ "GROUP BY nombreCarrera, anio " + "ORDER BY nombreCarrera ,anio", nativeQuery = true)

	List<Object[]> getInforme();
	
}
