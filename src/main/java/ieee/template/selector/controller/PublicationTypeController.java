package ieee.template.selector.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ieee.template.selector.model.PublicationType;
import ieee.template.selector.service.PublicationTypeService;
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
@RequestMapping("/publication/type")
public class PublicationTypeController {

    @Autowired
    private PublicationTypeService service;

    @PostMapping
    public void savePublicationType(@RequestParam("jsonString") String publicationTypeJson,
                                    @RequestPart("file") MultipartFile[] files) throws IOException {
        service.saveOrUpdate(convertToObject(publicationTypeJson), files);
    }

    @PutMapping
    public void updatePublicationType(@RequestParam("jsonString") String publicationTypeJson,
                                      @RequestPart("file") MultipartFile[] files) throws IOException {
        service.saveOrUpdate(convertToObject(publicationTypeJson), files);
    }

    @GetMapping
    public List<PublicationType> getPublicationTypes() {
        return service.getAllPublicationType();
    }

    @DeleteMapping("/{id}")
    public void deletePublicationType(@PathVariable("id") Long id) {
        service.deletePublicationType(id);
    }

    private PublicationType convertToObject(String publicationTypeString) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(publicationTypeString, PublicationType.class);
    }
}
