package com.example.codefun.commonprefix;

import com.example.codefun.commonprefix.service.CommonPrefixService;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

class CommonPrefixServiceTest {

    CommonPrefixService commonPrefixService = new CommonPrefixService();

    @Test
    public void findCommonPrefixTest(){

        String[] strings = new String[]{"Hallå", "Halsont", "Halland", "Halstra", "Halm"};

        ResponseEntity<String> commonPrefix = commonPrefixService.findCommonPrefix(strings);

        assertEquals("Hal", commonPrefix.getBody());
    }

}