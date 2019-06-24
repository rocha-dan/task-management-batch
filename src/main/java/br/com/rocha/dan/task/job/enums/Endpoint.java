package br.com.rocha.dan.task.job.enums;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

public enum Endpoint {


	TESTE("/teste");

	private String path;
	
	Endpoint(String path){
		this.path = path;
	}
	
	public URI getURI(String baseURI, Object... params) throws URISyntaxException {
		return new URI(baseURI + MessageFormat.format(path, params));
	}
}
