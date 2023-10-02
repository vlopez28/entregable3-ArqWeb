package com.integrador.services;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.integrador.domain.Carrera;
import com.integrador.domain.CarreraEstudianteId;
import com.integrador.domain.Estudiante;
import com.integrador.domain.EstudianteCarrera;
import com.integrador.repository.CarreraRepository;
import com.integrador.repository.EstudianteCarreraRepository;
import com.integrador.repository.EstudianteRepository;
import com.integrador.services.dto.carrera.CarreraResponseDto;
import com.integrador.services.dto.estudiante.EstudianteResponseDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraRequestDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraResponseDto;
import com.integrador.services.exception.NotFoundException;

import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class EstudianteCarreraService {
	
	@Autowired 
	private EstudianteCarreraRepository estCarreraRepository;
	@Autowired 
	private CarreraRepository carreraRepository;
	@Autowired 
	private EstudianteRepository estRepository;
	
//	@Transactional
//	List<CarreraResponseDto> carrerasConInscriptosPorCantInsc(){
//		return this.estCarreraRepository.carrerasConInscriptosPorCantInsc().stream().map(CarreraResponseDto::new).toList();
//	}
	@Transactional
    public EstudianteCarreraResponseDto save(EstudianteCarreraRequestDto request){
		
		final var e = estRepository.findById(request.getId_estudiante()).orElseThrow(() -> new NotFoundException(String.format("No existe la estudiante con id %s", request.getId_estudiante()) ) );
		final var c = carreraRepository.findById(request.getId_carrera()).orElseThrow( () -> new NotFoundException(String.format("No existe la carrera con id %s", request.getId_carrera() ) ) );
		
		//creo carrEstId
		int idEst = request.getId_estudiante();
		int idCarr = request.getId_carrera();
		CarreraEstudianteId id = new CarreraEstudianteId(idEst, idCarr);
		
		EstudianteCarrera estCarr = new EstudianteCarrera(request, e, c, id);
        final var result = this.estCarreraRepository.save( estCarr );
        return new EstudianteCarreraResponseDto(result);
    }
	
//	CarreraEstudianteId idEstudianteCarrera, Estudiante estudiante, Carrera carrera,
//	Timestamp fecha_inscripcion, Timestamp fecha_egreso, int antiguedad, Boolean graduado)

    @Transactional
    public List<EstudianteCarreraResponseDto> findAll(){
        return this.estCarreraRepository.findAll().stream().map(EstudianteCarreraResponseDto::new).toList();
    }
    
    @Transactional
    public EstudianteCarreraResponseDto findById(int id){
    	return this.estCarreraRepository.findById(id)
    		.map(EstudianteCarreraResponseDto::new).orElseThrow(()->new NotFoundException("EstudianteCarrera", id));
    }
    
//    @Transactional
//    public List<EstudianteCarreraResponseDto> carrerasConInscriptosPorCantInsc(){
//    	return this.estCarreraRepository.carrerasConInscriptosPorCantInsc();
//    }
//	
   
}
