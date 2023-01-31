package br.com.musician.app.cadastroUsuario.model;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;

import br.com.musician.app.aplicacao.Status;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@Component
public class Cupom extends TipoPagamento {

	@Id
	@Column(name = "cpm_id")
	@UuidGenerator
	@GeneratedValue
	private UUID id;

	@Column(name = "cpm_codigo")
	private String codigo;

	@Column(name = "cpm_origem_cupom")
	@Enumerated(EnumType.STRING)
	private OrigemCupom origemCupom;

	@Column(name = "cpm_valor")
	private double valor;

	@Enumerated(EnumType.STRING)
	@Column(name = "cpm_status")
	private Status status;

	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public OrigemCupom getOrigemCupom() {
		return origemCupom;
	}

	public void setOrigemCupom(OrigemCupom origemCupom) {
		this.origemCupom = origemCupom;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}
