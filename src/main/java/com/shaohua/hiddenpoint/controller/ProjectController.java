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

    @RequestMapping("/getallprojects")
    public String getAllProjects(Model model) {
        logger.info("Entering getAllProjects method");
        List<ProjectEntity> projectEntities = projectService.getAllProjects();
        logger.info("Number of projects retrieved: " + projectEntities.size());
        for (ProjectEntity projectEntity : projectEntities) {
            logger.info("Project: " + projectEntity.getProjectName());
        }
        model.addAttribute("projectEntities", projectEntities);
        return "project/getallprojects";
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

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("project", new ProjectEntity());
        return "project/createproject";
    }

    @PostMapping("/create")
    public String createProject(@ModelAttribute ProjectEntity project) {
        projectService.createProject(project);
        return "redirect:/projects/getallprojects";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<ProjectEntity> project = projectService.getProjectById(id);
        if (project.isPresent()) {
            model.addAttribute("project", project.get());
            return "project/updateproject";
        } else {
            return "redirect:/projects/getallprojects";
        }
    }

    @PostMapping("/update/{id}")
    public String updateProject(@PathVariable Long id, @ModelAttribute ProjectEntity project) {
        projectService.updateProject(id, project);
        return "redirect:/projects/getallprojects";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<ProjectEntity> project = projectService.getProjectById(id);
        if (project.isPresent()) {
            model.addAttribute("project", project.get());
            return "project/deleteproject";
        } else {
            return "redirect:/projects/getallprojects";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteProject(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "redirect:/projects/getallprojects";
    }
}
