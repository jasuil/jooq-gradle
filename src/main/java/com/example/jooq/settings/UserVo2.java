package com.example.jooq.settings;

/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

import javax.annotation.sql.DataSourceDefinition;

public class UserVo2 {
    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public static class aaa extends UserVo.inner{
        public String getBbb() {
            return bbb;
        }

        public void setBbb(String bbb) {
            this.bbb = bbb;
        }

        private String bbb;

    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("id : ").append(id).append(", ");
        sb.append("name : ").append(name).append(", ");
        sb.append("]");
        return sb.toString();
    }

}

