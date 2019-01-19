package com.turbo.codegenerator.model.templet.model;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author hailong.Yang
 * @create 2019-01-17 上午10:18
 **/
public class Model {

    //报名
    private String packageName;

    //类名
    private String className;

    //实体名
    private String modelName;

    //实体对象类路径
    private String modelDirPath;

    //包路径
    private String mapperDirPath;

    //表明
    private String tableName;

    //表明主键
    private String tablePrimaryKey;
    private String tablePrimaryKeyType;
    //实体主键
    private String modelPrimaryKey;
    //实体主键类型
    private String modelPrimaryKeyType;

    private String creatDate;

    private String classDesc;

    //模型名称
    private String templatePath;

    //输出路径
    private String outputPath;

    //扩展名
    private String suffix = ".java";

    //实体对象字段名
    private List<ModelField> modelFieldList;

    //数据字段列表
    private List<String> fieldList;

    //java类导入list
    private Set<String> importList;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelDirPath() {
        return modelDirPath;
    }

    public void setModelDirPath(String modelDirPath) {
        this.modelDirPath = modelDirPath;
    }

    public String getMapperDirPath() {
        return mapperDirPath;
    }

    public void setMapperDirPath(String mapperDirPath) {
        this.mapperDirPath = mapperDirPath;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTablePrimaryKey() {
        return tablePrimaryKey;
    }

    public void setTablePrimaryKey(String tablePrimaryKey) {
        this.tablePrimaryKey = tablePrimaryKey;
    }

    public String getTablePrimaryKeyType() {
        return tablePrimaryKeyType;
    }

    public void setTablePrimaryKeyType(String tablePrimaryKeyType) {
        this.tablePrimaryKeyType = tablePrimaryKeyType;
    }

    public String getModelPrimaryKey() {
        return modelPrimaryKey;
    }

    public void setModelPrimaryKey(String modelPrimaryKey) {
        this.modelPrimaryKey = modelPrimaryKey;
    }

    public String getModelPrimaryKeyType() {
        return modelPrimaryKeyType;
    }

    public void setModelPrimaryKeyType(String modelPrimaryKeyType) {
        this.modelPrimaryKeyType = modelPrimaryKeyType;
    }

    public String getCreatDate() {
        return creatDate;
    }

    public void setCreatDate(String creatDate) {
        this.creatDate = creatDate;
    }

    public String getClassDesc() {
        return classDesc;
    }

    public void setClassDesc(String classDesc) {
        this.classDesc = classDesc;
    }

    public String getTemplatePath() {
        return templatePath;
    }

    public void setTemplatePath(String templatePath) {
        this.templatePath = templatePath;
    }

    public String getOutputPath() {
        return outputPath;
    }

    public void setOutputPath(String outputPath) {
        this.outputPath = outputPath;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public List<ModelField> getModelFieldList() {
        return modelFieldList;
    }

    public void setModelFieldList(List<ModelField> modelFieldList) {
        this.modelFieldList = modelFieldList;
    }

    public List<String> getFieldList() {
        return fieldList;
    }

    public void setFieldList(List<String> fieldList) {
        this.fieldList = fieldList;
    }

    public Set<String> getImportList() {
        return importList;
    }

    public void setImportList(Set<String> importList) {
        this.importList = importList;
    }
}
