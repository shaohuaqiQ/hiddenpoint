package com.shaohua.hiddenpoint.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "event")
public class EventEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmt_create", nullable = false)
    private LocalDateTime gmtCreate;

    @Column(name = "gmt_modify", nullable = false)
    private LocalDateTime gmtModify;

    @Column(name = "event_id", length = 128)
    private String eventId;

    @Column(name = "event_name", length = 128)
    private String eventName;

    @Column(name = "event_source", length = 128)
    private String eventSource;

    @Column(name = "event_type", length = 128)
    private String eventType;

    @Column(name = "event_status", nullable = false, length = 32)
    private String eventStatus;

    @Column(name = "event_trigger_when", length = 512)
    private String eventTriggerWhen;

    @Column(name = "creator", nullable = false, length = 32)
    private String creator;

    @Column(name = "online_date")
    private LocalDateTime onlineDate;

    @Column(name = "offline_date")
    private LocalDateTime offlineDate;
}
