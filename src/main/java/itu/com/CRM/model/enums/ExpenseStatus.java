package itu.com.CRM.model.enums;

public enum ExpenseStatus {
    DRAFT(0, "Draft"),
    CANCELLED(1, "Cancelled"),
    CONFIRMED(2, "Confirmed"),
    ARCHIVED(3, "Archived");

    private final int value;
    private final String description;

    ExpenseStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static ExpenseStatus fromValue(int value) {
        for (ExpenseStatus status : ExpenseStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}

