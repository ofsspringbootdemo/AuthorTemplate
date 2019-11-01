package ieee.template.selector.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "PUBLICATION_TYPE")
@JsonIgnoreProperties(value = {"publicationTitles", "templateFiles", "auditInfo"}, allowSetters = true)
public class PublicationType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "STATUS")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUDIT_INFO_ID")
    private AuditInfo auditInfo;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PUBLICATION_TYPE_ID")
    @JsonManagedReference(value = "publication-type-template-files")
    private List<TemplateFile> templateFiles;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "PUBLICATION_TYPE_ID")
    @JsonManagedReference
    private List<PublicationTitle> publicationTitles;

    public boolean isTemplatesAvailable() {
        return !this.templateFiles.isEmpty();
    }

    @Override
    public String toString() {
        return "Publication Type [id=" + id + ", name=" + name + "]";
    }

}
