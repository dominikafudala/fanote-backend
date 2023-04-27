package com.example.favnote.controller;

import com.example.favnote.model.CardModel;
import com.example.favnote.repository.CardRepository;
import com.example.favnote.repository.type.VArticleRepository;
import com.example.favnote.repository.type.VNoteRepository;
import com.example.favnote.repository.type.VTwitterRepository;
import com.example.favnote.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping( "/card")
public class CardController {
    private final CardRepository cardRepository;
    private final VArticleRepository vArticleRepository;
    private final VTwitterRepository vTwitterRepository;
    private final VNoteRepository vNoteRepository;

    private final CardService cardService;

    @Autowired
    public CardController(CardRepository cardRepository, VArticleRepository vArticleRepository, VTwitterRepository vTwitterRepository, VNoteRepository vNoteRepository, CardService cardService) {
        this.cardRepository = cardRepository;
        this.vArticleRepository = vArticleRepository;
        this.vTwitterRepository = vTwitterRepository;
        this.vNoteRepository = vNoteRepository;
        this.cardService = cardService;
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllCards() {
        return ResponseEntity.ok(cardRepository.findAll());
    }

    @GetMapping(value = "/all", params = {"type"})
    public ResponseEntity<?> getAllCardsByType(@RequestParam(name = "type") String type) {
        switch (type){
            case "article":
                return ResponseEntity.ok(vArticleRepository.findAll());
            case "note":
                return ResponseEntity.ok(vNoteRepository.findAll());
            case "twitter":
                return ResponseEntity.ok(vTwitterRepository.findAll());
        }
        return (ResponseEntity<?>) ResponseEntity.status(400);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCardById(@PathVariable Integer id){
        return ResponseEntity.ok(cardRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCardFromId(@PathVariable Integer id){
        cardRepository.deleteById(id);
        return ResponseEntity.ok("Deleted card " + id);
    }

    @PostMapping("/newitem")
    public ResponseEntity<?> addNewItem(@RequestBody CardModel cardModel) {
        return ResponseEntity.ok(cardService.addNewCard(cardModel));
    }

}
