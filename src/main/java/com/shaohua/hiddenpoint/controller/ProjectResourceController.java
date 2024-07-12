package com.shaohua.hiddenpoint.controller;

import com.shaohua.hiddenpoint.entity.ProjectResourceEntity;
import com.shaohua.hiddenpoint.service.ProjectResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/project-resources")
public class ProjectResourceController {

    private static final Logger logger = Logger.getLogger(ProjectResourceController.class.getName());

    @Autowired
    private ProjectResourceService projectResourceService;

    @RequestMapping
    public String getAllProjectResources(Model model) {
        logger.info("Entering getAllProjectResources method");
        List<ProjectResourceEntity> projectResourceEntities = projectResourceService.getAllProjectResources();
        logger.info("Number of project resources retrieved: " + projectResourceEntities.size());
        for (ProjectResourceEntity projectResourceEntity : projectResourceEntities) {
            logger.info("Project Resource: " + projectResourceEntity.getProjectId());
        }
        model.addAttribute("projectResourceEntities", projectResourceEntities);
        return "project-resources";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProjectResourceEntity> getProjectResourceById(@PathVariable Long id) {
        Optional<ProjectResourceEntity> projectResource = projectResourceService.getProjectResourceById(id);
        if (projectResource.isPresent()) {
            return ResponseEntity.ok(projectResource.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
