package br.com.juno.integration.api.model;

public class QRCode extends BaseModel {

	private static final long serialVersionUID = -3918516666752671116L; 
	
	private String referenceId;
	private String qrcodeContent;
	private String qrcodeBase64;
	private String paymentUrl;
	private Long expiresAt;
	private String picpayResult;
	private String junoResult;
	
	protected QRCode() {
		// NTD
	}
}
