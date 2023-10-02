package com.integrador.services.exception;



import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class NotFoundException extends RuntimeException {

    private final String message;

    public NotFoundException( String entity, Integer id ){
        this.message = String.format( "La entidad %s con id %s no existe.", entity, id );
    }
}
