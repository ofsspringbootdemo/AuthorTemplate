package com.jana.jpademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jana.jpademo.service.TemplateTypeService;
import com.jana.jpademo.vo.AuthTemplateVO;

@RestController
@RequestMapping("/template")
public class TemplateController {
	@Autowired
	private TemplateTypeService templateTypeService;

	@GetMapping
	public AuthTemplateVO getTemplateDetails(@RequestParam(required = false) String templateTypeID,
			@RequestParam(required = false) String templateNameID,
			@RequestParam(required = false) String articleTypeID) {
		return templateTypeService.getAuthTemplate(templateTypeID, templateNameID, articleTypeID);

	}
}
