package com.turbo.codegenerator.model.templet.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * model模板
 *
 * @author hailong.Yang
 * @create 2019-01-17 上午9:15
 **/
public class ModelTemplet{

   private String name;

   private Long leng;

   private BigDecimal bigDecimal;

   private Date date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLeng() {
        return leng;
    }

    public void setLeng(Long leng) {
        this.leng = leng;
    }

    public BigDecimal getBigDecimal() {
        return bigDecimal;
    }

    public void setBigDecimal(BigDecimal bigDecimal) {
        this.bigDecimal = bigDecimal;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
