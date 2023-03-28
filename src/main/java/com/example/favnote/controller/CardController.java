package com.example.favnote.controller;

import com.example.favnote.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping( "/card")
public class CardController {
    private final CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCards() {
        return ResponseEntity.ok(cardRepository.findAll());
    }

    @GetMapping(value = "/all", params = {"type"})
    public ResponseEntity<?> getAllCardsByType(@RequestParam(name = "type") String type) {
        return ResponseEntity.ok(cardRepository.findAllByType(type));
    }
}
