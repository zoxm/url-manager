package com.example.service;

import com.example.module.entity.IndustryEntity;

import java.util.List;

/**
 * @ClassName IndustryEntityService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:03
 * @Version 1.0
 **/

public interface IndustryEntityService {

    void checkAndSave(IndustryEntity industryEntity);
    List<IndustryEntity> findAll();

    void update(IndustryEntity industryEntity);

}
