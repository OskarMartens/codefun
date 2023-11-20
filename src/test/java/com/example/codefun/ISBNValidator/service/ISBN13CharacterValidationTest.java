package com.example.codefun.ISBNValidator.service;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ISBN13CharacterValidationTest {

    ISBNService isbnService = new ISBNService();

    @Test
    public void confirm_13_non_digits_string_is_NOT_valid(){
        String ISBNExample = "abcdefghijklm";
        ResponseEntity<String> methodResponse = isbnService.validateISBN(ISBNExample);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse.getStatusCode());
        assertEquals("The provided string: " + ISBNExample + ", does not consist of digits.", methodResponse.getBody());
    }

    @Test
    public void confirm_13_digits_is_valid(){
        String mobyDickISBN = "9781503280786";
        ResponseEntity<String> methodResponse1 = isbnService.validateISBN(mobyDickISBN);
        assertEquals(HttpStatus.OK, methodResponse1.getStatusCode());
        assertEquals("The provided string: " + mobyDickISBN + " is a valid ISBN.", methodResponse1.getBody());

        String cityOfMyDreamsISBN = "9781572160880";
        ResponseEntity<String> methodResponse2 = isbnService.validateISBN(cityOfMyDreamsISBN);
        assertEquals(HttpStatus.OK, methodResponse2.getStatusCode());
        assertEquals("The provided string: " + cityOfMyDreamsISBN + " is a valid ISBN.", methodResponse2.getBody());
    }

    @Test
    public void confirm_13_digits_is_NOT_valid(){
        String ISBNExample1 = "9781503280785";
        ResponseEntity<String> methodResponse1 = isbnService.validateISBN(ISBNExample1);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse1.getStatusCode());
        assertEquals("The provided string: " + ISBNExample1 + " is not a valid ISBN.", methodResponse1.getBody());

        String ISBNExample2 = "9781572160879";
        ResponseEntity<String> methodResponse2 = isbnService.validateISBN(ISBNExample2);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse2.getStatusCode());
        assertEquals("The provided string: " + ISBNExample2 + " is not a valid ISBN.", methodResponse2.getBody());
    }

}