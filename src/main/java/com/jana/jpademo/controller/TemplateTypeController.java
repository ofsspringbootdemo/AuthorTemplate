package com.jana.jpademo.controller;

import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.service.TemplateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Jana on 10/15/2019.
 */
@RestController
@RequestMapping("/getTemplateType")
public class TemplateTypeController {

    @Autowired
    TemplateTypeService service;

    @PostMapping
    public void saveOrUpdateTemplateType(@RequestBody TemplateType templateType) {
        service.saveOrUpdate(templateType);
    }

    @GetMapping
    public List<TemplateType> getTemplateTypes() {
        return service.getAllTemplateType();
    }
}
