package com.jana.jpademo.model;

import javax.persistence.*;

/**
 * Created by Jana on 10/14/2019.
 */
@Entity
@Table(name = "FILE_DOWNLOAD")
public class FileDownload {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Long id;

	@Column(name = "FORMAT")
	private String format;

	@Column(name = "URL")
	private String url;

	@Column(name = "DESCRIPTIVE_TEXT")
	private String descriptiveText;

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
