package com.shaohua.hiddenpoint.repository;

import com.shaohua.hiddenpoint.entity.PageModuleRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageModuleRelationRepository extends JpaRepository<PageModuleRelationEntity, Long> {
}
