package br.com.juno.integration.api.services.request.billpayment;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseResourceRequest;
import br.com.juno.integration.api.utils.CalendarUtils;

public final class RegisterBillPaymentRequest extends BaseResourceRequest {

    private static final long serialVersionUID = -8913714640641753259L;

    private final String beneficiaryDocument;
    private final BigDecimal billAmount;
    private final String numericalBarCode;
    private final BigDecimal paidAmount;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private final LocalDate paymentDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private final LocalDate dueDate;

    private String paymentDescription;

    public RegisterBillPaymentRequest(String beneficiaryDocument, BigDecimal billAmount, LocalDate dueDate, String numericalBarCode,
            BigDecimal paidAmount, LocalDate paymentDate) {
        this(beneficiaryDocument, billAmount, dueDate, numericalBarCode, paidAmount, paymentDate, JunoApiManager.config().getResourceToken());
    }

    public RegisterBillPaymentRequest(String beneficiaryDocument, BigDecimal billAmount, LocalDate dueDate, String numericalBarCode,
            BigDecimal paidAmount, LocalDate paymentDate, String resourceToken) {
        super(resourceToken);
        this.beneficiaryDocument = beneficiaryDocument;
        this.billAmount = billAmount;
        this.dueDate = dueDate;
        this.numericalBarCode = numericalBarCode;
        this.paidAmount = paidAmount;
        this.paymentDate = paymentDate;
    }

    public String getBeneficiaryDocument() {
        return beneficiaryDocument;
    }

    public BigDecimal getBillAmount() {
        return billAmount;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public String getNumericalBarCode() {
        return numericalBarCode;
    }

    public BigDecimal getPaidAmount() {
        return paidAmount;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getPaymentDescription() {
        return paymentDescription;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(beneficiaryDocument);
        builder.append(billAmount);
        builder.append(dueDate);
        builder.append(numericalBarCode);
        builder.append(paidAmount);
        builder.append(paymentDate);
        builder.append(paymentDescription);
        return builder.toString();
    }
}
