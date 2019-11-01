package ieee.template.selector.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ieee.template.selector.model.TemplateFile;
import ieee.template.selector.service.TemplateFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/publication/type/{typeId}")
public class TemplateFileController {

    @Autowired
    private TemplateFileService service;

    @PostMapping
    public void saveTemplateFile(@RequestParam("jsonString") String templateFileString,
                                 @RequestPart("file") MultipartFile[] files) throws IOException {
        service.saveOrUpdate(convertToObject(templateFileString), files);
    }

    @PutMapping
    public void updateTemplateFile(@RequestParam("jsonString") String templateFileString,
                                   @RequestPart("file") MultipartFile[] files) throws IOException {
        service.saveOrUpdate(convertToObject(templateFileString), files);
    }

    @DeleteMapping("/template/{id}")
    public void deleteTemplateFile(@PathVariable("id") Long id) {
        service.deleteTemplateFile(id);
    }

    private TemplateFile convertToObject(String fileDownloadString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(fileDownloadString, TemplateFile.class);
    }

    @GetMapping("/templates")
    public List<TemplateFile> getTemplateFiles(@PathVariable("typeId") Long publicationTypeId) {
        return service.getTemplateFilesByPublicationTypeId(publicationTypeId);
    }

    @GetMapping("/title/{titleId}/templates")
    public List<TemplateFile> getTemplateFiles(@PathVariable("typeId") Long publicationTypeId,
                                               @PathVariable("titleId") Long titleId) {
        return service.getTemplateFilesByPublicationTitleId(titleId);
    }

    @GetMapping("/title/{titleId}/article/{articleId}/templates")
    public List<TemplateFile> getTemplateFiles(@PathVariable("typeId") Long publicationTypeId,
                                               @PathVariable("titleId") Long titleId,
                                               @PathVariable("articleId") Long articleId) {
        return service.getTemplateFilesByArticleTypeId(articleId);
    }
}
