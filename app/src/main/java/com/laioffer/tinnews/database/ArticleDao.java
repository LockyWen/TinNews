package com.laioffer.tinnews.database;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.laioffer.tinnews.model.Article;

import java.util.List;

public interface ArticleDao {
    @Insert
    void saveArticle(Article article);

    @Query("select * from article")
    LiveData<List<Article>> getAllArticles();

    @Delete
    void deleteArticles(Article article);
}
