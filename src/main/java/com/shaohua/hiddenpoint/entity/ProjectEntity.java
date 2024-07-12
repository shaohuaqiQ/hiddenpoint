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

@Table(name = "project")
public class ProjectEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmt_create", nullable = false)
    private LocalDateTime gmtCreate;

    @Column(name = "gmt_modify", nullable = false)
    private LocalDateTime gmtModify;

    @Column(name = "project_name", nullable = false, length = 128)
    private String projectName;

    @Column(name = "project_desc", length = 256)
    private String projectDesc;

    @Column(name = "project_url", length = 128)
    private String projectUrl;

    @Column(name = "project_status", length = 32, nullable = false)
    private String projectStatus;

    @Column(name = "project_owner", length = 128, nullable = false)
    private String projectOwner;

    @Column(name = "creator", length = 32, nullable = false)
    private String creator;

    @Column(name = "online_date")
    private LocalDateTime onlineDate;

    @Column(name = "offline_date")
    private LocalDateTime offlineDate;
}
