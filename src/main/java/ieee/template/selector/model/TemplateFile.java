package ieee.template.selector.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "TEMPLATE_FILE")
@JsonIgnoreProperties(value = {"auditInfo"}, allowSetters = true)
public class TemplateFile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "FORMAT")
    private String format;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTIVE_TEXT")
    private String descriptiveText;

    @Column(name = "STATUS")
    private String status;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "AUDIT_INFO_ID")
    private AuditInfo auditInfo;

    @ManyToOne
    @JsonBackReference(value = "publication-type-template-files")
    private PublicationType publicationType;

    @ManyToOne
    @JsonBackReference(value = "publication-title-template-files")
    private PublicationTitle publicationTitle;

    @ManyToOne
    @JsonBackReference(value = "article-type-template-files")
    private ArticleType articleType;

    @Override
    public String toString() {
        return "Template File [id=" + id + ", format=" + format + ", name=" + name + "]";
    }

}
