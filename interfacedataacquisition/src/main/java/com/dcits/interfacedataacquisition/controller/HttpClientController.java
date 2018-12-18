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
       
        String str = httpAPIService.doGet("http://www.baidu.com/s",map,null);
		logger.info(str);
        String topic = "websocket";
        kafkaSender.send(topic,"huxixaing");
        return "success";
    }
}
