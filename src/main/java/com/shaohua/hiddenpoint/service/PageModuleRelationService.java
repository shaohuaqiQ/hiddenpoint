package com.shaohua.hiddenpoint.service;

import com.shaohua.hiddenpoint.entity.PageModuleRelationEntity;

import java.util.List;
import java.util.Optional;

public interface PageModuleRelationService {
    List<PageModuleRelationEntity> getAllPageModuleRelations();
    Optional<PageModuleRelationEntity> getPageModuleRelationById(Long id);
    PageModuleRelationEntity createPageModuleRelation(PageModuleRelationEntity pageModuleRelation);
    PageModuleRelationEntity updatePageModuleRelation(Long id, PageModuleRelationEntity pageModuleRelation);
    void deletePageModuleRelation(Long id);
}
