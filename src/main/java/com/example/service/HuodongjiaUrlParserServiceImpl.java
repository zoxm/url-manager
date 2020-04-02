package com.example.service;

import cn.hutool.log.StaticLog;
import com.example.module.entity.IndustryEntity;
import com.example.service.base.DocumentService;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    private DocumentService documentService;

    @Autowired
    private IndustryEntityService industryEntityService;



    @Autowired
    private UrlEntityService urlEntityService;

    @Override
    public String parser(IndustryEntity industryEntity) {
        Integer doPage = industryEntity.getDone()+1;

        Document document = documentService.getDocument(industryEntity.getHref() + "page-"+ doPage +"/");
        Elements elements = document.getElementsByClass("into");
        StaticLog.info("开始采集url:  {}page-{}/",industryEntity.getHref(), doPage);
//        StaticLog.info("document:  {}",document);
        elements.forEach(element -> {
            Elements hrefs = element.getElementsByAttribute("href");
            Element element1 = hrefs.get(0);
            Elements all = element1.getElementsByTag("a");
            all.forEach(e -> {
                urlEntityService.save("https://www.huodongjia.com", e.attr("abs:href"));
                StaticLog.info("url-manager save:  {}  ", e.attr("abs:href"));
            });
        });
        // 记录这一页
        industryEntity.setDone(doPage);

        // 下一页判断
        AtomicInteger nextPage = new AtomicInteger();
        Elements paginationElements = document.getElementsByClass("pagination");
        paginationElements.forEach(element -> {
            Elements elementElementsByTags = element.getElementsByTag("a");
            if (!"下一页".equals(elementElementsByTags.last().text())){
                StaticLog.info("已经到最大页码:  {}  ", elementElementsByTags.last().text());
                //
                // 修改最大页码
                industryEntity.setMaxPage(Integer.valueOf(elementElementsByTags.last().text()));
                nextPage.set(1);
            }
        });
        industryEntityService.update(industryEntity);
        return "next_page"+(doPage+1);
    }



    @Override
    public void parserAllIndustry(Document document) {
        StaticLog.info("begin parserAllIndustry ...");
        Elements conditionElements = document.getElementsByClass("condition");
//        StaticLog.info("url-manager:  {}  ", conditionElements);
        conditionElements.forEach(condition -> {
            Elements hrefElements = condition.getElementsByTag("a");
//            StaticLog.info("a标签:  {}  ", hrefElements);
            hrefElements.forEach(a -> {
                StaticLog.info("industry:  {}   {}", a.attr("href"), a.text());
                IndustryEntity industryEntity = new IndustryEntity();
                industryEntity.setName(a.text())
                        .setHref(a.attr("href"));
                industryEntityService.checkAndSave(industryEntity);
            });
        });
    }
}
