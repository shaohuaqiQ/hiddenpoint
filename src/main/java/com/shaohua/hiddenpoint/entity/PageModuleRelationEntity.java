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
@Table(name = "page_module_relation")
public class PageModuleRelationEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmt_create", nullable = false)
    private LocalDateTime gmtCreate;

    @Column(name = "gmt_modify", nullable = false)
    private LocalDateTime gmtModify;

    @Column(name = "page_id", nullable = false)
    private Long pageId;

    @Column(name = "module_id", nullable = false)
    private Long moduleId;

    @Column(name = "relation_status", nullable = false, length = 32)
    private String relationStatus;

    @Column(name = "creator", nullable = false, length = 32)
    private String creator;

    @Column(name = "online_date")
    private LocalDateTime onlineDate;

    @Column(name = "offline_date")
    private LocalDateTime offlineDate;
}
