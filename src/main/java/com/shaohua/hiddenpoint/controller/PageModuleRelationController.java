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

    @RequestMapping("/getallrelations")
    public String getAllPageModuleRelations(Model model) {
        logger.info("Entering getAllPageModuleRelations method");
        List<PageModuleRelationEntity> pageModuleRelationEntities = pageModuleRelationService.getAllPageModuleRelations();
        logger.info("Number of page-module-relations retrieved: " + pageModuleRelationEntities.size());
        model.addAttribute("pageModuleRelationEntities", pageModuleRelationEntities);
        return "pagemodulerelation/getallrelations";
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

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("pageModuleRelation", new PageModuleRelationEntity());
        return "pagemodulerelation/createpagemodulerelation";
    }

    @PostMapping("/create")
    public String createPageModuleRelation(@ModelAttribute PageModuleRelationEntity pageModuleRelation) {
        pageModuleRelationService.createPageModuleRelation(pageModuleRelation);
        return "redirect:/page-module-relations/getallrelations";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<PageModuleRelationEntity> pageModuleRelation = pageModuleRelationService.getPageModuleRelationById(id);
        if (pageModuleRelation.isPresent()) {
            model.addAttribute("pageModuleRelation", pageModuleRelation.get());
            return "pagemodulerelation/updatepagemodulerelation";
        } else {
            return "redirect:/page-module-relations/getallrelations";
        }
    }

    @PostMapping("/update/{id}")
    public String updatePageModuleRelation(@PathVariable Long id, @ModelAttribute PageModuleRelationEntity pageModuleRelation) {
        pageModuleRelationService.updatePageModuleRelation(id, pageModuleRelation);
        return "redirect:/page-module-relations/getallrelations";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<PageModuleRelationEntity> pageModuleRelation = pageModuleRelationService.getPageModuleRelationById(id);
        if (pageModuleRelation.isPresent()) {
            model.addAttribute("pageModuleRelation", pageModuleRelation.get());
            return "pagemodulerelation/deletepagemodulerelation";
        } else {
            return "redirect:/page-module-relations/getallrelations";
        }
    }

    @PostMapping("/delete/{id}")
    public String deletePageModuleRelation(@PathVariable Long id) {
        pageModuleRelationService.deletePageModuleRelation(id);
        return "redirect:/page-module-relations/getallrelations";
    }
}
