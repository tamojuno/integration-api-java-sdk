package br.com.juno.integration.api.services.request.pix;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import br.com.juno.integration.api.services.JunoApiManager;
import br.com.juno.integration.api.services.request.BaseRequestForPix;

public class PixCreateStaticQrcodeRequest extends BaseRequestForPix {

    private static final long serialVersionUID = -3257721671338666559L;

    private boolean includeImage;
    private String key;
    private String amount;
    private String reference;
    private String additionalData;

    public PixCreateStaticQrcodeRequest(String idempotencyKey, boolean includeImage, String key, String amount, String reference,
            String additionalData) {
        this(idempotencyKey, JunoApiManager.config().getResourceToken(), includeImage, key, amount, reference, additionalData);
    }

    public PixCreateStaticQrcodeRequest(String idempotencyKey, String resourceToken, boolean includeImage, String key, String amount,
            String reference, String additionalData) {
        this.includeImage = includeImage;
        this.key = key;
        this.amount = amount;
        this.reference = reference;
        this.additionalData = additionalData;
        setIdempotencyKey(idempotencyKey);
        setResourceToken(resourceToken);
    }

    public boolean getIncludeImage() {
        return includeImage;
    }

    public String getKey() {
        return key;
    }

    public String getAmount() {
        return amount;
    }

    public String getReference() {
        return reference;
    }

    public String getAdditionalData() {
        return additionalData;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.JSON_STYLE);

        builder.append("includeImage", getIncludeImage());
        builder.append("key", getKey());
        builder.append("amount", getAmount());
        builder.append("reference", getReference());
        builder.append("additionalData", getAdditionalData());

        return builder.toString();
    }
}
