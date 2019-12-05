package br.com.juno.integration.api.model;

import java.math.BigDecimal;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.utils.CalendarUtils;

public class PaymentRefund extends BaseModel {

    private static final long serialVersionUID = 1539599625216489779L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private Calendar releaseDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private Calendar paybackDate;

    private BigDecimal paybackAmount;
    private String status;
    private String chargeId;

    protected PaymentRefund() {
        // NTD
    }

    public Calendar getReleaseDate() {
        return releaseDate;
    }

    public Calendar getPaybackDate() {
        return paybackDate;
    }

    public BigDecimal getPaybackAmount() {
        return paybackAmount;
    }

    public String getStatus() {
        return status;
    }

    public String getChargeId() {
        return chargeId;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(chargeId);
        builder.append(releaseDate);
        builder.append(paybackDate);
        builder.append(paybackAmount);
        builder.append(status);
        return builder.toString();
    }

}
