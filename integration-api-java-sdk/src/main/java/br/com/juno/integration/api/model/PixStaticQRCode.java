package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class PixStaticQRCode extends BaseModel {

	private static final long serialVersionUID = 3939562220737401185L;

	private String qrcodeInBase64;
	private String imageInBase64; 
	
	protected PixStaticQRCode() {
		// NTD
	}
	
	public String getQrcodeInBase64() {
		return qrcodeInBase64;
	}
	
	public String getImageInBase64() {
		return imageInBase64;
	}
	
	@Override
	public String toString() {
		ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);
		
		builder.append("id", getId());
		builder.append("qrcodeInBase64", getQrcodeInBase64());
		builder.append("imageInBase64", getImageInBase64());
		
		return builder.toString();
	}
}
