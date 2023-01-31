package br.com.musician.app.cadastroUsuario.model;

import java.time.LocalDate;
import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;

import br.com.musician.app.aplicacao.interfaces.IEntidade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@Component
public class Pessoa implements IEntidade {

	@Id
	@UuidGenerator
	@Column(name = "pes_id")
	private UUID id;

	@Column(name = "pes_nome")
	private String nome;

	@Column(name = "pes_cpf")
	private String cpf;

	@Column(name = "pes_rg")
	private String rg;

	@Column(name = "pes_genero")
	private String genero;

	@Column(name = "pes_data_aniversario")
	private LocalDate dataAniversario;

	@Column(name = "pes_email")
	private String email;

	@OneToOne(mappedBy = "pessoa")
	private Usuario usuario;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(LocalDate dataAniversario) {
		this.dataAniversario = dataAniversario;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
