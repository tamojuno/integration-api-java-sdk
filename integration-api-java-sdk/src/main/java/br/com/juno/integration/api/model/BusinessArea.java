package br.com.juno.integration.api.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public final class BusinessArea {

    private Long code;
    private String activity;
    private String category;

    protected BusinessArea() {
        // NTD
    }

    public Long getCode() {
        return code;
    }

    public String getActivity() {
        return activity;
    }

    public String getCategory() {
        return category;
    }

    void setCode(Long code) {
        this.code = code;
    }

    void setActivity(String activity) {
        this.activity = activity;
    }

    void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        builder.append(code);
        builder.append(activity);
        builder.append(category);
        return builder.toString();
    }

}
