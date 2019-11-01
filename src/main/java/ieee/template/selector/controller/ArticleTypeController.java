package ieee.template.selector.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ieee.template.selector.model.ArticleType;
import ieee.template.selector.service.ArticleTypeService;
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
@RequestMapping("/publication/type/{typeId}/title/{titleId}/article")
public class ArticleTypeController {

    @Autowired
    private ArticleTypeService service;

    @PostMapping
    public void saveArticleType(@RequestParam("jsonString") String articleTypeJson,
                                @RequestPart("file") MultipartFile[] files) throws IOException {
        service.saveOrUpdate(convertToObject(articleTypeJson), files);
    }

    @PutMapping
    public void updateArticleType(@RequestParam("jsonString") String articleTypeJson,
                                  @RequestPart("file") MultipartFile[] files) throws IOException {
        service.saveOrUpdate(convertToObject(articleTypeJson), files);
    }

    @GetMapping
    public List<ArticleType> getArticleTypesByPublicationTitleId(@PathVariable("titleId") Long id) {
        return service.getArticleTypesByPublicationTitleId(id);
    }

    @DeleteMapping("/{id}")
    public void deleteArticleType(@PathVariable("id") Long id) {
        service.deleteArticleType(id);
    }

    private ArticleType convertToObject(String articleTypeString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(articleTypeString, ArticleType.class);
    }
}
