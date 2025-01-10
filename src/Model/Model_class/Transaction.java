package Model.Model_class;

import java.util.Date;

class Transaction {
    private int transaction_id;
    private int customerId;
    private String deliveryType;
    private int expectedWeight;
    private int totalCost;
    private Date createdAt;
    private String receiptName;
    private String receiptAddress;
    private String receiptPhone;

    public Transaction(int transaction_id, int customerId, String deliveryType, int expectedWeight, int totalCost, Date createdAt, String receiptName, String receiptAddress, String receiptPhone) {
        this.transaction_id = transaction_id;
        this.customerId = customerId;
        this.deliveryType = deliveryType;
        this.expectedWeight = expectedWeight;
        this.totalCost = totalCost;
        this.createdAt = createdAt;
        this.receiptName = receiptName;
        this.receiptAddress = receiptAddress;
        this.receiptPhone = receiptPhone;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDeliveryType() {
        return deliveryType;
    }

    public void setDeliveryType(String deliveryType) {
        this.deliveryType = deliveryType;
    }

    public int getExpectedWeight() {
        return expectedWeight;
    }

    public void setExpectedWeight(int expectedWeight) {
        this.expectedWeight = expectedWeight;
    }

    public int getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(int totalCost) {
        this.totalCost = totalCost;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getReceiptName() {
        return receiptName;
    }

    public void setReceiptName(String receiptName) {
        this.receiptName = receiptName;
    }

    public String getReceiptAddress() {
        return receiptAddress;
    }

    public void setReceiptAddress(String receiptAddress) {
        this.receiptAddress = receiptAddress;
    }

    public String getReceiptPhone() {
        return receiptPhone;
    }

    public void setReceiptPhone(String receiptPhone) {
        this.receiptPhone = receiptPhone;
    }
}
