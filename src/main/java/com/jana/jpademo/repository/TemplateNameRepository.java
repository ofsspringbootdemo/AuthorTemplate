package com.jana.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jana.jpademo.model.TemplateName;

/**
 * Created by Jana on 10/14/2019.
 */
public interface TemplateNameRepository extends JpaRepository<TemplateName, Long> {
}
