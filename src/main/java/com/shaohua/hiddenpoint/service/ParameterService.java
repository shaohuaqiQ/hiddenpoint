package com.shaohua.hiddenpoint.service;

import com.shaohua.hiddenpoint.entity.ParameterEntity;

import java.util.List;
import java.util.Optional;

public interface ParameterService {
    List<ParameterEntity> getAllParameters();
    Optional<ParameterEntity> getParameterById(Long id);
    ParameterEntity createParameter(ParameterEntity parameter);
    ParameterEntity updateParameter(Long id, ParameterEntity parameter);
    void deleteParameter(Long id);
}
