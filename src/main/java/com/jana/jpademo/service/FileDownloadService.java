package com.jana.jpademo.service;

import com.jana.jpademo.model.FileDownload;
import com.jana.jpademo.repository.FileDownloadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileDownloadService {

    @Autowired
    private FileDownloadRepository repository;

    public List<FileDownload> getFileDownloadsByTemplateTypeId(Long id) {
        return repository.getByTemplateTypeId(id);
    }

    public List<FileDownload> getFileDownloadsByTemplateNameId(Long id) {
        return repository.getByTemplateNameId(id);
    }

    public List<FileDownload> getFileDownloadsByArticleTypeId(Long id) {
        return repository.getByArticleTypeId(id);
    }
}
