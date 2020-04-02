package com.example.controller;

import cn.hutool.log.StaticLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class ControllerRun  implements ApplicationRunner {
    @Autowired
    private HuodongjiaController huodongjiaController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        int errnoCount = 0;
        huodongjiaController.plan0();
        try {

        huodongjiaController.planX();
        }catch (Exception e){
            errnoCount++;
            StaticLog.info("ERRNO:  报错啦,第{}个错",errnoCount);
            StaticLog.info("{}",e.toString());
//            e.printStackTrace();
        }
    }
}
