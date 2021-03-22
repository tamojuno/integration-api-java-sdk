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

    protected void setQrcodeInBase64(String qrcodeInBase64) {
        this.qrcodeInBase64 = qrcodeInBase64;
    }

    protected void setImageInBase64(String imageInBase64) {
        this.imageInBase64 = imageInBase64;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(getId());
        builder.append(getQrcodeInBase64());
        builder.append(getImageInBase64());
        return builder.toString();
    }
}
