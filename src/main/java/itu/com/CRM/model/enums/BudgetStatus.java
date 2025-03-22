package itu.com.CRM.model.enums;

public enum BudgetStatus {
    DRAFT(0, "Draft"),
    CANCELLED(1, "Cancelled"),
    CONFIRMED(2, "Confirmed"),
    ARCHIVED(3, "Archived");

    private final int value;
    private final String description;

    BudgetStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static BudgetStatus fromValue(int value) {
        for (BudgetStatus status : BudgetStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}
