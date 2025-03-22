package itu.com.CRM.model.common;
import java.time.LocalDateTime;

public interface IHasAudit {
    LocalDateTime getCreatedAtUtc();
    void setCreatedAtUtc(LocalDateTime createdAtUtc);

    String getCreatedById();
    void setCreatedById(String createdById);

    LocalDateTime getUpdatedAtUtc();
    void setUpdatedAtUtc(LocalDateTime updatedAtUtc);

    String getUpdatedById();
    void setUpdatedById(String updatedById);
}
