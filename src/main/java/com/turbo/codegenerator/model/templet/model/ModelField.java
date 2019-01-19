package com.turbo.codegenerator.model.templet.model;

/**
 * @author hailong.Yang
 * @create 2019-01-17 上午10:19
 **/
public class ModelField {

    private String fieldType;

    private String fieldName;

    private String fieldDesc;

    private String fieldNameUpcase;

    private String tableFieldName;


    public String getFieldType() {
        return fieldType;
    }

    public void setFieldType(String fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldDesc() {
        return fieldDesc;
    }

    public void setFieldDesc(String fieldDesc) {
        this.fieldDesc = fieldDesc;
    }

    public String getFieldNameUpcase() {
        return fieldNameUpcase;
    }

    public void setFieldNameUpcase(String fieldNameUpcase) {
        this.fieldNameUpcase = fieldNameUpcase;
    }

    public String getTableFieldName() {
        return tableFieldName;
    }

    public void setTableFieldName(String tableFieldName) {
        this.tableFieldName = tableFieldName;
    }
}
