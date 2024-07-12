package com.shaohua.hiddenpoint.controller;

import com.shaohua.hiddenpoint.entity.PageModuleRelationEntity;
import com.shaohua.hiddenpoint.service.PageModuleRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/page-module-relations")
public class PageModuleRelationController {

    private static final Logger logger = Logger.getLogger(PageModuleRelationController.class.getName());

    @Autowired
    private PageModuleRelationService pageModuleRelationService;

    @RequestMapping
    public String getAllPageModuleRelations(Model model) {
        logger.info("Entering getAllPageModuleRelations method");
        List<PageModuleRelationEntity> pageModuleRelationEntities = pageModuleRelationService.getAllPageModuleRelations();
        logger.info("Number of page-module-relations retrieved: " + pageModuleRelationEntities.size());
        model.addAttribute("pageModuleRelationEntities", pageModuleRelationEntities);
        return "page-module-relations";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PageModuleRelationEntity> getPageModuleRelationById(@PathVariable Long id) {
        Optional<PageModuleRelationEntity> pageModuleRelation = pageModuleRelationService.getPageModuleRelationById(id);
        if (pageModuleRelation.isPresent()) {
            return ResponseEntity.ok(pageModuleRelation.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
