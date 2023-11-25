package com.example.codefun.commonprefix.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class CommonPrefixService {

    public ResponseEntity<String> findCommonPrefix(String[] words){

        StringBuilder commonPrefix = new StringBuilder();
        Arrays.sort(words);
        String firstWord = words[0];
        String lastWord = words[words.length -1];

        for (int i = 0; i < Math.min(firstWord.length(), lastWord.length()); i++) {
            if(firstWord.charAt(i) != lastWord.charAt(i)){
                return ResponseEntity.status(HttpStatus.OK).body(commonPrefix.toString());
            }
            commonPrefix.append(firstWord.charAt(i));
        }

        return ResponseEntity.status(HttpStatus.OK).body(commonPrefix.toString());
    }
}
