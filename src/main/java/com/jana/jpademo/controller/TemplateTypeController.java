package com.jana.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.service.TemplateTypeService;

/**
 * Created by Jana on 10/15/2019.
 */
@RestController
@RequestMapping("/templateType")
public class TemplateTypeController {

	@Autowired
	private TemplateTypeService service;

	@PostMapping
	public void saveTemplateType(@RequestParam("jsonString") String templateTypeJson,
			@RequestPart("file") MultipartFile[] file) {
		Gson gson = new GsonBuilder().create();
		TemplateType templateType = gson.fromJson(templateTypeJson, TemplateType.class);
		service.saveOrUpdate(templateType, file);
	}

	@PutMapping
	public void updateTemplateType(@RequestParam("jsonString") String templateTypeJson,
			@RequestPart("file") MultipartFile[] file) {
		Gson gson = new GsonBuilder().create();
		TemplateType templateType = gson.fromJson(templateTypeJson, TemplateType.class);
		service.saveOrUpdate(templateType, file);
	}

	@GetMapping
	public List<TemplateType> getTemplateTypes() {
		return service.getAllTemplateType();
	}
}
