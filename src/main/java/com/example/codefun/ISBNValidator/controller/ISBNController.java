package com.example.codefun.ISBNValidator.controller;

import com.example.codefun.ISBNValidator.service.ISBNService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ISBN/")
public class ISBNController {

    private final ISBNService isbnService;

    @Autowired
    public ISBNController(ISBNService isbnService) {
        this.isbnService = isbnService;
    }

    @PostMapping("{ISBNString}")
    public ResponseEntity<String> validateISBN(@PathVariable ("ISBNString") String isbnString){
        return isbnService.validateISBN(isbnString);
    }
}
