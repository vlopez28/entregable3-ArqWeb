package com.integrador.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.integrador.domain.CarreraEstudianteId;
import com.integrador.domain.EstudianteCarrera;
import com.integrador.repository.CarreraRepository;
import com.integrador.repository.EstudianteCarreraRepository;
import com.integrador.repository.EstudianteRepository;
import com.integrador.services.dto.Reporte.ReporteResponseDto;
import com.integrador.services.dto.carreraConInscriptos.CarreraConInscriptosResponseDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraRequestDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraResponseDto;
import com.integrador.services.dto.estudiantePorCarreraCiudad.EstudiantesPorCarrerasPorCiudadResponseDto;
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

	@Transactional
	public List<EstudiantesPorCarrerasPorCiudadResponseDto> estudiantesPorCarreraFiltradoCiudad(String ciudadResidencia, String carrera){
		return this.estCarreraRepository.estudiantesPorCarreraFiltradoCiudad(ciudadResidencia, carrera).stream()
				.map(EstudiantesPorCarrerasPorCiudadResponseDto::new)
				.toList();
	}	
	
	@Transactional
	public List<CarreraConInscriptosResponseDto> carrerasConInscriptosPorCantInsc(){
		return this.estCarreraRepository.carrerasConInscriptosPorCantInsc();
	}
	
	@Transactional
    public EstudianteCarreraResponseDto save(EstudianteCarreraRequestDto request){
		
		final var e = estRepository.findById(request.getId_estudiante()).orElseThrow(() -> new NotFoundException(String.format("No existe la estudiante con id %s", request.getId_estudiante()) ) );
		final var c = carreraRepository.findById(request.getId_carrera()).orElseThrow( () -> new NotFoundException(String.format("No existe la carrera con id %s", request.getId_carrera() ) ) );
		
		int idEst = request.getId_estudiante();
		int idCarr = request.getId_carrera();
		CarreraEstudianteId id = new CarreraEstudianteId(idEst, idCarr);
		
		EstudianteCarrera estCarr = new EstudianteCarrera(request, e, c, id);
        final var result = this.estCarreraRepository.save( estCarr );
        return new EstudianteCarreraResponseDto(result);
    }
	

    @Transactional
    public List<EstudianteCarreraResponseDto> findAll(){
        return this.estCarreraRepository.findAll().stream().map(EstudianteCarreraResponseDto::new).toList();
    }
    
    @Transactional
    public EstudianteCarreraResponseDto findById(int id){
    	return this.estCarreraRepository.findById(id)
    		.map(EstudianteCarreraResponseDto::new).orElseThrow(()->new NotFoundException("EstudianteCarrera", id));
    }
    
    @Transactional
	public List<ReporteResponseDto> getReporte(){
	 return this.estCarreraRepository.getInforme().stream().map(ReporteResponseDto::new).toList();
	}

}
