package com.turbo.codegenerator.enums;

import java.util.Arrays;

/**
 * @author hailong.Yang
 * @create 2019-01-17 下午1:13
 **/
public enum  DataTypeEnum {

    LONG("bigint","Long","java.lang.Long","BIGINT"),
    STRING("varchar","String","java.lang.String","VARCHAR"),
    DATE("date","Date","java.util.Date","DATE"),
    BIGDECIMAL("bigdecimal","Bigdecimal","java.math.BigDecimal","BIGDECIMAL"),
    DOUBLE("double","Double","java.lang.Double","DOUBLE"),
    TEXT("text","String","java.lang.String","LONGVARCHAR"),
    LIST("list","List","java.util.List","LIST");

    DataTypeEnum(String mysqlType,String javaType,String javaTypePackage,String jdbcType){
        this.mysqlType = mysqlType;
        this.javaType = javaType;
        this.javaTypePackage = javaTypePackage;
        this.jdbcType = jdbcType;
    }

    public static String getTypePackage(String type){
        DataTypeEnum[] dataTypeEnums = DataTypeEnum.values();
        for(DataTypeEnum dataTypeEnum : dataTypeEnums){
            if(type.equals(dataTypeEnum.getMysqlType())){
                return dataTypeEnum.getJavaTypePackage();
            }
        }
        return "";
    }

    public static String getJavaType(String mysqlType){
        DataTypeEnum[] dataTypeEnums = DataTypeEnum.values();
        for(DataTypeEnum dataTypeEnum : dataTypeEnums){
            if(mysqlType.equals(dataTypeEnum.getMysqlType())){
                return dataTypeEnum.getJavaType();
            }
        }
        return "";
    }


    public static String getJdbcType(String mysqlType){
        DataTypeEnum[] dataTypeEnums = DataTypeEnum.values();
        for(DataTypeEnum dataTypeEnum : dataTypeEnums){
            if(mysqlType.equals(dataTypeEnum.getMysqlType())){
                return dataTypeEnum.getJdbcType();
            }
        }
        return "";
    }


    private String mysqlType;
    private String javaType;
    private String jdbcType;
    private String javaTypePackage;

    public String getMysqlType() {
        return mysqlType;
    }

    public String getJavaType() {
        return javaType;
    }

    public String getJdbcType() {
        return jdbcType;
    }
    public String getJavaTypePackage() {
        return javaTypePackage;
    }
}
