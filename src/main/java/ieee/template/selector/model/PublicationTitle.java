package ieee.template.selector.model;

import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;

@Data
@Entity
@Table(name = "PUBLICATION_TITLE")
@JsonIgnoreProperties(value = { "articleTypes", "templateFiles", "auditInfo" }, allowSetters = true)
public class PublicationTitle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "ACRONYM")
	private String acronym;

	@Column(name = "DESCRIPTION")
	private String description;

	@Column(name = "STATUS")
	private String status;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "AUDIT_INFO_ID")
	private AuditInfo auditInfo;

	@ManyToOne
	@JsonBackReference
	private PublicationType publicationType;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PUBLICATION_TITLE_ID")
	@JsonManagedReference
	private List<ArticleType> articleTypes;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "PUBLICATION_TITLE_ID")
	@JsonManagedReference(value = "publication-title-template-files")
	private List<TemplateFile> templateFiles;

	public boolean isTemplatesAvailable() {
		return !this.templateFiles.isEmpty();
	}

	@Override
	public String toString() {
		return "Publication Title [id=" + id + ", name=" + name + "]";
	}

}