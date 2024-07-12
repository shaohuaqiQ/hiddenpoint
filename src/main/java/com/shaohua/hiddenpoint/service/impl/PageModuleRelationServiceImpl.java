package com.shaohua.hiddenpoint.service.impl;

import com.shaohua.hiddenpoint.repository.PageModuleRelationRepository;
import com.shaohua.hiddenpoint.service.PageModuleRelationService;
import com.shaohua.hiddenpoint.entity.PageModuleRelationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageModuleRelationServiceImpl implements PageModuleRelationService {

    @Autowired
    private PageModuleRelationRepository pageModuleRelationRepository;

    @Override
    public List<PageModuleRelationEntity> getAllPageModuleRelations() {
        return pageModuleRelationRepository.findAll();
    }

    @Override
    public Optional<PageModuleRelationEntity> getPageModuleRelationById(Long id) {
        return pageModuleRelationRepository.findById(id);
    }

    @Override
    public PageModuleRelationEntity createPageModuleRelation(PageModuleRelationEntity pageModuleRelation) {
        return pageModuleRelationRepository.save(pageModuleRelation);
    }

    @Override
    public PageModuleRelationEntity updatePageModuleRelation(Long id, PageModuleRelationEntity pageModuleRelation) {
        Optional<PageModuleRelationEntity> existingPageModuleRelation = pageModuleRelationRepository.findById(id);
        if (existingPageModuleRelation.isPresent()) {
            PageModuleRelationEntity updatedPageModuleRelation = existingPageModuleRelation.get();
            updatedPageModuleRelation.setPageId(pageModuleRelation.getPageId());
            updatedPageModuleRelation.setModuleId(pageModuleRelation.getModuleId());
            updatedPageModuleRelation.setRelationStatus(pageModuleRelation.getRelationStatus());
            updatedPageModuleRelation.setCreator(pageModuleRelation.getCreator());
            updatedPageModuleRelation.setOnlineDate(pageModuleRelation.getOnlineDate());
            updatedPageModuleRelation.setOfflineDate(pageModuleRelation.getOfflineDate());
            updatedPageModuleRelation.setGmtModify(pageModuleRelation.getGmtModify());
            return pageModuleRelationRepository.save(updatedPageModuleRelation);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public void deletePageModuleRelation(Long id) {
        pageModuleRelationRepository.deleteById(id);
    }
}
