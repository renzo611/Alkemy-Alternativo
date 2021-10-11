package com.alkemy.project.web.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.project.web.app.entity.CiudadEntity;

@Repository
public interface CiudadRepository extends JpaRepository<CiudadEntity, Long>{
	List<CiudadEntity> findByDenominacion(String denominacion);
	List<CiudadEntity> findByContinenteId(Long continenteid);
}
