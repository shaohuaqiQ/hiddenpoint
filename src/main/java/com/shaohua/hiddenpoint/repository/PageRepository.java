package com.shaohua.hiddenpoint.repository;

import com.shaohua.hiddenpoint.entity.PageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PageRepository extends JpaRepository<PageEntity, Long> {
}
