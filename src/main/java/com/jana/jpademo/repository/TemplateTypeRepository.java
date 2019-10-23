package com.jana.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jana.jpademo.model.TemplateType;

/**
 * Created by Jana on 10/14/2019.
 */
public interface TemplateTypeRepository extends JpaRepository<TemplateType, Long> {
}
