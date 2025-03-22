package itu.com.CRM.model.enums;

public enum LeadActivityType {
    OTHER(0, "Other"),
    PHONE(1, "Phone"),
    EMAIL(2, "Email"),
    SOCILAL_MEDIA(3, "Social Media"),
    MEETING(4, "Meeting"),
    EVENT(5, "Event");

    private final int value;
    private final String description;

    LeadActivityType(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static LeadActivityType fromValue(int value) {
        for (LeadActivityType status : LeadActivityType.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}

