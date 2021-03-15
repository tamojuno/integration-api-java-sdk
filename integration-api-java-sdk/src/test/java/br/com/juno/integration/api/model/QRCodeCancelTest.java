package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class QRCodeCancelTest extends AbstractTest {

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
        return "{\"success\":true,\"cancellationId\":\"cancellationId\"}";
    }

    public String findOneNull() {
        // NTD
        return "{\"success\":false,\"cancellationId\":null}";
    }

    public String findCompleteObject() {
        // NTD
        QRCodeCancel qrcodeCancel = new QRCodeCancel();
        qrcodeCancel.setSuccess(true);
        qrcodeCancel.setCancellationId("cancellationId");
        return qrcodeCancel.toString();
    }

    public String findIncompleteObject() {
        // NTD
        QRCodeCancel qrcodeCancel = new QRCodeCancel();
        qrcodeCancel.setSuccess(false);
        qrcodeCancel.getCancellationId();
        return qrcodeCancel.toString();
    }
}
