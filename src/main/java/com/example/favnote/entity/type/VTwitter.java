package com.example.favnote.entity.type;

import jakarta.persistence.*;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

/**
 * Mapping for DB view
 */
@Entity
@Immutable
@Table(name = "v_twitters")
public class VTwitter {
    @Id
    @Column(name = "card_id", nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 250)
    private String title;

    @Lob
    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "type", nullable = false, length = 20)
    private String type;

    @Column(name = "twitter_name", length = 100)
    private String twitterName;

    @Column(name = "article_url", length = 2083)
    private String articleUrl;

    @Column(name = "created", nullable = false)
    private LocalDate created;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public String getTwitterName() {
        return twitterName;
    }

    public String getArticleUrl() {
        return articleUrl;
    }

    public LocalDate getCreated() {
        return created;
    }

    protected VTwitter() {
    }
}
