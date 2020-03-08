package com.easymoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easymoney.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

}
