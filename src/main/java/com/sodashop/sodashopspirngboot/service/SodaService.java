package com.sodashop.sodashopspirngboot.service;

import com.sodashop.sodashopspirngboot.entity.Soda;
import com.sodashop.sodashopspirngboot.repository.SodaRepository;

import java.util.List;
import java.util.Optional;

public class SodaService {
    private SodaRepository sodaRepository;

    public List<Soda> getAllSodas() {
        return sodaRepository.findAll();
    }

    public Soda getSodaById(Long id) {
        Optional<Soda> soda = sodaRepository.findById(id);
        if(soda.isPresent()) {
            return soda.get();
        }
        return null;
    }

    public Soda saveSoda(Soda soda) {
        return sodaRepository.save(soda);
    }

    public void deleteSoda(Soda soda) {
        sodaRepository.delete(soda);
    }
}
