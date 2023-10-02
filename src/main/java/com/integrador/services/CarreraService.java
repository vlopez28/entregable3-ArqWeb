package com.integrador.services;

import com.integrador.domain.Carrera;
import com.integrador.domain.Estudiante;
import com.integrador.repository.CarreraRepository;
import com.integrador.services.dto.carrera.CarreraRequestDto;
import com.integrador.services.dto.carrera.CarreraResponseDto;
import com.integrador.services.exception.NotFoundException;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@NoArgsConstructor
public class CarreraService {
	@Autowired
	private CarreraRepository carreraRepository;
	
	@Transactional
	    public CarreraResponseDto save(CarreraRequestDto request){
	    final var carrera = new Carrera(request);
	    final var result = this.carreraRepository.save(carrera);
	    return new CarreraResponseDto(result);
	}

    @Transactional
    public List<CarreraResponseDto> findAll(){
    return this.carreraRepository.findAll().stream().map(CarreraResponseDto::new).toList();
    }

    @Transactional
    public CarreraResponseDto findById(int id){
    return this.carreraRepository.findById(id).map(CarreraResponseDto::new).orElseThrow(()->new NotFoundException("Carrera", id));
    }




}
