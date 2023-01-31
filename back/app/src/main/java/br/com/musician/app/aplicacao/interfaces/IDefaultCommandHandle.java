package br.com.musician.app.aplicacao.interfaces;

public interface IDefaultCommandHandle<Entidade extends IEntidade, Form extends IEntidadeForm>
		extends IAddCommandHandle<Entidade, Form>, IUpdateCommandHandle<Entidade, Form> {
	
	default Entidade addOrUpdate(Form form, String id) {
		if (id == null)
			return add(form);
		else
			return update(form, id);
	}

}
