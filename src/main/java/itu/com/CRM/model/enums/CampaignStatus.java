package itu.com.CRM.model.enums;

public enum CampaignStatus {
    DRAFT(0, "Draft"),
    CANCELLED(1, "Cancelled"),
    CONFIRMED(2, "Confirmed"),
    ON_PROGRESS(3, "OnProgress"),
    ON_HOLD(4, "OnHold"),
    FINISHED(5, "Finished"),
    ARCHIVED(6, "Archived");

    private final int value;
    private final String description;

    CampaignStatus(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static CampaignStatus fromValue(int value) {
        for (CampaignStatus status : CampaignStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}

