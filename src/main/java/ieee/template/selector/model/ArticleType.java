package ieee.template.selector.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "ARTICLE_TYPE")
@JsonIgnoreProperties(value = {"templateFiles", "auditInfo"}, allowSetters = true)
public class ArticleType {

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

    @ManyToOne
    @JsonBackReference
    private PublicationTitle publicationTitle;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ARTICLE_TYPE_ID")
    @JsonManagedReference(value = "article-type-template-files")
    private List<TemplateFile> templateFiles;

    @Override
    public String toString() {
        return "Article Type [id=" + id + ", name=" + name + "]";
    }

}
