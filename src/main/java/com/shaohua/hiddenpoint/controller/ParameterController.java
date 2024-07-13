package com.shaohua.hiddenpoint.controller;

import com.shaohua.hiddenpoint.entity.ParameterEntity;
import com.shaohua.hiddenpoint.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/parameters")
public class ParameterController {

    private static final Logger logger = Logger.getLogger(ParameterController.class.getName());

    @Autowired
    private ParameterService parameterService;

    @RequestMapping("/getallparameters")
    public String getAllParameters(Model model) {
        logger.info("Entering getAllParameters method");
        List<ParameterEntity> parameterEntities = parameterService.getAllParameters();
        logger.info("Number of parameters retrieved: " + parameterEntities.size());
        for (ParameterEntity parameterEntity : parameterEntities) {
            logger.info("Parameter: " + parameterEntity.getParameterName());
        }
        model.addAttribute("parameterEntities", parameterEntities);
        return "parameter/getallparameters";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ParameterEntity> getParameterById(@PathVariable Long id) {
        Optional<ParameterEntity> parameter = parameterService.getParameterById(id);
        if (parameter.isPresent()) {
            return ResponseEntity.ok(parameter.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("parameter", new ParameterEntity());
        return "parameter/createparameter";
    }

    @PostMapping("/create")
    public String createParameter(@ModelAttribute ParameterEntity parameter) {
        parameterService.createParameter(parameter);
        return "redirect:/parameters/getallparameters";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<ParameterEntity> parameter = parameterService.getParameterById(id);
        if (parameter.isPresent()) {
            model.addAttribute("parameter", parameter.get());
            return "parameter/updateparameter";
        } else {
            return "redirect:/parameters/getallparameters";
        }
    }

    @PostMapping("/update/{id}")
    public String updateParameter(@PathVariable Long id, @ModelAttribute ParameterEntity parameter) {
        parameterService.updateParameter(id, parameter);
        return "redirect:/parameters/getallparameters";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<ParameterEntity> parameter = parameterService.getParameterById(id);
        if (parameter.isPresent()) {
            model.addAttribute("parameter", parameter.get());
            return "parameter/deleteparameter";
        } else {
            return "redirect:/parameters/getallparameters";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteParameter(@PathVariable Long id) {
        parameterService.deleteParameter(id);
        return "redirect:/parameters/getallparameters";
    }
}
