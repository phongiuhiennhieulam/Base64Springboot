package com.example.base64.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Base64;

@RestController
@RequestMapping("base64")
public class Base64Implement {
    @GetMapping("decode")
    public String decode(@RequestParam String input) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(input);
            return new String(decodedBytes);
        }catch (Exception e){
            return e.getMessage();
        }

    }
    @GetMapping("encode")
    public String encode(@RequestParam String input) {
        try {
            return Base64.getEncoder().encodeToString(input.getBytes());
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
