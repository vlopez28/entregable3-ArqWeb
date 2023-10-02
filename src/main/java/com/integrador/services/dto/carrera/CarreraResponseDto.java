package com.integrador.services.dto.carrera;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.integrador.domain.Carrera;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class CarreraResponseDto {
    private  int id;
    private String nombre;
    private int cantidad;
    private int duracion; 
    
    

    public CarreraResponseDto(String nombre, int cantidad) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
	}
    
    

	public CarreraResponseDto(Carrera c){
        this.id= c.getId_carrera();
        this.duracion=c.getDuracion();
        this.nombre=c.getNombre();
    }

//	public int getId() {
//		return id;
//	}
//
//	public String getNombre() {
//		return nombre;
//	}
//
//	public int getDuracion() {
//		return duracion;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public void setNombre(String nombre) {
//		this.nombre = nombre;
//	}
//
//	public void setDuracion(int duracion) {
//		this.duracion = duracion;
//	}

    
    
}