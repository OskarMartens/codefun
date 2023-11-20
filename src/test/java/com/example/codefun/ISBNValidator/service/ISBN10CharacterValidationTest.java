package com.example.codefun.ISBNValidator.service;

import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class ISBN10CharacterValidationTest {

    ISBNService isbnService = new ISBNService();

    @Test
    public void confirm_10_characters_is_valid_ISBN_without_X() {

        String draculaISBN10 = "1503261387";
        ResponseEntity<String> methodResponse1 = isbnService.validateISBN(draculaISBN10);
        assertEquals(HttpStatus.OK, methodResponse1.getStatusCode());
        assertEquals("The provided string: " + draculaISBN10 + ", is a valid ISBN.", methodResponse1.getBody());

        String theHitchHikersGuideToTheGalaxyISBN10 = "0330508113";
        ResponseEntity<String> methodResponse2 = isbnService.validateISBN(theHitchHikersGuideToTheGalaxyISBN10);
        assertEquals(HttpStatus.OK, methodResponse2.getStatusCode());
        assertEquals("The provided string: " + theHitchHikersGuideToTheGalaxyISBN10 + ", is a valid ISBN.", methodResponse2.getBody());
    }

    @Test
    public void confirm_10_characters_is_NOT_valid_ISBN_without_X() {

        String nonFunctioningISBN1 = "1503261382";
        ResponseEntity<String> methodResponse1 = isbnService.validateISBN(nonFunctioningISBN1);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse1.getStatusCode());
        assertEquals("The provided string: " + nonFunctioningISBN1 + ", is not a valid ISBN.", methodResponse1.getBody());

        String nonFunctioningISBN2 = "0330508112";
        ResponseEntity<String> methodResponse2 = isbnService.validateISBN(nonFunctioningISBN2);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse2.getStatusCode());
        assertEquals("The provided string: " + nonFunctioningISBN2 + ", is not a valid ISBN.", methodResponse2.getBody());
    }

    @Test
    public void confirm_10_digits_is_valid_ISBN_with_uppercase_X(){

        String ISBNNumber = "043942089X";
        ResponseEntity <String> methodResponse = isbnService.validateISBN(ISBNNumber);
        assertEquals(HttpStatus.OK, methodResponse.getStatusCode());
        assertEquals("The provided string: " + ISBNNumber + ", is a valid ISBN.", methodResponse.getBody());
    }

    @Test
    public void confirm_10_digits_is_NOT_valid_ISBN_with_lowercase_x(){

        String ISBNNumber = "043942089x";
        ResponseEntity <String> methodResponse = isbnService.validateISBN(ISBNNumber);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse.getStatusCode());
        assertEquals("The provided string: " + ISBNNumber + ", does not consist of digits.", methodResponse.getBody());
    }

    @Test
    public void confirm_10_digits_is_NOT_valid_ISBN_with_uppercase_X(){

        String ISBNNumber = "043942087X";
        ResponseEntity <String> methodResponse = isbnService.validateISBN(ISBNNumber);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse.getStatusCode());
        assertEquals("The provided string: " + ISBNNumber + ", is not a valid ISBN.", methodResponse.getBody());
    }

    @Test
    public void confirm_10_non_digits_string_is_NOT_valid(){

        String ISBNExample = "abcdefghij";
        ResponseEntity<String> methodResponse =  isbnService.validateISBN(ISBNExample);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse.getStatusCode());
        assertEquals("The provided string: " + ISBNExample + ", does not consist of digits.", methodResponse.getBody());
    }

    @Test
    public void confirm_10_digits_is_NOT_valid_ISBN_with_Y_ending(){

        String ISBNNumber = "043942089Y";
        ResponseEntity <String> methodResponse = isbnService.validateISBN(ISBNNumber);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse.getStatusCode());
        assertEquals("The provided string: " + ISBNNumber + ", does not consist of digits.", methodResponse.getBody());
    }

    @Test
    public void confirm_10_digits_is_NOT_valid_ISBN_with_random_letters(){

        String ISBNNumber = "hej9T2089Y";
        ResponseEntity <String> methodResponse = isbnService.validateISBN(ISBNNumber);
        assertEquals(HttpStatus.BAD_REQUEST, methodResponse.getStatusCode());
        assertEquals("The provided string: " + ISBNNumber + ", does not consist of digits.", methodResponse.getBody());
    }

}