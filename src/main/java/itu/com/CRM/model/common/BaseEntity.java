package itu.com.CRM.model.common;

import java.time.LocalDateTime;

public class BaseEntity implements IHasSequentialId, IHasIsDeleted, IHasAudit {

    private String id;
    private boolean isDeleted;
    private LocalDateTime createdAtUtc;
    private String createdById;
    private LocalDateTime updatedAtUtc;
    private String updatedById;

    public BaseEntity() {
        this.id = generateSequentialGuid();
        this.isDeleted = false;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public LocalDateTime getCreatedAtUtc() {
        return createdAtUtc;
    }

    public void setCreatedAtUtc(LocalDateTime createdAtUtc) {
        this.createdAtUtc = createdAtUtc;
    }

    public String getCreatedById() {
        return createdById;
    }

    public void setCreatedById(String createdById) {
        this.createdById = createdById;
    }

    public LocalDateTime getUpdatedAtUtc() {
        return updatedAtUtc;
    }

    public void setUpdatedAtUtc(LocalDateTime updatedAtUtc) {
        this.updatedAtUtc = updatedAtUtc;
    }

    public String getUpdatedById() {
        return updatedById;
    }

    public void setUpdatedById(String updatedById) {
        this.updatedById = updatedById;
    }

    private String generateSequentialGuid() {
        byte[] guidArray = java.util.UUID.randomUUID().toString().getBytes();

        java.time.LocalDateTime baseDate = java.time.LocalDateTime.of(1900, 1, 1, 0, 0, 0, 0);
        java.time.LocalDateTime now = java.time.LocalDateTime.now();

        java.time.Duration duration = java.time.Duration.between(baseDate, now);
        byte[] daysArray = java.nio.ByteBuffer.allocate(4).putInt((int) duration.toDays()).array();
        byte[] msecsArray = java.nio.ByteBuffer.allocate(4).putInt((int) (duration.toMillis() % 86400000)).array();

        synchronized (this) {
            System.arraycopy(daysArray, daysArray.length - 2, guidArray, guidArray.length - 6, 2);
            System.arraycopy(msecsArray, msecsArray.length - 4, guidArray, guidArray.length - 4, 4);
        }

        return java.util.UUID.nameUUIDFromBytes(guidArray).toString();
    }
}

