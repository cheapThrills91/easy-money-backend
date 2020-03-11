package com.easymoney.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easymoney.model.Login;
import com.easymoney.repository.Logins;

@RestController
@CrossOrigin
@RequestMapping("/logins")
public class LoginResource {
	
	@Autowired
	private Logins logins;
	
	@PostMapping
	public Login adicionar(@Valid @RequestBody Login login) {
		return logins.save(login);
	}
	
	@GetMapping
	public List<Login> listar() {
		return logins.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Login> buscar(@PathVariable Long id) {
		Login login = logins.getOne(id);
		
		if (login == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(login);
	}

	@GetMapping("/{usuario}/{senha}")
	public ResponseEntity<Login> validar(@PathVariable String usuario, @PathVariable String senha) {
		Login login = logins.findByUsuario(usuario);
		
		if (login == null) {
			return ResponseEntity.notFound().build();
		}

		String checkSenha = login.getSenha();
		if (!checkSenha.equals(senha))
		{
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(login);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Login> atualizar(@PathVariable Long id, 
			@Valid @RequestBody Login login) {
		Login existente = logins.getOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(login, existente, "id");
		
		existente = logins.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		Login login = logins.getOne(id);
		
		if (login == null) {
			return ResponseEntity.notFound().build();
		}
		
		logins.delete(login);
		
		return ResponseEntity.noContent().build();
	}
}