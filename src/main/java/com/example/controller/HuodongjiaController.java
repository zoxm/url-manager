package com.example.controller;

import cn.hutool.log.StaticLog;
import com.example.module.entity.IndustryEntity;
import com.example.service.base.DocumentService;
import com.example.service.HuodongjiaUrlParserService;
import com.example.service.IndustryEntityService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @ClassName HuoDongXingController
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-13 12:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("huodongjia")
public class HuodongjiaController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private HuodongjiaUrlParserService huodongjiaUrlParserService;

    @Autowired
    private IndustryEntityService industryEntityService;


    private static final String URL = "https://www.huodongjia.com/";

//    @RequestMapping("{relativeUrl}")
//    public String huodongjia(@PathVariable("relativeUrl")String relativeUrl){
//
//        // 获取行业进行存储
//        industryEntityService.checkAndSave(relativeUrl);
//        List<IndustryEntity> all = industryEntityService.findAll();
//        all.forEach(industryEntity -> {
//            int pageCount = 1;
//            while (true){
//                // 抓取
//                Document document = documentService.getDocument(URL+industryEntity.getName()+"/page-"+pageCount+"/");
//                StaticLog.info("正在采集:  https://www.huodongjia.com/{}/page-{}  ", relativeUrl,pageCount);
//                // 解析和存储
//                try {
//                    huodongjiaUrlParserService.parser(document);
//                    ++pageCount;
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                if (pageCount > 4000) break;
//            }
//        });
//        return "网址："+URL+relativeUrl+"/ "+"采集完毕";
//    }

    /**
     * 功能描述: <br>
     * 〈采集标签 industryEntity〉
     *
     * @Param: []
     * @Return: java.lang.String
     * @Author: miaoyi
     * @Date: 2020-04-02 15:33
     */
    @RequestMapping("plan0")
    public String plan0() {
        // 首先找到所有标签选项
        Document document = documentService.getDocument("https://www.huodongjia.com/business/");
        StaticLog.info("获取标签: wget   https://www.huodongjia.com/business/");
        huodongjiaUrlParserService.parserAllIndustry(document);
        return "网址：" + URL + "/ " + "采集完毕";
    }


    /**
     * 功能描述: <br>
     * 〈根据 相对路径+页码+采集〉
     *
     * @Param: [relativeUrl]
     * @Return: java.lang.String
     * @Author: miaoyi
     * @Date: 2020-04-02 16:50
     */
    @RequestMapping("plan1")
    public String planX() {
        List<IndustryEntity> industryEntityList = industryEntityService.findAll();
        int errnoCount = 0;

        try {
            for (IndustryEntity industryEntity : industryEntityList) {
                if (industryEntity.getDone() >= industryEntity.getMaxPage()) {
                    StaticLog.info("已经是最大页码:  {}page-{}  ", industryEntity.getHref(), industryEntity.getMaxPage());
                    continue;
                }
                huodongjiaUrlParserService.parser(industryEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            errnoCount++;
            StaticLog.info("ERRNO:  报{}个错啦", errnoCount);
            StaticLog.info("ERRNO:  {}", e.toString());
        }


        return "ok";
    }

    @RequestMapping("plan2")
    public String planZ() {
        List<IndustryEntity> industryEntityList = industryEntityService.findAll();
        int errnoCount = 0;
        try {
            for (IndustryEntity industryEntity : industryEntityList) {
                huodongjiaUrlParserService.parserFlush(industryEntity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            errnoCount++;
            StaticLog.info("ERRNO:  报{}个错啦", errnoCount);
            StaticLog.info("ERRNO:  {}", e.toString());
        }

        return "ok";
    }

}
