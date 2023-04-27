package com.example.favnote.service;

import com.example.favnote.entity.Card;
import com.example.favnote.model.CardModel;
import com.example.favnote.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;

    public Card addNewCard(CardModel cardModel){
        Card newCard = new Card();

        newCard.setTitle(cardModel.getTitle());
        newCard.setContent(cardModel.getContent());
        newCard.setType(cardModel.getType());
        newCard.setTwitterName(cardModel.getTwitterName());
        newCard.setArticleUrl(cardModel.getArticleUrl());

        cardRepository.save(newCard);

        return newCard;    }
}
