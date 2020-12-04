package br.com.juno.integration.api.model;

import java.time.LocalDate;

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
	private LocalDate expiresAt;
	
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
	
	public LocalDate getExpiresAts() {
		return expiresAt;
	}
	
	public PicpayCreateResultType getPicpayResult() {
		return picpayResult;
	}
	
	public JunoCreateResultType getJunoResult() {
		return junoResult;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		builder.append("referenceId", getReferenceId());
		builder.append("qrCodeContent", getQrcodeContent());
		builder.append("qrcodeBase64", getQrcodeBase64());
		builder.append("paymentUrl",getPaymentUrl());
		builder.append("picpayResult", getPicpayResult());
		builder.append("junoResult", getJunoResult());
		builder.append("expiresAt", getExpiresAts());
		return builder.toString();
	}
}
