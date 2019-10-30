package ieee.template.selector.repository;

import ieee.template.selector.model.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleTypeRepository extends JpaRepository<ArticleType, Long> {

	List<ArticleType> getByPublicationTitleId(Long id);
}
