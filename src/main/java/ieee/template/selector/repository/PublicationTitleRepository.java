package ieee.template.selector.repository;

import ieee.template.selector.model.PublicationTitle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PublicationTitleRepository extends JpaRepository<PublicationTitle, Long> {

	List<PublicationTitle> getByPublicationTypeId(Long id);
}
