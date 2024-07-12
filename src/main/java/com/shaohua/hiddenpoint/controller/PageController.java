package com.shaohua.hiddenpoint.controller;

import com.shaohua.hiddenpoint.entity.PageEntity;
import com.shaohua.hiddenpoint.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/pages")
public class PageController {

    private static final Logger logger = Logger.getLogger(PageController.class.getName());

    @Autowired
    private PageService pageService;

    @RequestMapping
    public String getAllPages(Model model) {
        logger.info("Entering getAllPages method");
        List<PageEntity> pageEntities = pageService.getAllPages();
        logger.info("Number of pages retrieved: " + pageEntities.size());
        for (PageEntity pageEntity : pageEntities) {
            logger.info("Page: " + pageEntity.getPageName());
        }
        model.addAttribute("pageEntities", pageEntities);
        return "pages";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<PageEntity> getPageById(@PathVariable Long id) {
        Optional<PageEntity> page = pageService.getPageById(id);
        if (page.isPresent()) {
            return ResponseEntity.ok(page.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
