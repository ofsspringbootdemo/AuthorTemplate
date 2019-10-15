package com.jana.jpademo.service;

import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.repository.TemplateTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Jana on 10/14/2019.
 */
@Service
public class TemplateTypeService {

    @Autowired
    TemplateTypeRepository repository;

    public void saveOrUpdate(TemplateType templateType) {
        repository.save(templateType);
    }

    public Optional<TemplateType> getTemplateTypeById(Long id) {
        return repository.findById(id);
    }

    public List<TemplateType> getAllTemplateType() {
        return repository.findAll();
    }

    public void deleteTemplateType(Long id) {
        repository.deleteById(id);
    }
}
