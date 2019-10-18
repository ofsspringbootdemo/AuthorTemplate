package com.jana.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.service.TemplateTypeService;
import com.jana.jpademo.vo.AuthTemplateVO;

/**
 * Created by Jana on 10/15/2019.
 */
@RestController
@RequestMapping("/template")
public class TemplateTypeController {

	@Autowired
	TemplateTypeService service;

	@PostMapping("/addTemplateType")
	public void saveOrUpdateTemplateType(@RequestBody TemplateType templateType) {
		service.saveOrUpdate(templateType);
	}

	@GetMapping("/getTemplateType")
	public List<TemplateType> getTemplateTypes() {
		return service.getAllTemplateType();
	}

	@GetMapping("/getTemplate")
	public AuthTemplateVO getTemplateDetails(@RequestParam(required = false) String templateTypeID,
			@RequestParam(required = false) String templateNameID,
			@RequestParam(required = false) String articleTypeID) {
		System.out.println("publicationNameID" + templateNameID);
		return service.getAuthTemplate(templateTypeID, templateNameID, articleTypeID);
	}
}
