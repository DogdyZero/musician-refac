package br.com.musician.app.aplicacao.interfaces;

public interface IEntidadeCommand<T extends IEntidade, Form extends IEntidadeForm> {

	T prepararParaSalvar(Form form, String id);

	void aposSalvar(T entidade);

	IEntidadeDto toDto(T entidade);
}
