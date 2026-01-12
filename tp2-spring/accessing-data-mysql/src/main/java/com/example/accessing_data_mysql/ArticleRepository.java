package com.example.accessing_data_mysql;

import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Integer> {
}

