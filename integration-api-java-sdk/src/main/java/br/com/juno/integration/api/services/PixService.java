package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;
import static br.com.juno.integration.api.services.JunoApiManager.X_IDEMPOTENCY_KEY;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.PixRandomKeys;
import br.com.juno.integration.api.model.PixStaticQRCode;
import br.com.juno.integration.api.services.request.pix.PixCreateKeysRequest;
import br.com.juno.integration.api.services.request.pix.PixCreateStaticQrcodeRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class PixService extends BaseService {

	public static final String PIX_CREATE_KEYS_ENDPOINT = "/pix/keys";
	public static final String PIX_CREATE_STATIC_QRCODE_ENDPOINT = "/pix/qrcodes/static";
	
	PixService() {
		// NTD
	}
	
	public PixRandomKeys createRandomKeys(PixCreateKeysRequest request) {
		HttpResponse<Resource<PixRandomKeys>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + PIX_CREATE_KEYS_ENDPOINT) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .header(X_IDEMPOTENCY_KEY, request.getIdempotencyKey())
                .body(JacksonUtils.toJson(request)) //
                .asObject(new GenericType<Resource<PixRandomKeys>>() { //
                    //NTD
                }); //
		
        return new Response<>(response.getBody()).getContent();

	}
	
	
	public PixStaticQRCode createStaticQRCode(PixCreateStaticQrcodeRequest request) {
		HttpResponse<Resource<PixStaticQRCode>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + PIX_CREATE_STATIC_QRCODE_ENDPOINT) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken())//
                .header(X_IDEMPOTENCY_KEY, request.getIdempotencyKey())
                .body(JacksonUtils.toJson(request)) //
                .asObject(new GenericType<Resource<PixStaticQRCode>>() { //
                    //NTD
                }); //

        return new Response<>(response.getBody()).getContent();

	}
	
}
