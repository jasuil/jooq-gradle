package com.example.jooq.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class RestControll {

    Log logger = LogFactory.getLog(RestControll.class);

    @RequestMapping(value = "/test", method = RequestMethod.HEAD)
    public String testException (){
        logger.debug("1");
        return "2";
    }
}
