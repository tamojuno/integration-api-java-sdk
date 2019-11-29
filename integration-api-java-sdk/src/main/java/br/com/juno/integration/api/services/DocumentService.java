package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_ENCODING_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;
import static br.com.juno.integration.api.utils.ResponseUtils.validateSuccess;

import java.security.PublicKey;
import java.util.List;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.model.Document;
import br.com.juno.integration.api.services.request.credentials.CredentialsRequest;
import br.com.juno.integration.api.services.request.document.DocumentGetRequest;
import br.com.juno.integration.api.services.request.document.DocumentListRequest;
import br.com.juno.integration.api.services.request.document.DocumentUploadEncryptedRequest;
import br.com.juno.integration.api.services.request.document.DocumentUploadRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.integration.api.utils.CryptoUtils;
import kong.unirest.ContentType;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class DocumentService extends BaseService {

    public Document getDocument(DocumentGetRequest request) {
        HttpResponse<Resource<Document>> response = Unirest.get(JunoApiManager.config().getEnvironmentUrl() + "/api-integration/documents/{id}") //
                .headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader()) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .routeParam("id", request.getDocumentId()) //
                .asObject(new GenericType<Resource<Document>>() { //
                    // NTD
                });//

        validateSuccess(response);

        return new Response<>(response.getBody()).getContent();

    }

    public List<Document> listDocument(DocumentListRequest request) {
        HttpResponse<Resources<Resource<Document>>> response = Unirest.get(JunoApiManager.config().getEnvironmentUrl() + "/api-integration/documents") //
                .headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader()) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .asObject(new GenericType<Resources<Resource<Document>>>() { //
                    // NTD
                });//

        validateSuccess(response);

        return new Responses<>(response.getBody()).getAbsoluteContent();

    }

    public Document uploadDocument(DocumentUploadRequest request) {

        HttpResponse<Resource<Document>> response = Unirest.post(
                JunoApiManager.config().getEnvironmentUrl() + "/api-integration/documents/{id}/files") //
                .headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader()) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .routeParam("id", request.getDocumentId()) //
                .multiPartContent() //
                .field("files", request.getFiles().get(0), ContentType.MULTIPART_FORM_DATA) //
                .asObject(new GenericType<Resource<Document>>() { //
                    // NTD
                });//

        validateSuccess(response);

        return new Response<>(response.getBody()).getContent();

    }

    public Document uploadDocumentAsEncripted(DocumentUploadEncryptedRequest request) {
        PublicKey publicKey = JunoApiManager //
                .getCredentialsService() //
                .getPublicCredentials(new CredentialsRequest(request.getResourceToken())) //
                .getPublicKey(); //

        byte[] encryptedFile = CryptoUtils.encryptFile(publicKey, request.getFileName(), request.getFile());

        HttpResponse<Resource<Document>> response = Unirest.post(
                JunoApiManager.config().getEnvironmentUrl() + "/api-integration/documents/{id}/files") //
                .headers(JunoApiManager.getAuthorizationService().getAuthorizationHeader()) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_ENCODING_HEADER, "gzip") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_OCTET_STREAM_VALUE) //
                .routeParam("id", request.getDocumentId()) //
                .body(encryptedFile) //
                .asObject(new GenericType<Resource<Document>>() { //
                    // NTD
                });//

        validateSuccess(response);

        return new Response<>(response.getBody()).getContent();
    }

}
