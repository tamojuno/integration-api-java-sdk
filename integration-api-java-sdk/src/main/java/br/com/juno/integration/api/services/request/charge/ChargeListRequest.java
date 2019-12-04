package br.com.juno.integration.api.services.request.charge;

import java.util.Calendar;

import br.com.juno.integration.api.model.LabeledEnum;
import br.com.juno.integration.api.services.request.BaseResourceRequest;

public final class ChargeListRequest extends BaseResourceRequest {

    private static final long serialVersionUID = -9217822108257430472L;

    private static final Double MIN_RECORDS_PER_REQUEST = 20D;
    private static final Double MAX_RECORDS_PER_REQUEST = 100D;

    private Calendar createdOnStart;
    private Calendar createdOnEnd;
    private Calendar dueDateStart;
    private Calendar dueDateEnd;
    private Calendar paymentDateStart;
    private Calendar paymentDateEnd;
    private Boolean showUnarchived;
    private Boolean showArchived;
    private Boolean showDue;
    private Boolean showNotDue;
    private Boolean showPaid;
    private Boolean showNotPaid;
    private Boolean showCancelled;
    private Boolean showNotCancelled;
    private Boolean showManualReconciliation;
    private Boolean showNotManualReconciliation;
    private Boolean showNotFailed;
    private OrderBy orderBy;
    private Boolean orderAsc;
    private Integer pageSize;

    public enum OrderBy implements LabeledEnum {
        ID("id"),
        DUE_DATE("dueDate"),
        AMOUNT("amount"),
        PAYMENT_DATE("paymentDate");

        private OrderBy(String label) {
            this.label = label;
        }

        private String label;

        @Override
        public String getLabel() {
            return label;
        }
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize != null && pageSize > MIN_RECORDS_PER_REQUEST ? Math.abs(pageSize) : MIN_RECORDS_PER_REQUEST.intValue();
    }

    public Double getTotalPages() {
        return pageSize != null ? Double.valueOf(pageSize) / MAX_RECORDS_PER_REQUEST : 1D;
    }

    public Calendar getCreatedOnStart() {
        return createdOnStart;
    }

    public void setCreatedOnStart(Calendar createdOnStart) {
        this.createdOnStart = createdOnStart;
    }

    public Calendar getCreatedOnEnd() {
        return createdOnEnd;
    }

    public void setCreatedOnEnd(Calendar createdOnEnd) {
        this.createdOnEnd = createdOnEnd;
    }

    public Calendar getDueDateStart() {
        return dueDateStart;
    }

    public void setDueDateStart(Calendar dueDateStart) {
        this.dueDateStart = dueDateStart;
    }

    public Calendar getDueDateEnd() {
        return dueDateEnd;
    }

    public void setDueDateEnd(Calendar dueDateEnd) {
        this.dueDateEnd = dueDateEnd;
    }

    public Calendar getPaymentDateStart() {
        return paymentDateStart;
    }

    public void setPaymentDateStart(Calendar paymentDateStart) {
        this.paymentDateStart = paymentDateStart;
    }

    public Calendar getPaymentDateEnd() {
        return paymentDateEnd;
    }

    public void setPaymentDateEnd(Calendar paymentDateEnd) {
        this.paymentDateEnd = paymentDateEnd;
    }

    public Boolean getShowUnarchived() {
        return showUnarchived;
    }

    public void setShowUnarchived(Boolean showUnarchived) {
        this.showUnarchived = showUnarchived;
    }

    public Boolean getShowArchived() {
        return showArchived;
    }

    public void setShowArchived(Boolean showArchived) {
        this.showArchived = showArchived;
    }

    public Boolean getShowDue() {
        return showDue;
    }

    public void setShowDue(Boolean showDue) {
        this.showDue = showDue;
    }

    public Boolean getShowNotDue() {
        return showNotDue;
    }

    public void setShowNotDue(Boolean showNotDue) {
        this.showNotDue = showNotDue;
    }

    public Boolean getShowPaid() {
        return showPaid;
    }

    public void setShowPaid(Boolean showPaid) {
        this.showPaid = showPaid;
    }

    public Boolean getShowNotPaid() {
        return showNotPaid;
    }

    public void setShowNotPaid(Boolean showNotPaid) {
        this.showNotPaid = showNotPaid;
    }

    public Boolean getShowCancelled() {
        return showCancelled;
    }

    public void setShowCancelled(Boolean showCancelled) {
        this.showCancelled = showCancelled;
    }

    public Boolean getShowNotCancelled() {
        return showNotCancelled;
    }

    public void setShowNotCancelled(Boolean showNotCancelled) {
        this.showNotCancelled = showNotCancelled;
    }

    public Boolean getShowManualReconciliation() {
        return showManualReconciliation;
    }

    public void setShowManualReconciliation(Boolean showManualReconciliation) {
        this.showManualReconciliation = showManualReconciliation;
    }

    public Boolean getShowNotManualReconciliation() {
        return showNotManualReconciliation;
    }

    public void setShowNotManualReconciliation(Boolean showNotManualReconciliation) {
        this.showNotManualReconciliation = showNotManualReconciliation;
    }

    public Boolean getShowNotFailed() {
        return showNotFailed;
    }

    public void setShowNotFailed(Boolean showNotFailed) {
        this.showNotFailed = showNotFailed;
    }

    public OrderBy getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(OrderBy orderBy) {
        this.orderBy = orderBy;
    }

    public Boolean getOrderAsc() {
        return orderAsc;
    }

    public void setOrderAsc(Boolean orderAsc) {
        this.orderAsc = orderAsc;
    }

    public Integer getPageSize() {
        return pageSize;
    }
}
