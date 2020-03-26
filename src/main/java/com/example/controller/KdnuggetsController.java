package com.example.controller;

import cn.hutool.log.StaticLog;
import com.example.service.HuodongjiaUrlParserService;
import com.example.service.KdnuggetsUrlParserService;
import com.example.service.getDocumentService;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HuoDongXingController
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-13 12:51
 * @Version 1.0
 **/
@RestController
@RequestMapping("kdnuggets")
public class KdnuggetsController {

    @Autowired
    private getDocumentService getDocumentService;

    @Autowired
    private KdnuggetsUrlParserService kdnuggetsUrlParserService;

    private static final String URL = "https://www.kdnuggets.com/meetings/";

    @RequestMapping("{relativeUrl}")
    public String kdnuggets(@PathVariable("relativeUrl")String relativeUrl){
        System.out.println("采集url============================================"+URL + relativeUrl);
        // 抓取
        Document document = getDocumentService.getDocument(URL+relativeUrl);
        // 解析和存储
        kdnuggetsUrlParserService.parser(document);
        return "网址："+URL+relativeUrl+"/ "+"采集完毕";
    }

}
