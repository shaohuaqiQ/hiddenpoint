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

    @RequestMapping("/getallmodules")
    public String getAllModules(Model model) {
        logger.info("Entering getAllModules method");
        List<ModuleEntity> moduleEntities = moduleService.getAllModules();
        logger.info("Number of modules retrieved: " + moduleEntities.size());
        for (ModuleEntity moduleEntity : moduleEntities) {
            logger.info("Module: " + moduleEntity.getModuleName());
        }
        model.addAttribute("moduleEntities", moduleEntities);
        return "module/getallmodules";
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

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("module", new ModuleEntity());
        return "module/createmodule";
    }

    @PostMapping("/create")
    public String createModule(@ModelAttribute ModuleEntity module) {
        moduleService.createModule(module);
        return "redirect:/modules/getallmodules";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<ModuleEntity> module = moduleService.getModuleById(id);
        if (module.isPresent()) {
            model.addAttribute("module", module.get());
            return "module/updatemodule";
        } else {
            return "redirect:/modules/getallmodules";
        }
    }

    @PostMapping("/update/{id}")
    public String updateModule(@PathVariable Long id, @ModelAttribute ModuleEntity module) {
        moduleService.updateModule(id, module);
        return "redirect:/modules/getallmodules";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<ModuleEntity> module = moduleService.getModuleById(id);
        if (module.isPresent()) {
            model.addAttribute("module", module.get());
            return "module/deletemodule";
        } else {
            return "redirect:/modules/getallmodules";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteModule(@PathVariable Long id) {
        moduleService.deleteModule(id);
        return "redirect:/modules/getallmodules";
    }
}
