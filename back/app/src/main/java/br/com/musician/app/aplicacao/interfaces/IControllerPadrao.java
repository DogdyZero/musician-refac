package br.com.musician.app.aplicacao.interfaces;

import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import jakarta.validation.Valid;

public interface IControllerPadrao<Form extends IEntidadeForm, Filtro extends IEntidadeFiltro<?>> {
	default ResponseEntity<IEntidadeDto> responseCreated(IEntidadeDto dto) {
		return ResponseEntity.status(HttpStatus.CREATED).body(dto);
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<IEntidadeDto> inserir(@Valid @RequestBody Form form);

	@PutMapping(path = "{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<IEntidadeDto> atualizar(@Valid @RequestBody Form form, @PathVariable String id);

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	ResponseEntity<?> pesquisar(Filtro filtro, Pageable pageable);
}
