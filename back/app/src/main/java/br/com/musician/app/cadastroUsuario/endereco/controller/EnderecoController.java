package br.com.musician.app.cadastroUsuario.endereco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.musician.app.aplicacao.Facade;
import br.com.musician.app.aplicacao.interfaces.IControllerPadrao;
import br.com.musician.app.aplicacao.interfaces.IEntidadeDto;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController implements IControllerPadrao<EnderecoForm, EnderecoFiltro> {

	@Autowired
	private Facade facade;

	public ResponseEntity<IEntidadeDto> inserir(EnderecoForm form) {
		IEntidadeDto dto = facade.inserir(form);
		return responseCreated(dto);
	}

	public ResponseEntity<IEntidadeDto> atualizar(EnderecoForm form, String id) {
		IEntidadeDto dto = facade.alterar(form, id);
		return responseCreated(dto);
	}

	public ResponseEntity<?> pesquisar(EnderecoFiltro filtro, Pageable pageable) {
		Page<IEntidadeDto> resultado = facade.pesquisar(filtro, pageable);
		return ResponseEntity.ok(resultado);
	}

}