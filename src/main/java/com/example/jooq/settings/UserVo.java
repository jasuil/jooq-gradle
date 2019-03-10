package com.example.jooq.settings;

/*
 * Copyright (c) 2019 LINE Corporation. All rights reserved.
 * LINE Corporation PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

public class UserVo {
    private String id;
    private String name;
    private String addr;

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

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public static class inner {
        private String aaa;

        public void setAaa(String aaa){
            this.aaa = aaa;
        }

        public String getAaa(){
            return aaa;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        sb.append("id : ").append(id).append(", ");
        sb.append("name : ").append(name).append(", ");
        sb.append("addr : ").append(addr);
        sb.append("]");
        return sb.toString();
    }

}

