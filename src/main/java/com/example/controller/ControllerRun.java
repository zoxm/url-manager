package com.example.controller;

import cn.hutool.log.StaticLog;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ControllerRun implements ApplicationRunner {
    @Autowired
    private HuodongjiaController huodongjiaController;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        // 初始化 标签任务
        huodongjiaController.plan0();
        while (true) {

            // 全量监测任务
            huodongjiaController.planX();
            StaticLog.info("睡眠20秒...........................................................");
            Thread.sleep(20000);    //延时20秒

            // 增量刷新任务
            huodongjiaController.planZ();
            StaticLog.info("睡眠5分钟...........................................................");
            Thread.sleep(300000);    //延时5分钟
        }
    }
}
