package com.turbo.codegenerator.dto;

import java.io.Serializable;

/**
 * @author hailong.Yang
 * @create 2019-01-17 下午4:04
 **/
public class ModelReqDto implements Serializable{

    private String packageDir;

    private String tableName;

    private String databaseName;

    private String outputPath;

    public String getPackageDir() {
        return packageDir;
    }

    public void setPackageDir(String packageDir) {
        this.packageDir = packageDir;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }
}
