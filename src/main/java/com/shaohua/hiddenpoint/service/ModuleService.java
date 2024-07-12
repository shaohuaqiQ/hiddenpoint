package com.shaohua.hiddenpoint.service;

import com.shaohua.hiddenpoint.entity.ModuleEntity;

import java.util.List;
import java.util.Optional;

public interface ModuleService {
    List<ModuleEntity> getAllModules();
    Optional<ModuleEntity> getModuleById(Long id);
    ModuleEntity createModule(ModuleEntity module);
    ModuleEntity updateModule(Long id, ModuleEntity module);
    void deleteModule(Long id);
}
