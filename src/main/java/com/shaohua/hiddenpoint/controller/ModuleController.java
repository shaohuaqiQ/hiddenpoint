package com.shaohua.hiddenpoint.controller;

import com.shaohua.hiddenpoint.entity.ModuleEntity;
import com.shaohua.hiddenpoint.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/modules")
public class ModuleController {

    private static final Logger logger = Logger.getLogger(ModuleController.class.getName());

    @Autowired
    private ModuleService moduleService;

    @RequestMapping
    public String getAllModules(Model model) {
        logger.info("Entering getAllModules method");
        List<ModuleEntity> moduleEntities = moduleService.getAllModules();
        logger.info("Number of modules retrieved: " + moduleEntities.size());
        for (ModuleEntity moduleEntity : moduleEntities) {
            logger.info("Module: " + moduleEntity.getModuleName());
        }
        model.addAttribute("moduleEntities", moduleEntities);
        return "modules";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ModuleEntity> getModuleById(@PathVariable Long id) {
        Optional<ModuleEntity> module = moduleService.getModuleById(id);
        if (module.isPresent()) {
            return ResponseEntity.ok(module.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
