package br.com.rocha.dan.task.job.enums;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.MessageFormat;

public enum Endpoint {

	ORDER_SCREENINGS_PULL_UPDATE("/order-screenings/pull-update"),
	IAM_CLIENT_IDENTITIES("/client-identities/identify?clientId={0}");

	private String path;
	
	Endpoint(String path){
		this.path = path;
	}
	
	public URI getURI(String baseURI, Object... params) throws URISyntaxException {
		return new URI(baseURI + MessageFormat.format(path, params));
	}
}
