package com.integrador.services.dto.Reporte;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class ReporteResponseDto {
	
	    private Integer cantInscriptosPorAnio;
	    private long cantInscriptosPorCarrera;
	    private long cantDeEgresados;
	    private String carrera;

	    public ReporteResponseDto (Object[] objects) {
	        if(objects.length >= 4) {
	            this.carrera = (String) objects[0];
	            this.cantInscriptosPorAnio = ((Number) objects[1]).intValue();;
	            this.cantInscriptosPorCarrera = ((Number) objects[2]).longValue();
	            this.cantDeEgresados = ((Number) objects[3]).longValue();;

	        }
	    }

		public Integer getCantInscriptosPorAnio() {
			return cantInscriptosPorAnio;
		}

		public long getCantInscriptosPorCarrera() {
			return cantInscriptosPorCarrera;
		}

		public long getCantDeEgresados() {
			return cantDeEgresados;
		}

		public String getCarrera() {
			return carrera;
		}
	    
	    


	}
	
