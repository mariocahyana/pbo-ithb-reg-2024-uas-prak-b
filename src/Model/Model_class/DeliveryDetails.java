package Model.Model_class;

import java.util.Date;

import Model.Model_enum.Status;

class DeliveryDetails {
    private int delivery_id;
    private int transactionId;
    private Status status;
    private String currentPosition;
    private String evidence;
    private Date date;
    private String updatedBy;

    public DeliveryDetails(int delivery_id, int transactionId, Status status, String currentPosition, String evidence,Date date, String updatedBy) {
        this.delivery_id = delivery_id;
        this.transactionId = transactionId;
        this.status = status;
        this.currentPosition = currentPosition;
        this.evidence = evidence;
        this.date = date;
        this.updatedBy = updatedBy;
    }

    public int getDelivery_id() {
        return delivery_id;
    }

    public void setDelivery_id(int delivery_id) {
        this.delivery_id = delivery_id;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(int transactionId) {
        this.transactionId = transactionId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(String currentPosition) {
        this.currentPosition = currentPosition;
    }

    public String getEvidence() {
        return evidence;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
}
