package com.shaohua.hiddenpoint.service;

import com.shaohua.hiddenpoint.entity.ProjectResourceEntity;

import java.util.List;
import java.util.Optional;

public interface ProjectResourceService {
    List<ProjectResourceEntity> getAllProjectResources();
    Optional<ProjectResourceEntity> getProjectResourceById(Long id);
    ProjectResourceEntity createProjectResource(ProjectResourceEntity projectResource);
    ProjectResourceEntity updateProjectResource(Long id, ProjectResourceEntity projectResource);
    void deleteProjectResource(Long id);
}
