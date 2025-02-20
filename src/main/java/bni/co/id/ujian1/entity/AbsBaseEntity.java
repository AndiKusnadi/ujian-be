package bni.co.id.ujian1.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Version;

import java.time.LocalDateTime;

public abstract class AbsBaseEntity {
    @Version
    private Integer version;

    @Column(name = "created_time")
    private LocalDateTime createdTime;
}
