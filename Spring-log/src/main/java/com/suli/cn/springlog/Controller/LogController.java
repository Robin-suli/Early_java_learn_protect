package com.suli.cn.springlog.Controller;

import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("log")
@RestController
public class LogController {
    private final static Logger log = LoggerFactory.getLogger(LogController.class);


    @RequestMapping("print")
    public static String print(String[] args) {
        System.out.println("sout打印日志");
        log.info("Spring 打印日志");
        log.trace("trace ...");

        return "打印日志";
    }
}
