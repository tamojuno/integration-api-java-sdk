package br.com.juno.integration.api.services;

import static br.com.juno.integration.api.services.JunoApiManager.CONTENT_TYPE_HEADER;
import static br.com.juno.integration.api.services.JunoApiManager.X_RESOURCE_TOKEN;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;

import br.com.juno.integration.api.base.exception.JunoApiException;
import br.com.juno.integration.api.model.BaseModel;
import br.com.juno.integration.api.services.request.credentials.CredentialsRequest;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;

public class CredentialsService extends BaseService {

    private static final String CREDENTIALS_ENDPOINT = "/credentials/public-key";

    CredentialsService() {
        // NTD
    }

    public JunoPublicKey getPublicCredentials(CredentialsRequest request) {
        HttpResponse<String> response = Unirest.get(JunoApiManager.config().getResourceEndpoint() + CREDENTIALS_ENDPOINT) //
                .header(X_RESOURCE_TOKEN, request.getResourceToken()) //
                .header(CONTENT_TYPE_HEADER, MediaType.TEXT_PLAIN_VALUE) //
                .asString(); //

        return new JunoPublicKey(response.getBody());
    }

    public static final class JunoPublicKey extends BaseModel {

        private static final long serialVersionUID = -422114191065898285L;

        private static final String BEGIN_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\n";
        private static final String END_PUBLIC_KEY = "-----END PUBLIC KEY-----\n";

        private final String key;

        protected JunoPublicKey(String key) {
            this.key = key;
        }

        public String getKey() {
            return key;
        }

        public PublicKey getPublicKey() {
            try {
                String publicKey = key.replace(BEGIN_PUBLIC_KEY, StringUtils.EMPTY).replace(END_PUBLIC_KEY, StringUtils.EMPTY);

                byte[] encodedPublicKey = Base64.getMimeDecoder().decode(publicKey);
                X509EncodedKeySpec spec = new X509EncodedKeySpec(encodedPublicKey);
                KeyFactory kf = KeyFactory.getInstance("RSA");

                return kf.generatePublic(spec);
            } catch (Exception e) {
                throw new JunoApiException("Error retrieving public key", e);
            }
        }

    }

}
