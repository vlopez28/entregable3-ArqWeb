package com.integrador.services;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.integrador.domain.Estudiante;
import com.integrador.repository.EstudianteRepository;

import com.integrador.services.dto.estudiante.EstudianteRequestDto;
import com.integrador.services.dto.estudiante.EstudianteResponseDto;
import com.integrador.services.exception.NotFoundException;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Service
public class EstudianteService{
	 
	  

	 private  EstudianteRepository estudianteRepository;
	 
	 public EstudianteService( EstudianteRepository estudianteRepository ) { 
		 this.estudianteRepository = estudianteRepository;
	 }
	
		 @Transactional
	    public EstudianteResponseDto save(EstudianteRequestDto request ){
	        Estudiante estudiante = new Estudiante(request);
	        Estudiante result = this.estudianteRepository.save(estudiante);
	        return new EstudianteResponseDto(result);
	    }
	    
	    
	  

	    @Transactional
	    public List<EstudianteResponseDto> findAll(){
	        return this.estudianteRepository.findAll().stream().map( EstudianteResponseDto::new ).toList();
	    }

	    @Transactional
	    public EstudianteResponseDto findById( Integer id ){
	        return this.estudianteRepository.findById( id )
	                .map( EstudianteResponseDto::new )
	                .orElseThrow( () -> new NotFoundException("Estudiante", id ) );
	    }
	    
	    @Transactional( readOnly = true )
	    public EstudianteResponseDto findByLibreta( Integer LU ){
	        return this.estudianteRepository.findByLibreta( LU ).map( e -> new EstudianteResponseDto(e) )
	        		.orElseThrow();
	    }
	    

	    @Transactional
	    public List<EstudianteResponseDto> estudiantesPorApellido ( ){
	        return this.estudianteRepository.estudiantesPorApellido()
	                .stream().map( EstudianteResponseDto::new ).toList();
	    }
	    
	   
	    @Transactional
	    public List<EstudianteResponseDto> estudiantePorGenero(String genero ){
	        return this.estudianteRepository.findByGenero(genero )
	                .stream().map( EstudianteResponseDto::new ).toList();
	    }
	    
	    
	    

	}

	
	
	
	
	
	
	
	
	
	
