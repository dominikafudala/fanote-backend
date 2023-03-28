package com.example.favnote.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "card")
@Setter
@Getter
@RequiredArgsConstructor
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "created")
    private Date created;

}
