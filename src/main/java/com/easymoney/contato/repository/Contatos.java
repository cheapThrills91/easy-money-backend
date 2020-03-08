package com.easymoney.contato.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easymoney.contato.model.Contato;

public interface Contatos extends JpaRepository<Contato, Long> {

}
