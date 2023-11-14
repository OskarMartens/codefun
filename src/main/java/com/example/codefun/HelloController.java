package com.example.codefun;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class HelloController {

    @GetMapping("hello")
    public ResponseEntity<String> helloWorld(){
        return new ResponseEntity<>("Hello World", HttpStatus.OK);
    }

    @GetMapping("morning")
    public ResponseEntity<String> goodMorning(){
        return new ResponseEntity<>("Good Morning World", HttpStatus.OK);
    }
}
