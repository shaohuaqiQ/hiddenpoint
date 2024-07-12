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
@Table(name = "parameter")
public class ParameterEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "gmt_create", nullable = false)
    private LocalDateTime gmtCreate;

    @Column(name = "gmt_modify", nullable = false)
    private LocalDateTime gmtModify;

    @Column(name = "parameter_name", nullable = false, length = 128)
    private String parameterName;

    @Column(name = "parameter_desc", length = 256)
    private String parameterDesc;

    @Column(name = "parameter_value", nullable = false, length = 1024)
    private String parameterValue;

    @Column(name = "parameter_status", nullable = false, length = 32)
    private String parameterStatus;

    @Column(name = "parameter_type", nullable = false, length = 32)
    private String parameterType;

    @Column(name = "parameter_owner", nullable = false, length = 32)
    private String parameterOwner;

    @Column(name = "creator", nullable = false, length = 32)
    private String creator;
}
