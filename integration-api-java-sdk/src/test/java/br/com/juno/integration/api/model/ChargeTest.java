package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.model.Charge.BilletDetails;
import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

@Disabled
public class ChargeTest extends AbstractTest {

    private static final Long CODE = 136392404L;
    private static final String REFERENCE = "RefByCharge";
    private static final String DUE_DATE = "2021-03-19";
    private static final String LINK = null;
    private static final String CHECKOUT_URL = "https://pay-sandbox.juno.com.br/checkout/BFAF5739FACF2B5BB8F3DEE7844535DCB111015DD74E9DB8";
    private static final String INSTALLMENT_LINK = null;
    private static final String PAY_NUMBER = null;
    private static final BigDecimal AMOUNT = BigDecimal.valueOf(50.00D);
    private static final String STATUS = "ACTIVE";
    private static final BilletDetails BILLET_DETAILS = new BilletDetails("0001/1000004640-7", "000000136393499-3",
            "38395856500000050000000046400000001363934991", "0001");
    private static final List<Payment> PAYMENTS = new ArrayList<>();
    private static final List<PixStaticQRCode> PIX = new ArrayList<>();

    @Test
    public void constructors() {
        Charge charge = new Charge();
        assertNull(charge.getCode());
        assertNull(charge.getReference());
        assertNull(charge.getDueDate());
        assertNull(charge.getLink());
        assertNull(charge.getCheckoutUrl());
        assertNull(charge.getInstallmentLink());
        assertNull(charge.getPayNumber());
        assertNull(charge.getAmount());
        assertNull(charge.getStatus());
        assertNull(charge.getBilletDetails());
        assertNull(charge.getPayments());
        assertNull(charge.getPix());

        charge = new Charge();
        charge.setCode(CODE);
        charge.setReference(REFERENCE);
        charge.setDueDate(DUE_DATE);
        charge.setLink(LINK);
        charge.setCheckoutUrl(CHECKOUT_URL);
        charge.setInstallmentLink(null);
        charge.setPayNumber(null);
        charge.setAmount(AMOUNT);
        charge.setStatus(STATUS);
        charge.setBilletDetails(BILLET_DETAILS);
        charge.setPayments(PAYMENTS);
        charge.setPix(PIX);

        assertEquals(CODE, charge.getCode());
        assertEquals(REFERENCE, charge.getReference());
        assertEquals(DUE_DATE, charge.getDueDate());
        assertEquals(LINK, charge.getLink());
        assertEquals(CHECKOUT_URL, charge.getCheckoutUrl());
        assertEquals(INSTALLMENT_LINK, charge.getInstallmentLink());
        assertEquals(PAY_NUMBER, charge.getPayNumber());
        assertEquals(AMOUNT, charge.getAmount());
        assertEquals(STATUS, charge.getStatus());
        assertEquals(BILLET_DETAILS, charge.getBilletDetails());
        assertEquals(PAYMENTS, charge.getPayments());
        assertEquals(PIX, charge.getPix());

    }

    @Test
    public void toStringComplete() {
        Charge charge = new Charge();
        charge.setId("chr_AD5231DE9B9620DA368C50F4E31067E2");
        charge.setCode(CODE);
        charge.setReference(REFERENCE);
        charge.setDueDate(DUE_DATE);
        charge.setLink(LINK);
        charge.setCheckoutUrl(CHECKOUT_URL);
        charge.setInstallmentLink(null);
        charge.setPayNumber(null);
        charge.setAmount(AMOUNT);
        charge.setStatus(STATUS);
        charge.setBilletDetails(BILLET_DETAILS);
        charge.setPayments(PAYMENTS);
        charge.setPix(PIX);
        assertEquals(
                "Charge[chr_AD5231DE9B9620DA368C50F4E31067E2,136392404,RefByCharge,2021-03-19,<null>,https://pay-sandbox.juno.com.br/checkout/BFAF5739FACF2B5BB8F3DEE7844535DCB111015DD74E9DB8,<null>,<null>,50.0,ACTIVE,Charge.BilletDetails[0001/1000004640-7,000000136393499-3,38395856500000050000000046400000001363934991,0001],[],[]]",
                charge.toString());
    }

    @Test
    public void toStringEmpty() {
        Charge charge = new Charge();
        assertEquals("Charge[<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>]", charge.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<Charge> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<Charge>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        Charge charge = res.getContent();
        System.out.println(res.getContent());

        assertEquals(CODE, charge.getCode());
        assertEquals(REFERENCE, charge.getReference());
        assertEquals(DUE_DATE, charge.getDueDate());
        assertEquals(LINK, charge.getLink());
        assertEquals(CHECKOUT_URL, charge.getCheckoutUrl());
        assertEquals(INSTALLMENT_LINK, charge.getInstallmentLink());
        assertEquals(PAY_NUMBER, charge.getPayNumber());
        assertEquals(AMOUNT, charge.getAmount());
        assertEquals(STATUS, charge.getStatus());
        assertEquals(BILLET_DETAILS, charge.getBilletDetails());
        assertEquals(PAYMENTS, charge.getPayments());
        assertEquals(PIX, charge.getPix());

    }

    public String findOne() {
        return "{\"id\":\"chr_AD5231DE9B9620DA368C50F4E31067E2\",\"code\":136392404,\"reference\":\"RefByCharge\",\"dueDate\":\"2021-03-19\",\"link\":null,\"checkoutUrl\":\"https://pay-sandbox.juno.com.br/checkout/BFAF5739FACF2B5BB8F3DEE7844535DCB111015DD74E9DB8\",\"installmentLink\":null,\"payNumber\":null,\"amount\":50.0,\"status\":\"ACTIVE\",\"billetDetails\":{\"bankAccount\":\"0001/1000004640-7\",\"ourNumber\":\"000000136393499-3\",\"barcodeNumber\":\"38395856500000050000000046400000001363934991\",\"portfolio\":\"0001\"},\"payments\":[],\"pix\":[]}";
    }
}
