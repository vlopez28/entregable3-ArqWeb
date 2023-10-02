package com.integrador.web.rest.carrera;

import com.integrador.services.CarreraService;
import com.integrador.services.dto.carrera.CarreraRequestDto;
import com.integrador.services.dto.carrera.CarreraResponseDto;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/carreras")
@RequiredArgsConstructor
public class CarreraResource {
	@Autowired
    private CarreraService carreraService;

    @GetMapping("")
    public List<CarreraResponseDto > findAll(){
        return this.carreraService.findAll();
    }

    @GetMapping("/{id}")
    public CarreraResponseDto findById (@PathVariable int id){
        return this.carreraService.findById(id);
    }

    @PostMapping("")
    public ResponseEntity<CarreraResponseDto> save (@RequestBody CarreraRequestDto request){
        final var result = this.carreraService.save(request);
        return ResponseEntity.accepted().body(result);
    }
}
