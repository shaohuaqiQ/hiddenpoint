package com.shaohua.hiddenpoint.service;

import com.shaohua.hiddenpoint.entity.PageEntity;

import java.util.List;
import java.util.Optional;

public interface PageService {
    List<PageEntity> getAllPages();
    Optional<PageEntity> getPageById(Long id);
    PageEntity createPage(PageEntity page);
    PageEntity updatePage(Long id, PageEntity page);
    void deletePage(Long id);
}
