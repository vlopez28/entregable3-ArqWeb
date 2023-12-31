package com.integrador.web.rest.estudianteCarrera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integrador.domain.EstudianteCarrera;
import com.integrador.services.EstudianteCarreraService;
import com.integrador.services.dto.Reporte.ReporteResponseDto;
import com.integrador.services.dto.carrera.CarreraResponseDto;
import com.integrador.services.dto.carreraConInscriptos.CarreraConInscriptosResponseDto;
import com.integrador.services.dto.estudiante.EstudianteRequestDto;
import com.integrador.services.dto.estudiante.EstudianteResponseDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraRequestDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraResponseDto;
import com.integrador.services.dto.estudiantePorCarreraCiudad.EstudiantesPorCarrerasPorCiudadResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/estudianteCarrera")
@RequiredArgsConstructor
public class EstudianteCarreraResource {
	
	@Autowired
	private  EstudianteCarreraService estudianteCarreraService;
	
	@GetMapping("")
	public List<EstudianteCarreraResponseDto> findAll(){
	    return this.estudianteCarreraService.findAll();
	}
	
	@GetMapping("/{id}")
	public EstudianteCarreraResponseDto findById (@PathVariable int id){
	    return this.estudianteCarreraService.findById(id);
	}
	
	@GetMapping("/carreraConInscriptos")
	public List<CarreraConInscriptosResponseDto> carrerasConInscriptosPorCantInsc(){
	        return this.estudianteCarreraService.carrerasConInscriptosPorCantInsc();
	}
	    
	    
	@GetMapping("/estudiantesPorCarreraPorCiudad/{ciudadResidencia}/{carrera}")
	public List<EstudiantesPorCarrerasPorCiudadResponseDto> estudiantesPorCarreraFiltradoCiudad(@PathVariable String ciudadResidencia,@PathVariable String carrera){
		return this.estudianteCarreraService.estudiantesPorCarreraFiltradoCiudad(ciudadResidencia, carrera);
    		  
	}
	
	@PostMapping("")
	public ResponseEntity<EstudianteCarreraResponseDto> save( @RequestBody @Validated EstudianteCarreraRequestDto request ){
	    final var result = this.estudianteCarreraService.save( request );
	    return ResponseEntity.accepted().body( result );
	}
	
	
	@GetMapping("/Reporte")
	public List<ReporteResponseDto> getReporte(){
	    return this.estudianteCarreraService.getReporte();
	}
}
