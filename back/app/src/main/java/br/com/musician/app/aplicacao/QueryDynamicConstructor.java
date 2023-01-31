package br.com.musician.app.aplicacao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.domain.Specification;

public class QueryDynamicConstructor<T> {
	
	private List<Specification<T>> listaSpecs = new ArrayList<Specification<T>>();
	
	public void add(Specification<T> spec) {
		listaSpecs.add(spec);
	}
	
	public Specification<T> getAndSpecs() {
		Specification<T> finalQuery = null;
		for (Specification<T> specification : listaSpecs) {
			if (finalQuery == null)
				finalQuery = Specification.where(specification);
			else
				finalQuery = finalQuery.and(specification);
		}
		return finalQuery;
	}
	
	public Specification<T> getOrSpecs() {
		Specification<T> finalQuery = null;
		for (Specification<T> specification : listaSpecs) {
			if (finalQuery == null)
				finalQuery = Specification.where(specification);
			else
				finalQuery = finalQuery.or(specification);
		}
		return finalQuery;
	}
}
