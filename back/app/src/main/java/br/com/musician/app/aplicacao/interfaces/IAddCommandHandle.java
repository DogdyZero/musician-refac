package br.com.musician.app.aplicacao.interfaces;

public interface IAddCommandHandle <Entidade extends IEntidade, Form extends IEntidadeForm>{

	Entidade add(Form form);
}
