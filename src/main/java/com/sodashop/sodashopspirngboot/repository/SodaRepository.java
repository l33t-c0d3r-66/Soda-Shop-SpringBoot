package com.sodashop.sodashopspirngboot.repository;

import com.sodashop.sodashopspirngboot.entity.Soda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SodaRepository extends JpaRepository<Soda, Long> {
}
