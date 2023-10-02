package com.integrador.repository;

import com.integrador.domain.Carrera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Arrays;
import java.util.List;

public interface CarreraRepository extends JpaRepository<Carrera,Integer> {

}
