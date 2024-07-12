package com.shaohua.hiddenpoint.service.impl;

import com.shaohua.hiddenpoint.repository.ModuleRepository;
import com.shaohua.hiddenpoint.service.ModuleService;
import com.shaohua.hiddenpoint.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModuleServiceImpl implements ModuleService {

    @Autowired
    private ModuleRepository moduleRepository;

    @Override
    public List<ModuleEntity> getAllModules() {
        return moduleRepository.findAll();
    }

    @Override
    public Optional<ModuleEntity> getModuleById(Long id) {
        return moduleRepository.findById(id);
    }

    @Override
    public ModuleEntity createModule(ModuleEntity module) {
        return moduleRepository.save(module);
    }

    @Override
    public ModuleEntity updateModule(Long id, ModuleEntity module) {
        Optional<ModuleEntity> existingModule = moduleRepository.findById(id);
        if (existingModule.isPresent()) {
            ModuleEntity updatedModule = existingModule.get();
            updatedModule.setModuleName(module.getModuleName());
            updatedModule.setModuleIdentifier(module.getModuleIdentifier());
            updatedModule.setModuleOwner(module.getModuleOwner());
            updatedModule.setModuleDesc(module.getModuleDesc());
            updatedModule.setBelongPages(module.getBelongPages());
            updatedModule.setModuleStatus(module.getModuleStatus());
            updatedModule.setTriggerTimes(module.getTriggerTimes());
            updatedModule.setSampleImages(module.getSampleImages());
            updatedModule.setModuleEvents(module.getModuleEvents());
            updatedModule.setCreator(module.getCreator());
            updatedModule.setOnlineDate(module.getOnlineDate());
            updatedModule.setOfflineDate(module.getOfflineDate());
            updatedModule.setGmtModify(module.getGmtModify());
            return moduleRepository.save(updatedModule);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public void deleteModule(Long id) {
        moduleRepository.deleteById(id);
    }
}
