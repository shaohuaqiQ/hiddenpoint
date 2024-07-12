package com.shaohua.hiddenpoint.repository;

import com.shaohua.hiddenpoint.entity.ProjectResourceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectResourceRepository extends JpaRepository<ProjectResourceEntity, Long> {
}
