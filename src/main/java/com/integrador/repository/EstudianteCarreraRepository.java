package com.integrador.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.integrador.domain.Estudiante;
import com.integrador.domain.EstudianteCarrera;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraResponseDto;

public interface EstudianteCarreraRepository extends JpaRepository<EstudianteCarrera, Integer> {

	
//
//	@Override
//	public void matricularEstudiante(int idEst, int idCarr, Timestamp fechaInsc, Timestamp fechaEgreso) {
//		Estudiante e = em.find(Estudiante.class, idEst);
//		Carrera c = em.find(Carrera.class, idCarr);
//		CarreraEstudianteId claveComp = new CarreraEstudianteId();
//		EstudianteCarrera estCarr = new EstudianteCarrera(e, c, fechaInsc, fechaEgreso, claveComp);
//
//		this.em.getTransaction().begin();
//		em.persist(estCarr);
//		this.em.getTransaction().commit();
//
//	}
	
	
	
//	void matricularEstudiante(int idEst, int idCarr, Timestamp fechaInsc, Timestamp fechaEgreso);
	@Query ("SELECT c FROM Carrera c JOIN  c.estudiantes e GROUP BY c ORDER BY COUNT(e) DESC")
	List<EstudianteCarreraResponseDto> carrerasConInscriptosPorCantInsc();
	
	
//	@Query("SELECT e FROM Estudiante e JOIN EstudianteCarrera ec ON ec.estudiante = e.estudianteId JOIN Carrera c ON c.carreraId = ec.carrera WHERE e.ciudadResidencia = tandil AND c.carreraId = 2")
//	List<EstudianteCarrera> estudiantesPorCarreraFiltradoCiudad(int idCarrera, String ciudad);
//	
//	
//	@Query("SELECT nombreCarrera, anio, SUM(cantidadInscriptos) AS inscriptos,  SUM(cantidadEgresados) AS egresados "
//			+ "FROM ("
//			+ "(SELECT c.nombre AS nombreCarrera, COUNT(ec.estudiante_id) AS cantidadInscriptos, 0 AS cantidadEgresados,EXTRACT(YEAR FROM ec.fecha_inscripcion) AS anio "
//			+ "FROM estudiante_carrera ec JOIN Carrera c on c.carrera_id= ec.carrera_id "
//			+ "GROUP BY nombreCarrera, anio ) " + "UNION ALL "
//			+ "(SELECT c1.nombre AS nombreCarrera, 0 AS cantidadInscriptos ,COUNT(ec1.estudiante_id) AS cantidadEgresados, EXTRACT(YEAR FROM ec1.fecha_egreso) AS anio "
//			+ "FROM estudiante_carrera ec1 JOIN Carrera c1 on c1.carrera_id=ec1.carrera_id "
//			+ "GROUP BY nombreCarrera, anio ) )s " + "WHERE anio IS NOT NULL "
//			+ "GROUP BY nombreCarrera, anio " + "ORDER BY nombreCarrera ,anio")
//	List<Object[]> getInforme();
	

}
