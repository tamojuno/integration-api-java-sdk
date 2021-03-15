package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class PixStaticQRCodeTest extends AbstractTest {

    @Test
    public void constructors() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void toStringEmpty() {
        // NTD
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringComplete() {
        // NTD
        assertEquals(findOneComplete(), findCompleteObject());
    }

    @Test
    public void equality() {
        // NTD
    }

    public String findOneComplete() {
        // NTD
        return "{\"id\":\"qrc_413FC8BB8D33C4862AD2EAE31BA72D1E\",\"qrcodeInBase64\":\"string\",\"imageInBase64\":\"string\"}";
    }

    public String findOneNull() {
        // NTD
        return "{\"id\":null,\"qrcodeInBase64\":null,\"imageInBase64\":null}";
    }

    public String findCompleteObject() {
        // NTD
        PixStaticQRCode pixStatic = new PixStaticQRCode();
        pixStatic.setId("qrc_413FC8BB8D33C4862AD2EAE31BA72D1E");
        pixStatic.setQrcodeInBase64("string");
        pixStatic.setImageInBase64("string");
        return pixStatic.toString();
    }

    public String findIncompleteObject() {
        // NTD
        PixStaticQRCode pixStatic = new PixStaticQRCode();
        pixStatic.getId();
        pixStatic.getQrcodeInBase64();
        pixStatic.getImageInBase64();
        return pixStatic.toString();
    }
}
