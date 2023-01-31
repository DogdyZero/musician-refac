package br.com.musician.app.aplicacao;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.musician.app.aplicacao.interfaces.IEntidadeCommand;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {
    public Class<? extends IEntidadeCommand> value();
}
