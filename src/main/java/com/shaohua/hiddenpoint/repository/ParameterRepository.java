package com.shaohua.hiddenpoint.repository;

import com.shaohua.hiddenpoint.entity.ParameterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<ParameterEntity, Long> {
}
