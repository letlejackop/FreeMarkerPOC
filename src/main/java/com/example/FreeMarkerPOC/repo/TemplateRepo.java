package com.example.FreeMarkerPOC.repo;

import com.example.FreeMarkerPOC.entity.TemplateEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface TemplateRepo extends JpaRepository<TemplateEntity, Long> {
    Optional<TemplateEntity> findByName(String name);
}
