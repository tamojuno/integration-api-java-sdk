package br.com.juno.integration.api.model;

import java.math.BigDecimal;
import java.util.Calendar;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.juno.integration.api.utils.CalendarUtils;

public class PaymentRefund extends BaseModel {

    private static final long serialVersionUID = 1539599625216489779L;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private Calendar releaseDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = CalendarUtils.API_DATE_FORMAT)
    private Calendar paybackDate;

    private BigDecimal paybackAmount;

    private String status;

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

}
