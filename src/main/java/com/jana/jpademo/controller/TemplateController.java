package com.jana.jpademo.controller;

import com.jana.jpademo.model.ArticleType;
import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.model.TemplateName;
import com.jana.jpademo.service.ArticleTypeService;
import com.jana.jpademo.service.FileDownloadService;
import com.jana.jpademo.service.TemplateNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/template")
public class TemplateController {

    @Autowired
    private TemplateNameService templateNameService;

    @Autowired
    private ArticleTypeService articleTypeService;

    @Autowired
    private FileDownloadService fileDownloadService;

    @GetMapping("/getTemplateByTemplateType")
    public List<TemplateName> getTemplateNamesByTemplateTypeId(@RequestParam("templateTypeID") String templateTypeID) {
        return templateNameService.getTemplateNamesByTemplateTypeId(Long.valueOf(templateTypeID));
    }

    @GetMapping("/getTemplateByTemplateName")
    public List<ArticleType> getArticleTypesByTemplateNameId(@RequestParam("templateNameID") String templateNameID) {
        return articleTypeService.getArticleTypesByTemplateNameId(Long.valueOf(templateNameID));
    }

    @GetMapping("/getFileDownloadByTemplateType")
    public List<FileDownload> getFileDownloadsByTemplateTypeId(@RequestParam("id") String id) {
        return fileDownloadService.getFileDownloadsByTemplateTypeId(Long.valueOf(id));
    }

    @GetMapping("/getFileDownloadByTemplateName")
    public List<FileDownload> getFileDownloadsByTemplateNameId(@RequestParam("id") String id) {
        return fileDownloadService.getFileDownloadsByTemplateNameId(Long.valueOf(id));
    }

    @GetMapping("/getFileDownloadByArticleType")
    public List<FileDownload> getFileDownloadsByArticleTypeId(@RequestParam("id") String id) {
        return fileDownloadService.getFileDownloadsByArticleTypeId(Long.valueOf(id));
    }
}
