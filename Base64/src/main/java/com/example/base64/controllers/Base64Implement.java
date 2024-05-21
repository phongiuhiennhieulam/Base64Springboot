package com.example.base64.controllers;

import com.example.base64.models.StringInput;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;
import java.util.Objects;

@RestController
@RequestMapping("base64")
public class Base64Implement {
    @PostMapping(value = "/decode", produces = "application/json", consumes="application/json")
    public String decode(@RequestBody StringInput input) {
        try {
            byte[] decodedBytes = Base64.getDecoder().decode(input.getInput());
            return new String(decodedBytes);
        }catch (Exception e){
            return e.getMessage();
        }

    }
    @PostMapping(value = "/encode", produces = "application/json", consumes="application/json")
    public String encode(@RequestBody StringInput input) {
        try {
            return Base64.getEncoder().encodeToString(input.getInput().getBytes());
        }catch (Exception e){
            return e.getMessage();
        }

    }
}
