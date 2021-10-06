package com.alkemy.project.web.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alkemy.project.web.app.entity.IconoEntity;

@Repository
public interface IconoRepository extends JpaRepository<IconoEntity, Long>{

}
