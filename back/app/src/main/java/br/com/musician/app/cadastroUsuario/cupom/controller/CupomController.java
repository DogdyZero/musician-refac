package br.com.musician.app.cadastroUsuario.cupom.controller;

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
@RequestMapping("/cupons")
public class CupomController implements IControllerPadrao<CupomForm, CupomFiltro> {

	@Autowired
	private Facade facade;

	public ResponseEntity<IEntidadeDto> inserir(CupomForm form) {
		IEntidadeDto dto = facade.inserir(form);
		return responseCreated(dto);
	}

	public ResponseEntity<IEntidadeDto> atualizar(CupomForm form, String id) {
		IEntidadeDto dto = facade.alterar(form, id);
		return responseCreated(dto);
	}

	public ResponseEntity<?> pesquisar(CupomFiltro filtro, Pageable pageable) {
		Page<IEntidadeDto> resultado = facade.pesquisar(filtro, pageable);
		return ResponseEntity.ok(resultado);
	}

}