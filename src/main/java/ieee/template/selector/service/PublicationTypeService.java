package ieee.template.selector.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import ieee.template.selector.model.PublicationType;
import ieee.template.selector.repository.PublicationTypeRepository;

@Service
public class PublicationTypeService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PublicationTypeService.class);

	@Autowired
	private PublicationTypeRepository repository;

	public void saveOrUpdate(PublicationType publicationType, MultipartFile[] files) {
		repository.save(publicationType);
		UploadDownloadService.fileUpload(files);
	}

	public Optional<PublicationType> getPublicationTypeById(Long id) {
		return repository.findById(id);
	}

	public List<PublicationType> getAllPublicationType() {

		try {
			List<PublicationType> publicationTypes = repository.findAll();
			LOGGER.debug("List of Publication Types: {}", publicationTypes);
			return publicationTypes;
		} catch(Exception e) {
			LOGGER.error("Error in fetching Publication Types ", e);
		}
		return null;
	}

	public void deletePublicationType(Long id) {
		repository.deleteById(id);
	}

}
