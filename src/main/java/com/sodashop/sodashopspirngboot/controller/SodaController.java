package com.sodashop.sodashopspirngboot.controller;

import com.sodashop.sodashopspirngboot.entity.Soda;
import com.sodashop.sodashopspirngboot.service.SodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SodaController {

    @Autowired
    private SodaService sodaService;

    @GetMapping("/soda")
    public ResponseEntity<List<Soda>> getAllSoda() {
        try {
            List<Soda> sodaList = sodaService.getAllSodas();
            if (sodaList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(sodaList, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/soda/{id}")
    public ResponseEntity<Soda> getSodaById(@PathVariable("id")Long id) {
        Soda soda = sodaService.getSodaById(id);
        if(soda != null) {
            return new ResponseEntity<>(soda, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/soda")
    public ResponseEntity<Soda> saveSoda(@RequestBody Soda soda) {
        try {
            Soda savedSoda = sodaService.saveSoda(soda);
            return new ResponseEntity<>(savedSoda, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @DeleteMapping("/soda/{id}")
    public ResponseEntity<Soda> deleteSoda(@RequestBody Soda soda) {
        try{
            sodaService.deleteSoda(soda);
            return new ResponseEntity<>(soda, HttpStatus.GONE);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
