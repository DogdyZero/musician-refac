package br.com.musician.app.aplicacao.interfaces;

public interface IUpdateCommandHandle <Entidade extends IEntidade, Form extends IEntidadeForm>{

	Entidade update(Form form, String id);
}
