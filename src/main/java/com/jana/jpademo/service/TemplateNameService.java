package com.jana.jpademo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jana.jpademo.model.TemplateName;
import com.jana.jpademo.repository.TemplateNameRepository;

@Service
public class TemplateNameService {

	@Autowired
	private TemplateNameRepository repository;

	public List<TemplateName> getTemplateNamesByTemplateTypeId(Long id) {
		return repository.getByTemplateTypeId(id);
	}

	public void updateTemplateName(TemplateName templateName) {
		TemplateName templateTypeToUpdate = repository.getOne(Long.valueOf(templateName.getId()));
		templateTypeToUpdate.setName(templateName.getName());
		repository.save(templateTypeToUpdate);
	}
}
