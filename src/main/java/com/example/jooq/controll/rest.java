package com.example.demo2.controll;

import Util.PdfCreator;
import com.example.demo2.DTO.dataDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
public class rest {


    @Autowired
    ServletContext context;


    @RequestMapping(method = RequestMethod.GET, path = "/list")
    public String list(dataDTO earch, String j, HttpServletResponse response) throws Exception {

        PdfCreator.pdf(response, context);
        return "ok";
    }
}
