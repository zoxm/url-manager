package com.example.controller;

import com.example.service.HuodongjiaUrlParserService;
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
@RequestMapping("huodongjia")
public class HuodongjiaController {

    @Autowired
    private getDocumentService getDocumentService;

    @Autowired
    private HuodongjiaUrlParserService huodongjiaUrlParserService;

    private static final String URL = "https://www.huodongjia.com/";

    @RequestMapping("{relativeUrl}")
    public String huodongjia(@PathVariable("relativeUrl")String relativeUrl){

        for (int i = 2 ; i <= 10 ; i ++){
            // 抓取
            Document document = getDocumentService.getDocument(URL+relativeUrl+"/page-"+i+"/");
            System.out.println("采集url============================================"+URL + relativeUrl+"/page-"+i);
            // 解析和存储
            huodongjiaUrlParserService.parser(document);
        }
        return "网址："+URL+relativeUrl+"/ "+"采集完毕";
    }

}
