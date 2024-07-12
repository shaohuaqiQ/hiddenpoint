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

@Table(name = "page")
public class PageEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmt_create", nullable = false)
    private LocalDateTime gmtCreate;

    @Column(name = "gmt_modify", nullable = false)
    private LocalDateTime gmtModify;

    @Column(name = "page_name", nullable = false, length = 128)
    private String pageName;

    @Column(name = "page_identifier", nullable = false, length = 64)
    private String pageIdentifier;

    @Column(name = "page_owner", nullable = false, length = 32)
    private String pageOwner;

    @Column(name = "page_desc", length = 128)
    private String pageDesc;

    @Column(name = "page_status", nullable = false, length = 32)
    private String pageStatus;

    @Column(name = "page_type", nullable = false, length = 32)
    private String pageType;

    @Column(name = "trigger_times", nullable = false, length = 64)
    private String triggerTimes;

    @Column(name = "sample_images", length = 512)
    private String sampleImages;

    @Column(name = "creator", nullable = false, length = 32)
    private String creator;

    @Column(name = "online_date")
    private LocalDateTime onlineDate;

    @Column(name = "offline_date")
    private LocalDateTime offlineDate;
}
