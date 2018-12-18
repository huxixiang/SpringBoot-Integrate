package com.dcits.interfacedataacquisition.controller;


import com.dcits.interfacedataacquisition.httputil.HttpAPIService;

import com.dcits.interfacedataacquisition.kafkautil.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;



@RestController
public class HttpClientController {
    private Logger logger = LoggerFactory.getLogger(HttpClientController.class);

    @Resource
    private HttpAPIService httpAPIService;
    @Autowired
    KafkaSender<Map> kafkaSender;

    @RequestMapping("getData")
    public String httpclient() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("wd","123");
        map.put("rsv_spt","1");
        map.put("rsv_iqid","0xe4bd260b0000656c");
//        map.put("rsv_spt","1");
//        map.put("rsv_spt","1");
//        map.put("rsv_spt","1");
//        System.setProperty("log4j2","d:/huxx.log");
//        Logger logger = LoggerFactory.getLogger(HttpClientController.class);
        String str = httpAPIService.doGet("http://www.baidu.com/s",map,null);
        for(int i = 0;i<100;i++){
            logger.info("info");
            logger.debug("debug");
            logger.warn("warn");
            logger.error("error");
            logger.error(str);
        }
        String topic = "websocket";
        kafkaSender.send(topic,"huxixaing");
        return "hello";
    }
}
