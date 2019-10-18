package com.jana.jpademo.repository;

import com.jana.jpademo.model.FileDownload;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Jana on 10/14/2019.
 */
public interface FileDownloadRepository extends JpaRepository<FileDownload, Long> {

    List<FileDownload> getByTemplateTypeId(Long templateTypeId);

    List<FileDownload> getByTemplateNameId(Long templateNameId);

    List<FileDownload> getByArticleTypeId(Long articleTypeId);
}
