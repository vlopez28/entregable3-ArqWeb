package com.integrador.web.rest.estudiante;

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

import com.integrador.domain.Estudiante;
import com.integrador.services.EstudianteService;
import com.integrador.services.dto.estudiante.EstudianteRequestDto;
import com.integrador.services.dto.estudiante.EstudianteResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/estudiantes")
@RequiredArgsConstructor
public class EstudianteResource {
	@Autowired
	private  EstudianteService estudianteService;

    @GetMapping("")
    public List<EstudianteResponseDto> findAll(){
        return this.estudianteService.findAll();
    }

    @GetMapping("/{id}")
    public EstudianteResponseDto findById( @PathVariable Integer id ){
        return this.estudianteService.findById( id );
    }

    @GetMapping("/LU/{LU}")
    public EstudianteResponseDto findByLibreta( @PathVariable int LU ){
        return this.estudianteService.findByLibreta( LU );
    }

    
    @GetMapping("/OrdenadosPorApellido")
    public List<EstudianteResponseDto> estudiantesPorApellido( EstudianteRequestDto request ){
        return this.estudianteService.estudiantesPorApellido( );
    }
    
    @GetMapping("/genero/{genero}")
    public List<EstudianteResponseDto> findByGenero( @PathVariable String genero ){
        return this.estudianteService.estudiantePorGenero(genero );
    }
    
    

    @PostMapping("")
    public ResponseEntity<EstudianteResponseDto> save( @RequestBody @Validated EstudianteRequestDto request ){
        final var result = this.estudianteService.save( request );
        return ResponseEntity.accepted().body( result );
    }
	
	
	
	
	
	

}
