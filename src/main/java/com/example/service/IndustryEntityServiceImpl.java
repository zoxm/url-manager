package com.example.service;

import cn.hutool.log.StaticLog;
import com.example.module.entity.IndustryEntity;
import com.example.repository.IndustryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @ClassName IndustryEntityService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:03
 * @Version 1.0
 **/

@Service
public class IndustryEntityServiceImpl implements IndustryEntityService{

    @Autowired
    private IndustryRepository industryRepository;

    @Override
    public void checkAndSave(IndustryEntity industryEntity) {
        // 查重
        Optional<IndustryEntity> byName = industryRepository.findIndustryEntityByHref(industryEntity.getHref());
        if (byName.isPresent()){
            StaticLog.info("industry重复:  {}  ", industryEntity.getHref());
            return;
        }
        industryRepository.saveAndFlush(industryEntity);

    }


    @Override
    public List<IndustryEntity> findAll() {
        List<IndustryEntity> all = industryRepository.findAll();
        return all;
    }

    @Override
    public void update(IndustryEntity industryEntity) {
        industryRepository.updateById(industryEntity.getDone(),industryEntity.getMaxPage(),industryEntity.getId());
    }
}
