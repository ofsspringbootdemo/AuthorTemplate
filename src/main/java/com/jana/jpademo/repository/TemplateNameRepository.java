package com.jana.jpademo.repository;

import com.jana.jpademo.model.TemplateName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateNameRepository extends JpaRepository<TemplateName, Long> {

    List<TemplateName> getByTemplateTypeId(Long id);
}
