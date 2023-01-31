package br.com.musician.app.cadastroUsuario.model;

import java.util.UUID;

import org.hibernate.annotations.UuidGenerator;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import br.com.musician.app.aplicacao.interfaces.IEntidade;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;

@Entity
@Component
@Inheritance(strategy = InheritanceType.JOINED)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({ @Type(value = Cartao.class, name = "cartao"), @Type(value = Cupom.class, name = "cupom") })
public abstract class TipoPagamento implements IEntidade {
	@Id
	@Column(name = "tpp_id")
	@UuidGenerator
	@GeneratedValue
	private UUID id;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

}
