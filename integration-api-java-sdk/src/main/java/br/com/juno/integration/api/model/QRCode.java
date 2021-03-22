package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class QRCode extends BaseModel {

    private static final long serialVersionUID = -5969620943760959840L;

    private String referenceId;
    private String qrcodeContent;
    private String qrcodeBase64;
    private String paymentUrl;
    private PicpayCreateResultType picpayResult;
    private JunoCreateResultType junoResult;
    private String expiresAt;

    protected QRCode() {
        // NTD
    }

    public enum PicpayCreateResultType {
        SUCCESS,
        FAIL,
        FETCHED
    }

    public enum JunoCreateResultType {
        SUCCESS,
        FAIL_UPDATE,
        FAIL_DELETE
    }

    public String getReferenceId() {
        return referenceId;
    }

    public String getQrcodeContent() {
        return qrcodeContent;
    }

    public String getQrcodeBase64() {
        return qrcodeBase64;
    }

    public String getPaymentUrl() {
        return paymentUrl;
    }

    public String getExpiresAts() {
        return expiresAt;
    }

    public PicpayCreateResultType getPicpayResult() {
        return picpayResult;
    }

    public JunoCreateResultType getJunoResult() {
        return junoResult;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public void setQrcodeContent(String qrcodeContent) {
        this.qrcodeContent = qrcodeContent;
    }

    public void setQrcodeBase64(String qrcodeBase64) {
        this.qrcodeBase64 = qrcodeBase64;
    }

    public void setPaymentUrl(String paymentUrl) {
        this.paymentUrl = paymentUrl;
    }

    public void setPicpayResult(PicpayCreateResultType picpayResult) {
        this.picpayResult = picpayResult;
    }

    public void setJunoResult(JunoCreateResultType junoResult) {
        this.junoResult = junoResult;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
        builder.append("referenceId", getReferenceId());
        builder.append("qrcodeContent", getQrcodeContent());
        builder.append("qrcodeBase64", getQrcodeBase64());
        builder.append("paymentUrl", getPaymentUrl());
        builder.append("expiresAts", getExpiresAts());
        builder.append("picpayResult", getPicpayResult());
        builder.append("junoResult", getJunoResult());
        return builder.toString();
    }
}
