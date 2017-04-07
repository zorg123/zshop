package com.flyrui.dao.pojo.channel;

import java.io.Serializable;

public class FrContentTxt implements Serializable {
    private Integer content_id;

    private String txt;

    private String txt1;

    private String txt2;

    private String txt3;

    private static final long serialVersionUID = 1L;

    public Integer getContent_id() {
        return content_id;
    }

    public void setContent_id(Integer content_id) {
        this.content_id = content_id;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt == null ? null : txt.trim();
    }

    public String getTxt1() {
        return txt1;
    }

    public void setTxt1(String txt1) {
        this.txt1 = txt1 == null ? null : txt1.trim();
    }

    public String getTxt2() {
        return txt2;
    }

    public void setTxt2(String txt2) {
        this.txt2 = txt2 == null ? null : txt2.trim();
    }

    public String getTxt3() {
        return txt3;
    }

    public void setTxt3(String txt3) {
        this.txt3 = txt3 == null ? null : txt3.trim();
    }
}