package com.example.favnote.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class CardModel {
    private String title;
    private String content;
    private String type;
    private String twitterName;
    private String articleUrl;
}
