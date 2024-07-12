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
@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "module")
public class ModuleEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmt_create", nullable = false)
    private LocalDateTime gmtCreate;

    @Column(name = "gmt_modify", nullable = false)
    private LocalDateTime gmtModify;

    @Column(name = "module_name", nullable = false, length = 128)
    private String moduleName;

    @Column(name = "module_identifier", nullable = false, length = 64)
    private String moduleIdentifier;

    @Column(name = "module_owner", nullable = false, length = 32)
    private String moduleOwner;

    @Column(name = "module_desc", length = 128)
    private String moduleDesc;

    @Column(name = "belong_pages", nullable = false, length = 256)
    private String belongPages;

    @Column(name = "module_status", nullable = false, length = 32)
    private String moduleStatus;

    @Column(name = "trigger_times", nullable = false, length = 64)
    private String triggerTimes;

    @Column(name = "sample_images", length = 512)
    private String sampleImages;

    @Column(name = "module_events", length = 2048)
    private String moduleEvents;

    @Column(name = "creator", nullable = false, length = 32)
    private String creator;

    @Column(name = "online_date")
    private LocalDateTime onlineDate;

    @Column(name = "offline_date")
    private LocalDateTime offlineDate;
}
