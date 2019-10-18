package com.jana.jpademo.repository;

import com.jana.jpademo.model.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleTypeRepository extends JpaRepository<ArticleType, Long> {

    List<ArticleType> getByTemplateNameId(Long id);
}
