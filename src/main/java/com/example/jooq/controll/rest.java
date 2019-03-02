package com.example.jooq.controll;

import com.example.jooq.Dto.jasuilDto;
import com.example.jooq.settings.ApiConfig;
import com.example.jooq.settings.RegionCode;
import com.example.jooq.settings.userRegionCode;
import org.apache.commons.logging.Log;


import org.apache.commons.logging.LogFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Locale;

@RestController
public class rest {


    @Autowired
    ServletContext context;
    @Autowired
    private MessageSource messageSource;

    Logger log = LoggerFactory.getLogger(rest.class);

    @RequestMapping(method = RequestMethod.GET, path = "/get1/{id}")
    public ResponseEntity<jasuilDto> list(@PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {

       // PdfCreator.pdf(response, context);
        Locale locale = null;
        log.info(messageSource.getMessage("my.msg", null, new Locale("th", "TH")));
        return new ResponseEntity<>(new jasuilDto(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/set1/{id}")
    public String  set(@PathVariable(value = "id") String id, HttpServletResponse response) throws Exception {

        ApiConfig apiConfig = new ApiConfig();
        ApiConfig.MyAPI<jasuilDto> a = apiConfig.myapi();
        Call<jasuilDto> g = a.get1("성일짱");

        g.enqueue(new Callback<jasuilDto>() {
            @Override
            public void onResponse(Call<jasuilDto> call, Response<jasuilDto> response) {
                log.info("성공 : {}", response.body().getJsi());
            }

            @Override
            public void onFailure(Call<jasuilDto> call, Throwable t) {
                log.info("실패 : {}", t.toString());
            }
        });

        return g.toString();
    }


    @GetMapping("/region")
    public RegionCode region(@userRegionCode RegionCode regionCode){
        return regionCode;
    }
}
