package itu.com.CRM.model.enums;

public enum PipelineStage {
    PROSPECTING(0, "1. Prospecting"),
    QUALIFICATION(1, "2. Qualification"),
    NEED_ANALYSIS(2, "3. NeedAnalysis"),
    PROPOSAL(3, "4. Proposal"),
    NEGOTIATION(4, "5. Negotiation"),
    DECISION_MAKING(5, "6. DecisionMaking"),
    CLOSED(6, "7. Closed");

    private final int value;
    private final String description;

    PipelineStage(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    public static PipelineStage fromValue(int value) {
        for (PipelineStage status : PipelineStage.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unexpected value: " + value);
    }
}

