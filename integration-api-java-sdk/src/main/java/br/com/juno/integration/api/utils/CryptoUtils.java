package br.com.juno.integration.api.utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.MGF1ParameterSpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPOutputStream;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.OAEPParameterSpec;
import javax.crypto.spec.PSource;

import org.apache.commons.io.IOUtils;
import org.jose4j.json.JsonUtil;
import org.jose4j.jwe.ContentEncryptionAlgorithmIdentifiers;
import org.jose4j.jwe.JsonWebEncryption;
import org.jose4j.jwe.KeyManagementAlgorithmIdentifiers;
import org.jose4j.lang.JoseException;

import br.com.juno.integration.api.base.exception.JunoApiException;

public final class CryptoUtils {

    private CryptoUtils() {
        // Utility class
    }

    public static String encryptCreditCard(PublicKey publicKey, byte[] creditCardData) {
        try {
            OAEPParameterSpec parameterSpec = new OAEPParameterSpec(Crypto.MD_NAME, Crypto.MG_NAME, MGF1ParameterSpec.SHA256,
                    PSource.PSpecified.DEFAULT);

            Cipher cipher = Cipher.getInstance(Crypto.CRYPTO_TRANSFORM);
            cipher.init(Cipher.ENCRYPT_MODE, publicKey, parameterSpec);

            byte[] encryptedBytes = cipher.doFinal(creditCardData);

            return Base64.getEncoder().encodeToString(encryptedBytes);
        } catch (InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException | NoSuchAlgorithmException
                | NoSuchPaddingException e) {
            throw new JunoApiException("Error encrypting credit card data", e);
        }
    }

    public interface Crypto {

        public static final String CRYPTO_METHOD = "RSA";
        public static final String MD_NAME = "SHA-256";
        public static final String MG_NAME = "MGF1";
        public static final String CRYPTO_TRANSFORM = "RSA/ECB/OAEPPadding";
    }

    public static byte[] encryptFile(PublicKey publicKey, String fileName, InputStream file) {
        String fileContent = encodeBase64File(file);

        // Json specification
        String content = generateJsonSpecification(fileName, fileContent);

        // JWT token generation
        String jweToken = generateJweToken(publicKey, content);

        // JWT token compression
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        compressJwe(output, jweToken);
        return output.toByteArray();
    }

    private static String generateJsonSpecification(String fileName, String fileContent) {
        Map<String, Object> map = new HashMap<>();
        map.put("fn", fileName);
        map.put("fc", fileContent);
        return JsonUtil.toJson(map);
    }

    private static String encodeBase64File(InputStream file) {
        return Base64.getEncoder().encodeToString(readFile(file));
    }

    private static byte[] readFile(InputStream file) {
        try {
            return IOUtils.toByteArray(file);
        } catch (IOException e) {
            throw new JunoApiException("Error reading the file contents", e);
        }
    }

    private static String generateJweToken(PublicKey publicKey, String content) {
        try {
            JsonWebEncryption jwe = new JsonWebEncryption();
            jwe.setAlgorithmHeaderValue(KeyManagementAlgorithmIdentifiers.RSA_OAEP_256);
            jwe.setEncryptionMethodHeaderParameter(ContentEncryptionAlgorithmIdentifiers.AES_256_GCM);
            jwe.enableDefaultCompression();
            jwe.setKey(publicKey);
            jwe.setPlaintext(content);
            return jwe.getCompactSerialization();
        } catch (JoseException e) {
            throw new JunoApiException("Error generating JWE token", e);
        }
    }

    private static void compressJwe(OutputStream output, String jweToken) {
        try {
            GZIPOutputStream gzip = new GZIPOutputStream(output);
            gzip.write(jweToken.getBytes(StandardCharsets.UTF_8));
            gzip.close();
        } catch (IOException e) {
            throw new JunoApiException("Error compressing JWE", e);
        }
    }
}
