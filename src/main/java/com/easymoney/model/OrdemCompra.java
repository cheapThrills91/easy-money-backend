package com.easymoney.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import com.easymoney.model.type.StatusCompra;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.hibernate.annotations.GenericGenerator;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class OrdemCompra {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	
	@NotNull
	private double valorDesejado;
	
	@NotNull
	private double valorCompra;

	@NotNull
	private double quantidade;
	private Date dataCompra = new Date();
	private StatusCompra status;
	private Long loginId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getClienteId() {
		return loginId;
	}
	public void setClienteId(Long loginId) {
		this.loginId = loginId;
	}

	public double getValorDesejado() {
		return valorDesejado;
	}

	public void setValorDesejado(Double valorDesejado) {
		this.valorDesejado = valorDesejado;
	}

	public double getValorCompra() {
		return valorCompra;
	}

	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	public StatusCompra getStatus() {
		return status;
	}
	public void setStatus(StatusCompra status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrdemCompra other = (OrdemCompra) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
