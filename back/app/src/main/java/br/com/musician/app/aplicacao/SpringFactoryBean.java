package br.com.musician.app.aplicacao;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.musician.app.aplicacao.interfaces.AnnotationAdapter;

@Service
public class SpringFactoryBean {
	
	@Autowired
	private SpringContext springContext;
	private Map<Class<? extends Annotation>, AnnotationAdapter> mapaAnnotations = new HashMap<>();
	
	public SpringFactoryBean() {
		mapaAnnotations.put(Command.class, new CommandAnnotationAdapter());
		mapaAnnotations.put(Dao.class, new DaoAnnotationAdapter());
	}
	
	public Object getEntidade(Object object) {
		Class<? extends Annotation> annotation = null;
		for (Entry<Class<? extends Annotation>, AnnotationAdapter> entry : mapaAnnotations.entrySet()) {
			if(object.getClass().isAnnotationPresent(entry.getKey())) {
				annotation = entry.getKey();
				break;
			}
		}
		if(annotation == null)
			throw new IllegalArgumentException("Entidade não mapeada");
		
		AnnotationAdapter annotationFactory = mapaAnnotations.get(annotation);
		Class<?> clazz = annotationFactory.getAnnotation(object);
		Object bean = springContext.getContext().getBean(clazz);
		
		return bean;
	}
	
}
