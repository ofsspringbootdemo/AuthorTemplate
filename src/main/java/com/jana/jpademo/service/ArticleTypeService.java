package com.jana.jpademo.service;

import com.jana.jpademo.model.ArticleType;
import com.jana.jpademo.repository.ArticleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleTypeService {

    @Autowired
    private ArticleTypeRepository repository;

    public List<ArticleType> getArticleTypesByTemplateNameId(Long id) {
        return repository.getByTemplateNameId(id);
    }
}
