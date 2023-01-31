package br.com.musician.app.aplicacao;

import br.com.musician.app.aplicacao.interfaces.AnnotationAdapter;

public class DaoAnnotationAdapter implements AnnotationAdapter{

	public Class<?> getAnnotation(Object object) {
		Dao annotation = object.getClass().getAnnotation(Dao.class);
		return annotation.value();
	}
}
