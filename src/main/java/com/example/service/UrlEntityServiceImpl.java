package com.example.service;

import cn.hutool.crypto.digest.MD5;
import cn.hutool.log.StaticLog;
import com.example.module.entity.UrlEntity;
import com.example.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.util.Optional;
import java.util.UUID;

/**
 * @ClassName UrlEntityServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 13:04
 * @Version 1.0
 **/
@Service
public class UrlEntityServiceImpl implements UrlEntityService {

    @Autowired
    private UrlRepository urlRepository;
    @Override
    public void save(String type,String url) {
//        String md5 = DigestUtils.md5DigestAsHex(url.getBytes());
        // 查重
        Optional<UrlEntity> byUrl1 = urlRepository.findByUrl(url);
        if (byUrl1.isPresent()){
            StaticLog.info("url重复:  {}  ",url);
            return ;
        }
//        Optional<UrlEntity> byUrl = urlRepository.findByMd5(md5);
//        if (byUrl.isPresent()){
//            StaticLog.info("url重复:  {}  ",url);
//            return ;
//        }
        // 持久层存储
        UrlEntity object = new UrlEntity();
        object
                .setUrlId(UUID.randomUUID().toString())
//                .setMd5(md5)
                .setType(type)
                .setTitle("")
                .setFlag("no")
                .setUrl(url);
        urlRepository.saveAndFlush(object);

    }
}
