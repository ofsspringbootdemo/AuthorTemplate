package com.jana.jpademo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * Created by Jana on 10/14/2019.
 */
@Entity
@Table(name = "TEMPLATE_TYPE")
public class TemplateType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "templateTypeSeqGenerator")
    @SequenceGenerator(name="templateTypeSeqGenerator", sequenceName = "TEMPLATE_TYPE_SEQ", allocationSize=1)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "TEMPLATE_TYPE_ID")
    private List<FileDownload> fileDownloadList;

    @OneToMany(cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<TemplateName> templateNameList;

    public List<TemplateName> getTemplateNameList() {
        return templateNameList;
    }

    public void setTemplateNameList(List<TemplateName> templateNameList) {
        this.templateNameList = templateNameList;
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
