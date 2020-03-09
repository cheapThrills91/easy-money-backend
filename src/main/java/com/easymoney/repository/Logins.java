package com.easymoney.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.easymoney.model.Login;

public interface Logins extends JpaRepository<Login, Long> {
    Login findByUsuario(String usuario);
}
