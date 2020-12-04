package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import org.springframework.hateoas.Resource;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.QRCode;
import br.com.juno.integration.api.model.QRCodeCancel;
import br.com.juno.integration.api.services.request.picpay.PicpayCancelRequest;
import br.com.juno.integration.api.services.request.picpay.PicpayCreateRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.utils.JacksonUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class PicpayService extends BaseService {

	private static final String CREATE_QRCODE_ENDPOINT = "/qrcode";
	private static final String CANCEL_QRCODE_ENDPOINT = CREATE_QRCODE_ENDPOINT + "/{id}/cancel";

	PicpayService() {
		// NTD
	}
	
	public QRCode createQRCode(PicpayCreateRequest request) {
		HttpResponse<Resource<QRCode>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + CREATE_QRCODE_ENDPOINT)
				.header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .body(JacksonUtils.toJson(request))//
                .asObject(new GenericType<Resource<QRCode>>() {
                    // NTD
                });
		
		return new Response<>(response.getBody()).getContent();
	}
	
	public QRCodeCancel cancelQRCode(PicpayCancelRequest request) {
		HttpResponse<Resource<QRCodeCancel>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + CANCEL_QRCODE_ENDPOINT)
				.header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<QRCodeCancel>>() {
                    // NTD
                });

        return new Response<>(response.getBody()).getContent();
				
	}

}
