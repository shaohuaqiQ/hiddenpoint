package com.shaohua.hiddenpoint.controller;

import com.shaohua.hiddenpoint.entity.ProjectEntity;
import com.shaohua.hiddenpoint.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    private static final Logger logger = Logger.getLogger(ProjectController.class.getName());

    @Autowired
    private ProjectService projectService;

    @RequestMapping
    public String getAllProjects(Model model) {
        logger.info("Entering getAllProjects method");
        List<ProjectEntity> projectEntities = projectService.getAllProjects();
        logger.info("Number of projects retrieved: " + projectEntities.size());
        for (ProjectEntity projectEntity : projectEntities) {
            logger.info("Project: " + projectEntity.getProjectName());
        }
        model.addAttribute("projectEntities", projectEntities);
        return "projects";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity<ProjectEntity> getProjectById(@PathVariable Long id) {
        Optional<ProjectEntity> project = projectService.getProjectById(id);
        if (project.isPresent()) {
            return ResponseEntity.ok(project.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
