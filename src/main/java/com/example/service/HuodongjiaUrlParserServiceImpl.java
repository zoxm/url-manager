package com.example.service;

import cn.hutool.log.StaticLog;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName HuodongjiaUrlParserServiceImpl
 * @Description TODO
 * @Author miaoyi
 * @Date 2020-03-21 12:05
 * @Version 1.0
 **/

@Service
public class HuodongjiaUrlParserServiceImpl implements HuodongjiaUrlParserService {

    @Autowired
    private UrlEntityService urlEntityService;
    @Override
    public void parser(Document document) {
        Elements elements = document.getElementsByClass("into");
        elements.forEach(element -> {
            Elements hrefs = element.getElementsByAttribute("href");
            Element element1 = hrefs.get(0);
            Elements all = element1.getElementsByTag("a");

            all.forEach(e ->  {
                urlEntityService.save("https://www.huodongjia.com",e.attr("abs:href"));
                StaticLog.info("object:  {}  ", e.attr("href"));
            });
        });
    }
}
