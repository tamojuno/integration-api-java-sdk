package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_ENCODING_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.PublicKey;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.model.Document;
import br.com.juno.integration.api.services.request.credentials.CredentialsRequest;
import br.com.juno.integration.api.services.request.document.AbstractDocumentRequest.JunoFile;
import br.com.juno.integration.api.services.request.document.DocumentGetRequest;
import br.com.juno.integration.api.services.request.document.DocumentListRequest;
import br.com.juno.integration.api.services.request.document.DocumentUploadEncryptedRequest;
import br.com.juno.integration.api.services.request.document.DocumentUploadRequest;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.integration.api.services.response.Responses;
import br.com.juno.integration.api.utils.CryptoUtils;
import kong.unirest.GenericType;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class DocumentService extends BaseService {

    private static final String DOCUMENTS_ENDPOINT = "/documents";
    private static final String DOCUMENTS_TEMPLATED_ENDPOINT = DOCUMENTS_ENDPOINT + "/{id}";
    private static final String DOCUMENTS_UPLOAD_ENDPOINT = DOCUMENTS_TEMPLATED_ENDPOINT + "/files";

    DocumentService() {
        // NTD
    }

    public Document getDocument(DocumentGetRequest request) {
        HttpResponse<Resource<Document>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + DOCUMENTS_TEMPLATED_ENDPOINT) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .routeParam("id", request.getId()) //
                .asObject(new GenericType<Resource<Document>>() { //
                    // NTD
                });//

        return new Response<>(response.getBody()).getContent();

    }

    public List<Document> listDocument(DocumentListRequest request) {
        HttpResponse<Resources<Resource<Document>>> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + DOCUMENTS_ENDPOINT) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_JSON_VALUE) //
                .asObject(new GenericType<Resources<Resource<Document>>>() { //
                    // NTD
                });//

        return new Responses<>(response.getBody()).getAbsoluteContent();

    }

    public Document uploadDocument(DocumentUploadRequest request) {
        Document document = null;
        for (JunoFile file : request.getFiles()) {
            if (file.hasFile()) {
                document = uploadFile(request.getResourceToken(), request.getId(), file.getFile());
            }
            if (file.hasStream()) {
                document = uploadStream(request.getResourceToken(), request.getId(), file.getStream(), file.getFileName());
            }
        }
        return document;
    }

    private Document uploadFile(String resourceToken, String documentId, File file) {
        HttpResponse<Resource<Document>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + DOCUMENTS_UPLOAD_ENDPOINT) //
                .header(X_RESOURCE_TOKEN, resourceToken) //
                .routeParam("id", documentId) //
                .field("files", file) //
                .asObject(new GenericType<Resource<Document>>() { //
                    // NTD
                });//

        return new Response<>(response.getBody()).getContent();
    }

    private Document uploadStream(String resourceToken, String documentId, InputStream file, String fileName) {
        try {
            byte[] fileContent = new byte[file.available()];
            IOUtils.read(file, fileContent);

            HttpResponse<Resource<Document>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + DOCUMENTS_UPLOAD_ENDPOINT) //
                    .header(X_RESOURCE_TOKEN, resourceToken) //
                    .routeParam("id", documentId) //
                    .multiPartContent().field("files", fileContent, fileName) //
                    .asObject(new GenericType<Resource<Document>>() { //
                        // NTD
                    });//

            return new Response<>(response.getBody()).getContent();
        } catch (IOException e) {
            throw new JunoApiException("Error uploading document", e);
        }
    }

    public Document uploadDocumentAsEncripted(DocumentUploadEncryptedRequest request) {
        PublicKey publicKey = JunoApiManager //
                .getCredentialsService() //
                .getPublicCredentials(new CredentialsRequest(request.getResourceToken())) //
                .getPublicKey(); //

        byte[] encryptedFile = CryptoUtils.encryptFile(publicKey, request.getFile().getFileName(), request.getFile().getStream());

        HttpResponse<Resource<Document>> response = Unirest.post(JunoApiManager.config().getResourceEndpoint() + DOCUMENTS_UPLOAD_ENDPOINT) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_ENCODING_HEADER, "gzip") //
                .header(CONTENT_TYPE_HEADER, MediaType.APPLICATION_OCTET_STREAM_VALUE) //
                .routeParam("id", request.getId()) //
                .body(encryptedFile) //
                .asObject(new GenericType<Resource<Document>>() { //
                    // NTD
                });//

        return new Response<>(response.getBody()).getContent();
    }

}
