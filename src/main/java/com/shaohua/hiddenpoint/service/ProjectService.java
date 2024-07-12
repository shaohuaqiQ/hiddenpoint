package com.shaohua.hiddenpoint.service;

import com.shaohua.hiddenpoint.entity.ProjectEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<ProjectEntity> getAllProjects();
    Optional<ProjectEntity> getProjectById(Long id);
    ProjectEntity createProject(ProjectEntity project);
    ProjectEntity updateProject(Long id, ProjectEntity project);
    void deleteProject(Long id);
}
