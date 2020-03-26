package com.example.service;

import cn.hutool.log.StaticLog;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName KdnuggetsUrlParserServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 12:05
 * @Version 1.0
 **/

@Service
public class KdnuggetsUrlParserServiceImpl implements KdnuggetsUrlParserService {

    @Autowired
    private UrlEntityService urlEntityService;
    @Override
    public void parser(Document document) {

        Elements post = document.getElementsByClass("post");
        post.forEach(element -> {
            Elements a = element.getElementsByTag("a");
            a.forEach(o->{
                String href = o.attr("href");
                if (href.contains("#") && href.length() < 10){
                    StaticLog.info("https://www.kdnuggets.com/meetings/index.html:  {}  ", href);
                    urlEntityService.save("https://www.kdnuggets.com/meetings/index.html",href);
                }
            });
        });


//        Elements elements = document.getElementsByTag("ul");
//        elements.forEach(element -> {
//            Elements hrefs = element.getElementsByTag("a");
//            hrefs.forEach(href->{
//                String href1 = href.attr("href");
//                String subUrl = href1.replace("https://www.kdnuggets.com", "");
//                StaticLog.info("object:  {}  ", subUrl);
//                urlEntityService.save("https://www.kdnuggets.com",href1);
//            });
//        });
    }
}
