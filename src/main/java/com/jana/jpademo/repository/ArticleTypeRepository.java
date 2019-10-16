package com.jana.jpademo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jana.jpademo.model.ArticleType;

/**
 * Created by Jana on 10/14/2019.
 */
public interface ArticleTypeRepository extends JpaRepository<ArticleType, Long> {
}
