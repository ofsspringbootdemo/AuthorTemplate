package ieee.template.selector.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ieee.template.selector.model.PublicationTitle;
import ieee.template.selector.repository.PublicationTitleRepository;

@Service
public class PublicationTitleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublicationTitleService.class);

	@Autowired
	private PublicationTitleRepository repository;

	public void saveOrUpdate(PublicationTitle publicationTitle, MultipartFile[] files) {
		repository.save(publicationTitle);
		UploadDownloadService.fileUpload(files);
	}

	public Optional<PublicationTitle> getPublicationTitleById(Long id) {
		return repository.findById(id);
	}

	public List<PublicationTitle> getAllPublicationTitle() {
		return repository.findAll();
	}

	public void deletePublicationTitle(Long id) {
		repository.deleteById(id);
	}

	public List<PublicationTitle> getPublicationTitlesByPublicationTypeId(Long id) {

		try {
			List<PublicationTitle> publicationTitles = repository.getByPublicationTypeId(id);
			LOGGER.debug("List of Publication Titles for Publication Type Id={} : {}", id, publicationTitles);
			return publicationTitles;
		} catch(Exception e) {
			LOGGER.error("Error in fetching Publication titles ", e);
		}
		return null;
	}
}
