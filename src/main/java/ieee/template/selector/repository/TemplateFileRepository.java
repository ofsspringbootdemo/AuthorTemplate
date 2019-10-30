package ieee.template.selector.repository;

import ieee.template.selector.model.TemplateFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TemplateFileRepository extends JpaRepository<TemplateFile, Long> {

    List<TemplateFile> getByPublicationTypeId(Long publicationTypeId);

    List<TemplateFile> getByPublicationTitleId(Long publicationTitleId);

    List<TemplateFile> getByArticleTypeId(Long articleTypeId);
}
