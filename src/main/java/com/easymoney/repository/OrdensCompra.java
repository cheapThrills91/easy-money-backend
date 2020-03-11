package com.easymoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import com.easymoney.model.OrdemCompra;

public interface OrdensCompra extends JpaRepository<OrdemCompra, Long> {
    List<OrdemCompra> findByLoginId(Long loginId);
}
