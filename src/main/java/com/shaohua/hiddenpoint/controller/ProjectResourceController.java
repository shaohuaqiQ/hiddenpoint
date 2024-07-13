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

    @RequestMapping("/getallresources")
    public String getAllProjectResources(Model model) {
        logger.info("Entering getAllProjectResources method");
        List<ProjectResourceEntity> projectResourceEntities = projectResourceService.getAllProjectResources();
        logger.info("Number of project resources retrieved: " + projectResourceEntities.size());
        for (ProjectResourceEntity projectResourceEntity : projectResourceEntities) {
            logger.info("Project Resource: " + projectResourceEntity.getProjectId());
        }
        model.addAttribute("projectResourceEntities", projectResourceEntities);
        return "projectresource/getallresources";
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

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("projectResource", new ProjectResourceEntity());
        return "projectresource/createprojectresource";
    }

    @PostMapping("/create")
    public String createProjectResource(@ModelAttribute ProjectResourceEntity projectResource) {
        projectResourceService.createProjectResource(projectResource);
        return "redirect:/project-resources/getallresources";
    }

    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable Long id, Model model) {
        Optional<ProjectResourceEntity> projectResource = projectResourceService.getProjectResourceById(id);
        if (projectResource.isPresent()) {
            model.addAttribute("projectResource", projectResource.get());
            return "projectresource/updateprojectresource";
        } else {
            return "redirect:/project-resources/getallresources";
        }
    }

    @PostMapping("/update/{id}")
    public String updateProjectResource(@PathVariable Long id, @ModelAttribute ProjectResourceEntity projectResource) {
        projectResourceService.updateProjectResource(id, projectResource);
        return "redirect:/project-resources/getallresources";
    }

    @GetMapping("/delete/{id}")
    public String showDeleteForm(@PathVariable Long id, Model model) {
        Optional<ProjectResourceEntity> projectResource = projectResourceService.getProjectResourceById(id);
        if (projectResource.isPresent()) {
            model.addAttribute("projectResource", projectResource.get());
            return "projectresource/deleteprojectresource";
        } else {
            return "redirect:/project-resources/getallresources";
        }
    }

    @PostMapping("/delete/{id}")
    public String deleteProjectResource(@PathVariable Long id) {
        projectResourceService.deleteProjectResource(id);
        return "redirect:/project-resources/getallresources";
    }
}
