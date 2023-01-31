package br.com.musician.app.aplicacao;

import br.com.musician.app.aplicacao.interfaces.AnnotationAdapter;

public class CommandAnnotationAdapter implements AnnotationAdapter{

	public Class<?> getAnnotation(Object object) {
		Command annotation = object.getClass().getAnnotation(Command.class);
		return annotation.value();
	}
}
