//package com.example.test;
//
//
//import com.example.DemoApplication;
//import com.example.controller.HuodongjiaController;
//import com.example.module.entity.IndustryEntity;
//import com.example.repository.IndustryRepository;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
///**
// * @ClassName UrlParserTest
// * @Description TODO
// * @Author miaoyi
// * @Date 2020-01-07 17:02
// * @Version 1.0
// **/
//@RunWith(SpringRunner.class) //作用：让当前类在容器环境下进行测试
//@SpringBootTest(classes = DemoApplication.class)//作用：声明当前类是springboot的测试类并且获取入口类上的相关信息 SpringBootApplication是入口类类名
////————————————————
////        版权声明：本文为CSDN博主「zxom」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
////        原文链接：https://blog.csdn.net/mnmiaoyi/article/details/98236428
//public class UrlParserTest {
//
//    @Autowired
//    private HuodongjiaController huodongjiaController;
//
//    @Autowired
//    private IndustryRepository industryRepository;
//
//    @Test
//    public void test0() {
//
////        IndustryEntity industryEntity = new IndustryEntity();
////        industryEntity.setDone(2)
////                .setMaxPage(3)
////                .setHref("https://www.huodongjia.com/medical/19/")
////                .setId(1);
////        ArrayList<IndustryEntity> industryEntities = new ArrayList<>();
////        industryEntities.add(industryEntity);
////        huodongjiaController.loop(industryEntities);
//    }
//
//    @Test
//    public void test1() {
////        IndustryEntity industryEntity = new IndustryEntity();
////        industryEntity
////                .setName("医疗")
////                .setDone(2)
////                .setMaxPage(3)
////                .setHref("https://www.huodongjia.com/medical/19/")
////                .setId(1);
////        industryRepository.updateIndustryEntityById(industryEntity);
//    }
//}
