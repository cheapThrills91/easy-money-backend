package com.easymoney.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easymoney.model.OrdemCompra;
import com.easymoney.repository.OrdensCompra;

@RestController
@RequestMapping("/ordemcompra")
public class OrdemCompraResource {
	
	@Autowired
	private OrdensCompra ordensCompra;
	
	@PostMapping
	public OrdemCompra adicionar(@Valid @RequestBody OrdemCompra ordemCompra) {
		return ordensCompra.save(ordemCompra);
	}
	
	@GetMapping
	public List<OrdemCompra> listar() {
		return ordensCompra.findAll();
	}
	
	@GetMapping("login/{id}")
	public List<OrdemCompra> listarOrdemLogin(@PathVariable Long id) {
		return ordensCompra.findByLoginId(id);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdemCompra> buscar(@PathVariable Long id) {
		OrdemCompra ordemCompra = ordensCompra.getOne(id);
		
		if (ordemCompra == null) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(ordemCompra);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<OrdemCompra> atualizar(@PathVariable Long id, 
			@Valid @RequestBody OrdemCompra ordemCompra) {
		OrdemCompra existente = ordensCompra.getOne(id);
		
		if (existente == null) {
			return ResponseEntity.notFound().build();
		}
		
		BeanUtils.copyProperties(ordemCompra, existente, "id");
		
		existente = ordensCompra.save(existente);
		
		return ResponseEntity.ok(existente);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		OrdemCompra ordemCompra = ordensCompra.getOne(id);
		
		if (ordemCompra == null) {
			return ResponseEntity.notFound().build();
		}
		
		ordensCompra.delete(ordemCompra);
		
		return ResponseEntity.noContent().build();
	}
}