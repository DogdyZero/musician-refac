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
public class Cartao extends TipoPagamento {

	@Id
	@UuidGenerator
	@GeneratedValue
	@Column(name = "car_id")
	private UUID id;

	@Column(name = "car_nome_cartao")
	private String nomeCartao;

	@Column(name = "car_numero_cartao")
	private String numeroCartao;

	@Column(name = "car_validade")
	private String validade;

	@Column(name = "car_cod_seguranca")
	private int codSeguranca;

	@Column(name = "car_bandeira")
	@Enumerated(EnumType.STRING)
	private Bandeira bandeira;

	@Column(name = "car_preferencial")
	private boolean preferencial;

	@Enumerated(EnumType.STRING)
	@Column(name = "car_status")
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

	public String getNomeCartao() {
		return nomeCartao;
	}

	public void setNomeCartao(String nomeCartao) {
		this.nomeCartao = nomeCartao;
	}

	public String getNumeroCartao() {
		return numeroCartao;
	}

	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}

	public int getCodSeguranca() {
		return codSeguranca;
	}

	public void setCodSeguranca(int codSeguranca) {
		this.codSeguranca = codSeguranca;
	}

	public Bandeira getBandeira() {
		return bandeira;
	}

	public void setBandeira(Bandeira bandeira) {
		this.bandeira = bandeira;
	}

	public boolean isPreferencial() {
		return preferencial;
	}

	public void setPreferencial(boolean preferencial) {
		this.preferencial = preferencial;
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
