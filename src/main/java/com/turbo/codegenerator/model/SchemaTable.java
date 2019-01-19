package com.turbo.codegenerator.model;

/**
 * @author hailong.Yang
 * @create 2019-01-16 下午11:51
 * schema下所有table
 **/
public class SchemaTable {

    private String TABLE_SCHEMA;
    private String TABLE_NAME;
    private String TABLE_COMMENT;

    public String getTABLE_SCHEMA() {
        return TABLE_SCHEMA;
    }

    public void setTABLE_SCHEMA(String TABLE_SCHEMA) {
        this.TABLE_SCHEMA = TABLE_SCHEMA;
    }

    public String getTABLE_NAME() {
        return TABLE_NAME;
    }

    public void setTABLE_NAME(String TABLE_NAME) {
        this.TABLE_NAME = TABLE_NAME;
    }

    public String getTABLE_COMMENT() {
        return TABLE_COMMENT;
    }

    public void setTABLE_COMMENT(String TABLE_COMMENT) {
        this.TABLE_COMMENT = TABLE_COMMENT;
    }
}
