package com.example.favnote.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "card")
@Getter
@Setter
@NoArgsConstructor
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

    @Column(name = "created", nullable = false)
    private LocalDate created = LocalDate.now();

}
