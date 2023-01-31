package br.com.musician.app.cadastroUsuario.cartao.controller;

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
@RequestMapping("/cartoes")
public class CartaoController implements IControllerPadrao<CartaoForm, CartaoFiltro> {

	@Autowired
	private Facade facade;

	public ResponseEntity<IEntidadeDto> inserir(CartaoForm form) {
		IEntidadeDto dto = facade.inserir(form);
		return responseCreated(dto);
	}

	public ResponseEntity<IEntidadeDto> atualizar(CartaoForm form, String id) {
		IEntidadeDto dto = facade.alterar(form, id);
		return responseCreated(dto);
	}

	public ResponseEntity<?> pesquisar(CartaoFiltro filtro, Pageable pageable) {
		Page<IEntidadeDto> resultado = facade.pesquisar(filtro, pageable);
		return ResponseEntity.ok(resultado);
	}

}