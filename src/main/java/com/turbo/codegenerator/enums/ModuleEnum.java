package com.turbo.codegenerator.enums;

/**
 * 模块枚举类
 *
 * @author hailong.Yang
 * @create 2019-01-17 下午6:45
 **/
public enum ModuleEnum {

    MODLE("model","modelCodeHandle"),
    MAPPER("mapper","mapperCodeHandle"),
    MAPPER_XML("mapper","mapperXmlHandle");

    ModuleEnum(String moduleName,String bizServiceHandle){
        this.bizServiceHandle = bizServiceHandle;
        this.moduleName = moduleName;
    }

    private String moduleName;
    private String bizServiceHandle;

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getBizServiceHandle() {
        return bizServiceHandle;
    }

    public void setBizServiceHandle(String bizServiceHandle) {
        this.bizServiceHandle = bizServiceHandle;
    }
}
