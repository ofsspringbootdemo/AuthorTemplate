package ieee.template.selector.service;

import ieee.template.selector.model.ArticleType;
import ieee.template.selector.repository.ArticleTypeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleTypeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ArticleTypeService.class);

    @Autowired
    private ArticleTypeRepository repository;

    public void saveOrUpdate(ArticleType articleType, MultipartFile[] files) {
        repository.save(articleType);
        UploadDownloadService.fileUpload(files);
    }

    public Optional<ArticleType> getArticleTypesById(Long id) {
        return repository.findById(id);
    }

    public List<ArticleType> getAllArticleType() {
        return repository.findAll();
    }

    public void deleteArticleType(Long id) {
        repository.deleteById(id);
    }

    /**
     * Method to get Article Type Details using publication TitleId.
     *
     * @param id of PublicationTitleId
     * @return List of Article Type
     */
    public List<ArticleType> getArticleTypesByPublicationTitleId(Long id) {
        try {
            List<ArticleType> articleTypes = repository.getByPublicationTitleId(id);
            LOGGER.debug("List of Article Types for Publication Title Id={} : {}", id, articleTypes);
            return articleTypes;
        } catch (Exception e) {
            LOGGER.error("Error in fetching Article Types ", e);
        }
        return null;
    }
}
