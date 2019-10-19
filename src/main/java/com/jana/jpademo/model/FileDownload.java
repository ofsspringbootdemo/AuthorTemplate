package com.jana.jpademo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne
    @JsonBackReference(value="template-type-file-downloads")
    private TemplateType templateType;

    @ManyToOne
    @JsonBackReference(value="template-name-file-downloads")
    private TemplateName templateName;

    @ManyToOne
    @JsonBackReference(value="article-type-file-downloads")
    private ArticleType articleType;

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

    public TemplateType getTemplateType() {
        return templateType;
    }

    public void setTemplateType(TemplateType templateType) {
        this.templateType = templateType;
    }

    public TemplateName getTemplateName() {
        return templateName;
    }

    public void setTemplateName(TemplateName templateName) {
        this.templateName = templateName;
    }

    public ArticleType getArticleType() {
        return articleType;
    }

    public void setArticleType(ArticleType articleType) {
        this.articleType = articleType;
    }
}
