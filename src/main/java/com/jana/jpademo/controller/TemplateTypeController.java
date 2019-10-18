package com.jana.jpademo.controller;

import com.jana.jpademo.model.ArticleType;
import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.model.TemplateName;
import com.jana.jpademo.model.TemplateType;
import com.jana.jpademo.service.ArticleTypeService;
import com.jana.jpademo.service.FileDownloadService;
import com.jana.jpademo.service.TemplateNameService;
import com.jana.jpademo.service.TemplateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
