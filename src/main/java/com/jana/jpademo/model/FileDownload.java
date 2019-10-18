package com.jana.jpademo.model;

import javax.persistence.*;

/**
 * Created by Jana on 10/14/2019.
 */
@Entity
@Table(name = "FILE_DOWNLOAD")
public class FileDownload {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "FORMAT")
	private String format;

	@Column(name = "URL")
	private String url;

	@Column(name = "DESCRIPTIVE_TEXT")
	private String descriptiveText;

	@Column(name = "TEMPLATE_TYPE_ID")
	private long templateTypeID;

	@Column(name = "TEMPLATE_NAME_ID")
	private long templateNameID;

	@Column(name = "ARTICLE_TYPE_ID")
	private long articleTypeID;

	public long getTemplateTypeID() {
		return templateTypeID;
	}

	public void setTemplateTypeID(long templateTypeID) {
		this.templateTypeID = templateTypeID;
	}

	public long getTemplateNameID() {
		return templateNameID;
	}

	public void setTemplateNameID(long templateNameID) {
		this.templateNameID = templateNameID;
	}

	public long getArticleTypeID() {
		return articleTypeID;
	}

	public void setArticleTypeID(long articleTypeID) {
		this.articleTypeID = articleTypeID;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescriptiveText() {
		return descriptiveText;
	}

	public void setDescriptiveText(String descriptiveText) {
		this.descriptiveText = descriptiveText;
	}
}
