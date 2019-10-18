package com.jana.jpademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public void saveOrUpdateTemplateType(@RequestBody TemplateType templateType) {
        service.saveOrUpdate(templateType);
    }

    @GetMapping
    public List<TemplateType> getTemplateTypes() {
        return service.getAllTemplateType();
    }
}
