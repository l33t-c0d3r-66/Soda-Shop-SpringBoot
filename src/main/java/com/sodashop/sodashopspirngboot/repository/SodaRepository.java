package com.sodashop.sodashopspirngboot.repository;

import com.sodashop.sodashopspirngboot.entity.Soda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SodaRepository extends JpaRepository<Soda, Long> {

    @Query("Select s from Soda s where s.name like %?1%")
    public List<Soda> getSodaByFields(String name);
}
