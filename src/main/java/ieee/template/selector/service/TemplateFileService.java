package ieee.template.selector.service;

import ieee.template.selector.model.TemplateFile;
import ieee.template.selector.repository.TemplateFileRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class TemplateFileService {

    private static final Logger LOGGER = LoggerFactory.getLogger(TemplateFileService.class);

    @Autowired
    private TemplateFileRepository repository;

    public void saveOrUpdate(TemplateFile fileDownload, MultipartFile[] file) {
        repository.save(fileDownload);
        UploadDownloadService.fileUpload(file);
    }

    public Optional<TemplateFile> getTemplateFileById(Long id) {
        return repository.findById(id);
    }

    public List<TemplateFile> getAllTemplateFile() {
        return repository.findAll();
    }

    public void deleteTemplateFile(Long id) {
        repository.deleteById(id);
    }

    /**
     * Method to get TemplateFile Details using publicationTypeId.
     *
     * @param id of PublicationType
     * @return List of TemplateFile
     */
    public List<TemplateFile> getTemplateFilesByPublicationTypeId(Long id) {

        try {
            List<TemplateFile> templateFiles = repository.getByPublicationTypeId(id);
            LOGGER.debug("List of Template Files for Publication Type Id={} : {}", id, templateFiles);
            return templateFiles;
        } catch (Exception e) {
            LOGGER.error("Error in fetching Template files ", e);
        }
        return null;
    }

    /**
     * Method to get TemplateFile Details using publicationTitleId.
     *
     * @param id of publicationTitleId
     * @return List of TemplateFile
     */
    public List<TemplateFile> getTemplateFilesByPublicationTitleId(Long id) {

        try {
            List<TemplateFile> templateFiles = repository.getByPublicationTitleId(id);
            LOGGER.debug("List of Template Files for Publication Title Id={} : {}", id, templateFiles);
            return templateFiles;
        } catch (Exception e) {
            LOGGER.error("Error in fetching Template files ", e);
        }
        return null;
    }

    /**
     * Method to get TemplateFile Details using ArticleTypeId.
     *
     * @param id of ArticleTypeId
     * @return List of TemplateFile
     */
    public List<TemplateFile> getTemplateFilesByArticleTypeId(Long id) {

        try {
            List<TemplateFile> templateFiles = repository.getByArticleTypeId(id);
            LOGGER.debug("List of Template Files for Article Type Id={} : {}", id, templateFiles);
            return templateFiles;
        } catch (Exception e) {
            LOGGER.error("Error in fetching Template files ", e);
        }
        return null;
    }
}
