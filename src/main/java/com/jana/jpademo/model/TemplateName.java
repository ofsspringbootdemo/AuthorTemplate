package com.jana.jpademo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Jana on 10/15/2019.
 */
@Entity
@Table(name = "TEMPLATE_NAME")
@JsonIgnoreProperties(value = { "articleTypeList", "fileDownloadList" }, allowSetters = true)
public class TemplateName {

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

	@Column(name = "CREATED_BY")
	private String createdBy;

	@Column(name = "CREATED_DATE")
	private Date createdDate;

	@Column(name = "MODIFIED_BY")
	private String modifiedBy;

	@Column(name = "MODIFIED_DATE")
	private Date modifiedDate;

	@ManyToOne
	@JsonBackReference
	private TemplateType templateType;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "TEMPLATE_NAME_ID")
	@JsonManagedReference
	private List<ArticleType> articleTypeList;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "TEMPLATE_NAME_ID")
	@JsonManagedReference(value = "template-name-file-downloads")
	private List<FileDownload> fileDownloadList;

	public List<ArticleType> getArticleTypeList() {
		return articleTypeList;
	}

	public void setArticleTypeList(List<ArticleType> articleTypeList) {
		this.articleTypeList = articleTypeList;
	}

	public TemplateType getTemplateType() {
		return templateType;
	}

	public void setTemplateType(TemplateType templateType) {
		this.templateType = templateType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAcronym() {
		return acronym;
	}

	public void setAcronym(String acronym) {
		this.acronym = acronym;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public List<FileDownload> getFileDownloadList() {
		return fileDownloadList;
	}

	public void setFileDownloadList(List<FileDownload> fileDownloadList) {
		this.fileDownloadList = fileDownloadList;
	}
}
