package com.shaohua.hiddenpoint.service.impl;

import com.shaohua.hiddenpoint.repository.ProjectResourceRepository;
import com.shaohua.hiddenpoint.service.ProjectResourceService;
import com.shaohua.hiddenpoint.entity.ProjectResourceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectResourceServiceImpl implements ProjectResourceService {

    @Autowired
    private ProjectResourceRepository projectResourceRepository;

    @Override
    public List<ProjectResourceEntity> getAllProjectResources() {
        return projectResourceRepository.findAll();
    }

    @Override
    public Optional<ProjectResourceEntity> getProjectResourceById(Long id) {
        return projectResourceRepository.findById(id);
    }

    @Override
    public ProjectResourceEntity createProjectResource(ProjectResourceEntity projectResource) {
        return projectResourceRepository.save(projectResource);
    }

    @Override
    public ProjectResourceEntity updateProjectResource(Long id, ProjectResourceEntity projectResource) {
        Optional<ProjectResourceEntity> existingProjectResource = projectResourceRepository.findById(id);
        if (existingProjectResource.isPresent()) {
            ProjectResourceEntity updatedProjectResource = existingProjectResource.get();
            updatedProjectResource.setProjectId(projectResource.getProjectId());
            updatedProjectResource.setPageId(projectResource.getPageId());
            updatedProjectResource.setModuleId(projectResource.getModuleId());
            updatedProjectResource.setRelationStatus(projectResource.getRelationStatus());
            updatedProjectResource.setCreator(projectResource.getCreator());
            updatedProjectResource.setOnlineDate(projectResource.getOnlineDate());
            updatedProjectResource.setOfflineDate(projectResource.getOfflineDate());
            updatedProjectResource.setGmtModify(projectResource.getGmtModify());
            return projectResourceRepository.save(updatedProjectResource);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public void deleteProjectResource(Long id) {
        projectResourceRepository.deleteById(id);
    }
}
