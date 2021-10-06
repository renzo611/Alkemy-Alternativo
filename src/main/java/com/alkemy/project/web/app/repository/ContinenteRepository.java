package com.alkemy.project.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.project.web.app.dto.ContinenteDto;
import com.alkemy.project.web.app.entity.ContinenteEntity;

@Repository
public interface ContinenteRepository extends JpaRepository<ContinenteEntity,Long>{


}
