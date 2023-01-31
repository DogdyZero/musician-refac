package br.com.musician.app.aplicacao.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface JpaGenericRepository<T extends IEntidade> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

}
