package com.shaohua.hiddenpoint.service.impl;

import com.shaohua.hiddenpoint.repository.ProjectRepository;
import com.shaohua.hiddenpoint.service.ProjectService;
import com.shaohua.hiddenpoint.entity.ProjectEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public List<ProjectEntity> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<ProjectEntity> getProjectById(Long id) {
        return projectRepository.findById(id);
    }

    @Override
    public ProjectEntity createProject(ProjectEntity project) {
        return projectRepository.save(project);
    }

    @Override
    public ProjectEntity updateProject(Long id, ProjectEntity project) {
        Optional<ProjectEntity> existingProject = projectRepository.findById(id);
        if (existingProject.isPresent()) {
            ProjectEntity updatedProject = existingProject.get();
            updatedProject.setProjectName(project.getProjectName());
            updatedProject.setProjectDesc(project.getProjectDesc());
            updatedProject.setProjectUrl(project.getProjectUrl());
            updatedProject.setProjectStatus(project.getProjectStatus());
            updatedProject.setProjectOwner(project.getProjectOwner());
            updatedProject.setCreator(project.getCreator());
            updatedProject.setOnlineDate(project.getOnlineDate());
            updatedProject.setOfflineDate(project.getOfflineDate());
            updatedProject.setGmtModify(project.getGmtModify());
            return projectRepository.save(updatedProject);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
}
