package com.laioffer.tinnews.model;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Article {
    public String author;
    public String content;
    public String description;
    public String publishedAt;
    public String title;

    @NonNull
    @PrimaryKey
    public String url;
    public String urlToImage;
    public boolean favorite;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Article)) return false;
        Article article = (Article) o;
        return favorite == article.favorite &&
                author.equals(article.author) &&
                content.equals(article.content) &&
                description.equals(article.description) &&
                publishedAt.equals(article.publishedAt) &&
                title.equals(article.title) &&
                url.equals(article.url) &&
                urlToImage.equals(article.urlToImage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, content, description, publishedAt, title, url, urlToImage, favorite);
    }

    @Override
    public String toString() {
        return "Article{" +
                "author='" + author + '\'' +
                ", content='" + content + '\'' +
                ", description='" + description + '\'' +
                ", publishedAt='" + publishedAt + '\'' +
                ", title='" + title + '\'' +
                ", url='" + url + '\'' +
                ", urlToImage='" + urlToImage + '\'' +
                ", favorite=" + favorite +
                '}';
    }
}



