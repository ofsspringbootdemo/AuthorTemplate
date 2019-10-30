package ieee.template.selector.repository;

import ieee.template.selector.model.PublicationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationTypeRepository extends JpaRepository<PublicationType, Long> {
}
