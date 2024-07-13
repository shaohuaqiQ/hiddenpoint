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

    @RequestMapping("/getallpages")
    public String getAllPages(Model model) {
        logger.info("Entering getAllPages method");
        List<PageEntity> pageEntities = pageService.getAllPages();
        logger.info("Number of pages retrieved: " + pageEntities.size());
        for (PageEntity pageEntity : pageEntities) {
            logger.info("Page: " + pageEntity.getPageName());
        }
        model.addAttribute("pageEntities", pageEntities);
        return "page/getallpages";
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

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("page", new PageEntity());
        return "page/createpage";
    }

    @PostMapping("/create")
    public String createPage(@ModelAttribute PageEntity page) {
        pageService.createPage(page);
        return "redirect:/pages/getallpages";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<PageEntity> page = pageService.getPageById(id);
        if (page.isPresent()) {
            model.addAttribute("page", page.get());
            return "page/updatepage";
        } else {
            return "redirect:/pages/getallpages";
        }
    }

    @PostMapping("/update/{id}")
    public String updatePage(@PathVariable Long id, @ModelAttribute PageEntity page) {
        pageService.updatePage(id, page);
        return "redirect:/pages/getallpages";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<PageEntity> page = pageService.getPageById(id);
        if (page.isPresent()) {
            model.addAttribute("page", page.get());
            return "page/deletepage";
        } else {
            return "redirect:/pages/getallpages";
        }
    }

    @PostMapping("/delete/{id}")
    public String deletePage(@PathVariable Long id) {
        pageService.deletePage(id);
        return "redirect:/pages/getallpages";
    }
}
