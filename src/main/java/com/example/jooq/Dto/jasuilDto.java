package com.example.jooq.Dto;

import java.io.Serializable;

public class jasuilDto implements Serializable {

    String jsi;

    public jasuilDto(){}

    public jasuilDto(String jsi){
        this.jsi = jsi;
    }

    public String getJsi() {
        return jsi;
    }

    public void setJsi(String jsi) {
        this.jsi = jsi;
    }
}
