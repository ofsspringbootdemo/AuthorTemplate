package com.jana.jpademo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jana.jpademo.model.FileDownload;

/**
 * Created by Jana on 10/14/2019.
 */
public interface FileDownloadRepository extends JpaRepository<FileDownload, Long> {

	List<String> findByTemplateTypeID(long templateTypeID);

	List<String> findByTemplateNameID(long templateNameID);

	List<String> findByArticleTypeID(long articleType);
}
