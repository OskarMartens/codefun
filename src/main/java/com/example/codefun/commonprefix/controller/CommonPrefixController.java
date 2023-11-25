package com.example.codefun.commonprefix.controller;

import com.example.codefun.commonprefix.service.CommonPrefixService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/commonprefix")
public class CommonPrefixController {

    private final CommonPrefixService commonPrefixService;

    @Autowired
    public CommonPrefixController(CommonPrefixService commonPrefixService) {
        this.commonPrefixService = commonPrefixService;
    }

    @PostMapping("")
    public ResponseEntity<String> findCommonPrefix(@RequestBody StringRequest stringRequest){
        return commonPrefixService.findCommonPrefix(stringRequest.getStrings());
    }
}
