package com.shaohua.hiddenpoint.service.impl;

import com.shaohua.hiddenpoint.repository.PageRepository;
import com.shaohua.hiddenpoint.service.PageService;
import com.shaohua.hiddenpoint.entity.PageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PageServiceImpl implements PageService {

    @Autowired
    private PageRepository pageRepository;

    @Override
    public List<PageEntity> getAllPages() {
        return pageRepository.findAll();
    }

    @Override
    public Optional<PageEntity> getPageById(Long id) {
        return pageRepository.findById(id);
    }

    @Override
    public PageEntity createPage(PageEntity page) {
        return pageRepository.save(page);
    }

    @Override
    public PageEntity updatePage(Long id, PageEntity page) {
        Optional<PageEntity> existingPage = pageRepository.findById(id);
        if (existingPage.isPresent()) {
            PageEntity updatedPage = existingPage.get();
            updatedPage.setPageName(page.getPageName());
            updatedPage.setPageIdentifier(page.getPageIdentifier());
            updatedPage.setPageOwner(page.getPageOwner());
            updatedPage.setPageDesc(page.getPageDesc());
            updatedPage.setPageStatus(page.getPageStatus());
            updatedPage.setPageType(page.getPageType());
            updatedPage.setTriggerTimes(page.getTriggerTimes());
            updatedPage.setSampleImages(page.getSampleImages());
            updatedPage.setCreator(page.getCreator());
            updatedPage.setOnlineDate(page.getOnlineDate());
            updatedPage.setOfflineDate(page.getOfflineDate());
            updatedPage.setGmtModify(page.getGmtModify());
            return pageRepository.save(updatedPage);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public void deletePage(Long id) {
        pageRepository.deleteById(id);
    }
}
