package br.com.juno.integration.api.model;

import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import org.apache.commons.lang3.StringUtils;

import br.com.juno.integration.api.base.exception.JunoApiException;

public final class JunoPublicKey extends BaseModel {

    private static final long serialVersionUID = -422114191065898285L;

    private static final String BEGIN_PUBLIC_KEY = "-----BEGIN PUBLIC KEY-----\n";
    private static final String END_PUBLIC_KEY = "-----END PUBLIC KEY-----\n";

    private final String key;

    public JunoPublicKey(String key) {
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
