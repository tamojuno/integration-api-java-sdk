package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.Transfer;
import br.com.juno.integration.api.services.request.transfer.TransferRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class TransferService extends BaseService {

	private static final String TRANSFER_ENDPOINT = "/transfers";
	
    TransferService() {
        // NTD
    }
    
    public Transfer createTransfer(TransferRequest request) {
    	
		HttpResponse<Resource<Transfer>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + TRANSFER_ENDPOINT)
        			.header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
        			.header(X_RESOURCE_TOKEN, request.getResourceToken()) //
        			.body(JacksonUtils.toJson(request)) //
        			.asObject(new GenericType<Resource<Transfer>>() {
        				// NTD
        			});
		
    	return new Response<>(response.getBody()).getContent();
    }
    
}
