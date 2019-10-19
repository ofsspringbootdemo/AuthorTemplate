package com.jana.jpademo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.jana.jpademo.common.TemplateConstant;
import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.repository.TemplateTypeRepository;
import com.jana.jpademo.vo.AuthTemplateVO;
import com.jana.jpademo.vo.ErrMessageVO;

/**
 * Created by Jana on 10/14/2019.
 */
@Service
public class TemplateTypeService {

	@Autowired
	private TemplateTypeRepository templateTypeRepository;
	
	public void saveOrUpdate(TemplateType templateType) {
		templateTypeRepository.save(templateType);
	}

	public Optional<TemplateType> getTemplateTypeById(Long id) {
		return templateTypeRepository.findById(id);
	}

	public List<TemplateType> getAllTemplateType() {
		return templateTypeRepository.findAll();
	}

	public void deleteTemplateType(Long id) {
		templateTypeRepository.deleteById(id);
	}

}
