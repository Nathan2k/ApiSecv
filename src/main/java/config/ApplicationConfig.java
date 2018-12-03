package config;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import servicos.UsuarioService;

public class ApplicationConfig extends Application {

	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> recursos = new HashSet<>();
		recursos.add(UsuarioService.class);
		return recursos;
	}

}
