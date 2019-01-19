package com.turbo.codegenerator.util;


import org.apache.commons.lang.StringUtils;

import java.util.Arrays;

/**
 * 字段转换Util
 *
 * @author hailong.Yang
 * @create 2019-01-17 下午1:59
 **/
public class FieldUtil {

    private FieldUtil(){};

    public static String getFieldName(String fieldName){
        String[] array = fieldName.split("_");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<array.length; i++){
            if(i == 0){
                sb.append(array[i]);
                continue;
            }
            sb.append(StringUtils.substring(array[i],0,1).toUpperCase())
                    .append(StringUtils.substring(array[i],1));
        }
        return sb.toString();
    }


    public static String getFieldNameUpcase(String fieldName){
        StringBuilder sb = new StringBuilder();
        sb.append(fieldName.substring(0,1).toUpperCase()).append(fieldName.substring(1));
        return sb.toString();
    }


    public static void main(String args[]){
        System.out.println(getFieldName("borrower_id_card"));
    }


}
