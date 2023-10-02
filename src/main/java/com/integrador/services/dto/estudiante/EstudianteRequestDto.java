package com.integrador.services.dto.estudiante;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NonNull;

@Data
@JsonIgnoreProperties( ignoreUnknown = true )
public class EstudianteRequestDto {


 /*   @NonNull( message = "El nombre es un campo obligatorio.")
    @NotEmpty( message = "El nombre es un campo obligatorio.")*/
	private String apellido;
    private String nombre;
    private int edad;
    private String genero;
    private int dni;
    private String ciudadResidencia;
    private int LU;

    
    public String getApellido() {
		return apellido;
	}
	public String getNombre() {
		return nombre;
	}
	public int getEdad() {
		return edad;
	}
	public String getGenero() {
		return genero;
	}
	public String getCiudadResidencia() {
		return ciudadResidencia;
	}
	public int getLU() {
		return LU;
	}
	public int getDni() {
		return dni;
	}
//	public EstudianteRequestDto(String apellido, String nombre, int edad, String genero, int dni,
//			String ciudadResidencia, int lU) {
//		super();
//		this.apellido = apellido;
//		this.nombre = nombre;
//		this.edad = edad;
//		this.genero = genero;
//		this.dni = dni;
//		this.ciudadResidencia = ciudadResidencia;
//		LU = lU;
//	}
  
	

}
