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
import com.integrador.services.dto.carrera.CarreraResponseDto;
import com.integrador.services.dto.estudiante.EstudianteRequestDto;
import com.integrador.services.dto.estudiante.EstudianteResponseDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraRequestDto;
import com.integrador.services.dto.estudianteCarrera.EstudianteCarreraResponseDto;

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
    public List<EstudianteCarreraResponseDto> carrerasConInscriptosPorCantInsc(){
        return this.estudianteCarreraService.carrerasConInscriptosPorCantInsc();
    }
//    
//    @PostMapping("")
//    public ResponseEntity<EstudianteCarreraResponseDto> save( @RequestBody @Validated EstudianteCarreraRequestDto request ){
//        final var result = this.estudianteCarreraService.save( request );
//        return ResponseEntity.accepted().body( result );
//    }
	


}
