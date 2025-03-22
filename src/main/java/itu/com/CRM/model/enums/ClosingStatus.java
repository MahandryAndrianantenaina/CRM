package itu.com.CRM.model.enums;

public enum ClosingStatus {
    CLOSED_LOST(0, "ClosedLost"),
    CLOSED_WON(1, "ClosedWon"),
    ON_PROGRESS(2, "OnProgress");

    private final int value;
    private final String description;

    ClosingStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static ClosingStatus fromValue(int value) {
        for (ClosingStatus status : ClosingStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}

