package br.com.juno.integration.api.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.juno.test.AbstractTest;

public class BillPaymentTest extends AbstractTest {

    //TODO: Adjust BillPayment class to match new params
    @Test
    public void constructors() {
        assertEquals(findOneNull(), findIncompleteObject());
        assertEquals(findOneFull(), findCompleteObject());
    }

    @Test
    public void toStringEmpty() {
        assertEquals(findOneNull(), findIncompleteObject());
    }

    @Test
    public void toStringComplete() {
        assertEquals(findOneFull(), findCompleteObject());
    }

    public String findOneFull() {
        return "{\"id\":\"bil_B6E2DEF23DC2942D\",\"numericalBarCode\":\"34191101213456788005871234570001616670000012345\",\"billAmount\":123.45,\"dueDate\":\"2021-03-18\",\"billType\":\"BOLETO\",\"digitalAccountId\":\"dac_56101832681175AD\",\"paidAmount\":100.0,\"paymentDate\":\"2021-03-12\",\"paymentDescription\":\"Payment sample\",\"beneficiaryDocument\":\"06085371950\",\"status\":\"REQUESTED\",\"createdOn\":\"2021-03-12 02:27:11\"}";
    }

    public String findOneNull() {
        return "{\"id\":null,\"numericalBarCode\":null,\"billAmount\":null,\"dueDate\":null,\"billType\":null,\"digitalAccountId\":null,\"paidAmount\":null,\"paymentDate\":null,\"paymentDescription\":null,\"beneficiaryDocument\":null,\"status\":null,\"createdOn\":null}";
    }

    public String findCompleteObject() {
        BillPayment billPayment = new BillPayment();
        billPayment.setId("bil_B6E2DEF23DC2942D");
        billPayment.setNumericalBarCode("34191101213456788005871234570001616670000012345");
        billPayment.setBillAmount(BigDecimal.valueOf(123.45D));
        billPayment.setDueDate(LocalDate.of(2021, 03, 18));
        billPayment.setBillType("BOLETO");
        billPayment.setDigitalAccountId("dac_56101832681175AD");
        billPayment.setPaidAmount(BigDecimal.valueOf(100.0D));
        billPayment.setPaymentDate(LocalDate.of(2021, 03, 12));
        billPayment.setPaymentDescription("Payment sample");
        billPayment.setBeneficiaryDocument(HOLDER_CPF);
        billPayment.setStatus("REQUESTED");
        billPayment.setCreatedOn("2021-03-12 02:27:11");
        return billPayment.toString();
    }

    public String findIncompleteObject() {
        BillPayment billPayment = new BillPayment();
        billPayment.getId();
        billPayment.getNumericalBarCode();
        billPayment.getBillAmount();
        billPayment.getDueDate();
        billPayment.getBillType();
        billPayment.getDigitalAccountId();
        billPayment.getPaidAmount();
        billPayment.getPaymentDate();
        billPayment.getPaymentDescription();
        billPayment.getBeneficiaryDocument();
        billPayment.getStatus();
        billPayment.getCreatedOn();
        return billPayment.toString();

    }
}
