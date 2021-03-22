package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class PixStaticQRCodeTest extends AbstractTest {

    private static final String PIX_QRCODE_ID = "qrc_413FC8BB8D33C4862AD2EAE31BA72D1E";

    @Test
    public void constructors() {
        PixStaticQRCode pixStatic = new PixStaticQRCode();
        assertNull(pixStatic.getId());
        assertNull(pixStatic.getQrcodeInBase64());
        assertNull(pixStatic.getImageInBase64());

        pixStatic = new PixStaticQRCode();
        pixStatic.setId(PIX_QRCODE_ID);
        pixStatic.setQrcodeInBase64("string");
        pixStatic.setImageInBase64("string");
    }

    @Test
    public void toStringComplete() {
        PixStaticQRCode pixStatic = new PixStaticQRCode();
        pixStatic.setId(PIX_QRCODE_ID);
        pixStatic.setQrcodeInBase64("string");
        pixStatic.setImageInBase64("string");
        assertEquals("PixStaticQRCode[qrc_413FC8BB8D33C4862AD2EAE31BA72D1E,string,string]", pixStatic.toString());
    }

    @Test
    public void toStringEmpty() {
        PixStaticQRCode pixStatic = new PixStaticQRCode();
        assertEquals("PixStaticQRCode[<null>,<null>,<null>]", pixStatic.toString());
    }

    @Test
    public void jsonToObject() throws Exception {
        Response<PixStaticQRCode> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<PixStaticQRCode>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        PixStaticQRCode pixStatic = res.getContent();

        assertEquals("string", pixStatic.getQrcodeInBase64());
        assertEquals("string", pixStatic.getImageInBase64());

    }

    private String findOne() {
        return "{\"id\":\"qrc_413FC8BB8D33C4862AD2EAE31BA72D1E\",\"qrcodeInBase64\":\"string\",\"imageInBase64\":\"string\"}";
    }
}
