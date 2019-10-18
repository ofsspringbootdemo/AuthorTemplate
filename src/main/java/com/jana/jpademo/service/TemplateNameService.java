package com.jana.jpademo.service;

import com.jana.jpademo.model.TemplateName;
import com.jana.jpademo.repository.TemplateNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TemplateNameService {

    @Autowired
    private TemplateNameRepository repository;

    public List<TemplateName> getTemplateNamesByTemplateTypeId(Long id) {
        return repository.getByTemplateTypeId(id);
    }
}
