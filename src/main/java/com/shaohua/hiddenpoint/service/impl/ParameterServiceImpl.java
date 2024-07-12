package com.shaohua.hiddenpoint.service.impl;

import com.shaohua.hiddenpoint.repository.ParameterRepository;
import com.shaohua.hiddenpoint.service.ParameterService;
import com.shaohua.hiddenpoint.entity.ParameterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ParameterServiceImpl implements ParameterService {

    @Autowired
    private ParameterRepository parameterRepository;

    @Override
    public List<ParameterEntity> getAllParameters() {
        return parameterRepository.findAll();
    }

    @Override
    public Optional<ParameterEntity> getParameterById(Long id) {
        return parameterRepository.findById(id);
    }

    @Override
    public ParameterEntity createParameter(ParameterEntity parameter) {
        return parameterRepository.save(parameter);
    }

    @Override
    public ParameterEntity updateParameter(Long id, ParameterEntity parameter) {
        Optional<ParameterEntity> existingParameter = parameterRepository.findById(id);
        if (existingParameter.isPresent()) {
            ParameterEntity updatedParameter = existingParameter.get();
            updatedParameter.setParameterName(parameter.getParameterName());
            updatedParameter.setParameterDesc(parameter.getParameterDesc());
            updatedParameter.setParameterValue(parameter.getParameterValue());
            updatedParameter.setParameterStatus(parameter.getParameterStatus());
            updatedParameter.setParameterType(parameter.getParameterType());
            updatedParameter.setParameterOwner(parameter.getParameterOwner());
            updatedParameter.setCreator(parameter.getCreator());
            updatedParameter.setGmtModify(parameter.getGmtModify());
            return parameterRepository.save(updatedParameter);
        } else {
            return null; // Or throw an exception
        }
    }

    @Override
    public void deleteParameter(Long id) {
        parameterRepository.deleteById(id);
    }
}
