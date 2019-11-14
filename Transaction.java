import java.util.Date;

class Transaction {
    private String transactionId;
    private String fromAccountId;
    private String toAccountId;
    private Date createdAt;
    private float amount;
    private String transactionType;
    private String relatedTransaction;

    public Transaction(String transactionId, String fromAccountId, String toAccountId, Date createdAt, float amount, String transactionType, String relatedTransaction) {
        this.transactionId = transactionId;
        this.fromAccountId = fromAccountId;
        this.toAccountId = toAccountId;
        this.createdAt = createdAt;
        this.amount = amount;
        this.transactionType = transactionType;
        this.relatedTransaction = relatedTransaction;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getFromAccountId() {
        return fromAccountId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public Float getAmount() {
        return amount;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getRelatedTransaction() {
        return relatedTransaction;
    }

    @Override
    public String toString() {
        return "Transaction [" + transactionId + ", " + fromAccountId + ", " + toAccountId
                + ", " + createdAt + "," + amount + ", " + transactionType + ", " + relatedTransaction + "]";
    }

}