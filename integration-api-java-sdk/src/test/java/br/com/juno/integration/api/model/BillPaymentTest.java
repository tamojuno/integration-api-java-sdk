package br.com.juno.integration.api.model;

import static br.com.juno.test.FixtureHelper.HOLDER_DOCUMENT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.math.BigDecimal;

import com.fasterxml.jackson.core.type.TypeReference;

import org.junit.jupiter.api.Test;
import org.springframework.hateoas.Resource;

import br.com.juno.integration.api.services.response.Response;
import br.com.juno.test.AbstractTest;

public class BillPaymentTest extends AbstractTest {

    private static final String NUMERICAL_BAR_CODE = "34191101213456788005871234570001616670000012345";
    private static final BigDecimal BILL_AMOUNT = BigDecimal.valueOf(123.45D);
    private static final String BILL_DUE_DATE = "2021-03-18";
    private static final String BILL_TYPE = "BOLETO";
    private static final String DIGITAL_ACCOUNT_ID = "dac_56101832681175AD";
    private static final BigDecimal BILL_PAID_AMOUNT = BigDecimal.valueOf(100.0D);
    private static final String BILL_PAYMENT_DATE = "2021-03-12";
    private static final String BILL_PAYMENT_DESCRIPTION = "Payment sample";
    private static final String BILL_PAYMENT_STATUS = "REQUESTED";
    private static final String BILL_CREATED_ON = "2021-03-12 02:27:11";

    @Test
    public void constructors() {
        BillPayment billPayment = new BillPayment();
        assertNull(billPayment.getNumericalBarCode());
        assertNull(billPayment.getBillAmount());
        assertNull(billPayment.getDueDate());
        assertNull(billPayment.getBillType());
        assertNull(billPayment.getDigitalAccountId());
        assertNull(billPayment.getPaidAmount());
        assertNull(billPayment.getPaymentDate());
        assertNull(billPayment.getPaymentDescription());
        assertNull(billPayment.getBeneficiaryDocument());
        assertNull(billPayment.getStatus());
        assertNull(billPayment.getCreatedOn());

        billPayment = new BillPayment();
        billPayment.setNumericalBarCode(NUMERICAL_BAR_CODE);
        billPayment.setBillAmount(BigDecimal.valueOf(123.45D));
        billPayment.setDueDate(BILL_DUE_DATE);
        billPayment.setBillType(BILL_TYPE);
        billPayment.setDigitalAccountId(DIGITAL_ACCOUNT_ID);
        billPayment.setPaidAmount(BILL_PAID_AMOUNT);
        billPayment.setPaymentDate(BILL_PAYMENT_DATE);
        billPayment.setPaymentDescription(BILL_PAYMENT_DESCRIPTION);
        billPayment.setBeneficiaryDocument(HOLDER_DOCUMENT);
        billPayment.setStatus(BILL_PAYMENT_STATUS);
        billPayment.setCreatedOn(BILL_CREATED_ON);
    }

    @Test
    public void toStringComplete() {
        BillPayment billPayment = new BillPayment();
        billPayment.setNumericalBarCode(NUMERICAL_BAR_CODE);
        billPayment.setBillAmount(BigDecimal.valueOf(123.45D));
        billPayment.setDueDate(BILL_DUE_DATE);
        billPayment.setBillType(BILL_TYPE);
        billPayment.setDigitalAccountId(DIGITAL_ACCOUNT_ID);
        billPayment.setPaidAmount(BILL_PAID_AMOUNT);
        billPayment.setPaymentDate(BILL_PAYMENT_DATE);
        billPayment.setPaymentDescription(BILL_PAYMENT_DESCRIPTION);
        billPayment.setBeneficiaryDocument(HOLDER_DOCUMENT);
        billPayment.setStatus(BILL_PAYMENT_STATUS);
        billPayment.setCreatedOn(BILL_CREATED_ON);
        assertEquals(
                "BillPayment[<null>,34191101213456788005871234570001616670000012345,123.45,2021-03-18,BOLETO,dac_56101832681175AD,100.0,2021-03-12,Payment sample,06085371950,REQUESTED,2021-03-12 02:27:11]",
                billPayment.toString());
    }

    @Test
    public void toStringEmpty() {
        BillPayment billPayment = new BillPayment();
        assertEquals("BillPayment[<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>,<null>]", billPayment.toString());
    }

    //TODO: create equality test

    @Test
    public void jsonToObject() throws Exception {
        Response<BillPayment> res = new Response<>(getObjectMapper().readValue(findOne(), new TypeReference<Resource<BillPayment>>() {
            // NTD
        }));

        assertEquals(null, res.getHrefSelf());

        BillPayment billPayment = res.getContent();

        assertEquals(NUMERICAL_BAR_CODE, billPayment.getNumericalBarCode());
        assertEquals(BILL_AMOUNT, billPayment.getBillAmount());
        assertEquals(BILL_DUE_DATE, billPayment.getDueDate());
        assertEquals(BILL_TYPE, billPayment.getBillType());
        assertEquals(DIGITAL_ACCOUNT_ID, billPayment.getDigitalAccountId());
        assertEquals(BILL_PAID_AMOUNT, billPayment.getPaidAmount());
        assertEquals(BILL_PAYMENT_DATE, billPayment.getPaymentDate());
        assertEquals(BILL_PAYMENT_DESCRIPTION, billPayment.getPaymentDescription());
        assertEquals(HOLDER_DOCUMENT, billPayment.getBeneficiaryDocument());
        assertEquals(BILL_PAYMENT_STATUS, billPayment.getStatus());
        assertEquals(BILL_CREATED_ON, billPayment.getCreatedOn());

    }

    private String findOne() {
        return "{\"id\":\"bil_B6E2DEF23DC2942D\",\"numericalBarCode\":\"34191101213456788005871234570001616670000012345\",\"billAmount\":123.45,\"dueDate\":\"2021-03-18\",\"billType\":\"BOLETO\",\"digitalAccountId\":\"dac_56101832681175AD\",\"paidAmount\":100.0,\"paymentDate\":\"2021-03-12\",\"paymentDescription\":\"Payment sample\",\"beneficiaryDocument\":\"06085371950\",\"status\":\"REQUESTED\",\"createdOn\":\"2021-03-12 02:27:11\"}";
    }
}
