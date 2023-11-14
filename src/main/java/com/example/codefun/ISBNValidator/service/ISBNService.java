package com.example.codefun.ISBNValidator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ISBNService {

    private final ISBN10CharacterValidation isbn10CharacterValidation;
    private final ISBN13CharacterValidation isbn13CharacterValidation;

    @Autowired
    public ISBNService(ISBN10CharacterValidation isbn10CharacterValidation,
                       ISBN13CharacterValidation isbn13CharacterValidation) {
        this.isbn10CharacterValidation = isbn10CharacterValidation;
        this.isbn13CharacterValidation = isbn13CharacterValidation;
    }

    public ResponseEntity<String> validateISBN(String ISBNString) {

        if(ISBNString.length() == 10) {
            return isbn10CharacterValidation.validate10CharactersISBN(ISBNString);
        }

        else if(ISBNString.length() == 13) {
            return isbn13CharacterValidation.validate13CharactersISBN(ISBNString);
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The string: " + ISBNString + " is not valid as it is not 10 nor 13 characters long.");
    }
}
