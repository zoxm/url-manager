package com.example.service;

import com.example.module.entity.IndustryEntity;
import org.jsoup.nodes.Document;


/**
 * @ClassName HuodongjiaUrlParserService
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 12:04
 * @Version 1.0
 **/

public interface HuodongjiaUrlParserService {
    String parser(IndustryEntity industryEntity);
    String parserFlush(IndustryEntity industryEntity);
    void parserAllIndustry(Document document);
}
