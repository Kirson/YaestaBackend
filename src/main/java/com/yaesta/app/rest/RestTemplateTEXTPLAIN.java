package com.yaesta.app.rest;

import java.io.IOException;
import java.net.URI;

import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpRequest;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.Assert;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public class RestTemplateTEXTPLAIN extends RestTemplate{

	@Override
	  protected <T> T doExecute(URI url, HttpMethod method, RequestCallback requestCallback,
	        ResponseExtractor<T> responseExtractor) throws RestClientException {

	     logger.info( RestTemplateXML.class.getSuperclass().getSimpleName() + ".doExecute() is overridden");

	     Assert.notNull(url, "'url' must not be null");
	     Assert.notNull(method, "'method' must not be null");
	     ClientHttpResponse response = null;
	     try {
	        ClientHttpRequest request = createRequest(url, method);
	        if (requestCallback != null) {
	           requestCallback.doWithRequest(request);
	        }
	        response = request.execute();

	        // Set ContentType to XML
	        response.getHeaders().setContentType(MediaType.TEXT_PLAIN);

	        if (!getErrorHandler().hasError(response)) {
	           logResponseStatus(method, url, response);
	        }
	        else {
	           handleResponseError(method, url, response);
	        }
	        if (responseExtractor != null) {
	           return responseExtractor.extractData(response);
	        }
	        else {
	           return null;
	        }
	     }
	     catch (IOException ex) {
	        throw new ResourceAccessException("I/O error on " + method.name() +
	              " request for \"" + url + "\":" + ex.getMessage(), ex);
	     }
	     finally {
	        if (response != null) {
	           response.close();
	        }
	     }

	  }

	  private void logResponseStatus(HttpMethod method, URI url, ClientHttpResponse response) {
	     if (logger.isDebugEnabled()) {
	        try {
	           logger.debug(method.name() + " request for \"" + url + "\" resulted in " +
	                 response.getRawStatusCode() + " (" + response.getStatusText() + ")");
	        }
	        catch (IOException e) {
	           // ignore
	        }
	     }
	  }

	  private void handleResponseError(HttpMethod method, URI url, ClientHttpResponse response) throws IOException {
	     if (logger.isWarnEnabled()) {
	        try {
	           logger.warn(method.name() + " request for \"" + url + "\" resulted in " +
	                 response.getRawStatusCode() + " (" + response.getStatusText() + "); invoking error handler");
	        }
	        catch (IOException e) {
	           // ignore
	        }
	     }
	     getErrorHandler().handleError(response);
	  }
}
