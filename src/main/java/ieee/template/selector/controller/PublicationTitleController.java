package ieee.template.selector.controller;

import java.io.IOException;
import java.util.List;

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

import com.fasterxml.jackson.databind.ObjectMapper;

import ieee.template.selector.model.PublicationTitle;
import ieee.template.selector.model.PublicationType;
import ieee.template.selector.service.PublicationTitleService;

@RestController
@RequestMapping("/publication/type/{typeId}/title")
public class PublicationTitleController {
	@Autowired
	private PublicationTitleService service;

	@PostMapping
	public void savePublicationTitle(@PathVariable("typeId") Long id,
			@RequestParam("jsonString") String publicationTitleJson, @RequestPart("file") MultipartFile[] file)
			throws IOException {
		saveOrUpdate(id, publicationTitleJson, file);
	}

	@PutMapping
	public void updatePublicationTitle(@PathVariable("typeId") Long id,
			@RequestParam("jsonString") String publicationTitleJson, @RequestPart("file") MultipartFile[] file)
			throws IOException {
		saveOrUpdate(id, publicationTitleJson, file);
	}

	@GetMapping
	public List<PublicationTitle> getPublicationTitlesByPublicationTypeId(@PathVariable("typeId") Long id) {
		return service.getPublicationTitlesByPublicationTypeId(id);
	}

	@DeleteMapping("/{id}")
	public void deletePublicationTitle(@PathVariable("id") Long id) {
		service.deletePublicationTitle(id);
	}

	private void saveOrUpdate(Long id, String publicationTitleJson, MultipartFile[] file) throws IOException {
		PublicationType publicationType = new PublicationType();
		publicationType.setId(id);
		PublicationTitle publicationTitle = convertToObject(publicationTitleJson);
		publicationTitle.setPublicationType(publicationType);
		service.saveOrUpdate(publicationTitle, file);
	}

	private PublicationTitle convertToObject(String publicationTitleString) throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		return objectMapper.readValue(publicationTitleString, PublicationTitle.class);
	}
}
