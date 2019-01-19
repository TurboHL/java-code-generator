package com.turbo.codegenerator.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SystemProperties{

    @Value("${code.package.dir}")
    private String packageDirPath;

    @Value("${code.model.dir}")
    private String modelDirPath;

    @Value("${code.mapper.dir}")
    private String mapperDirPath;

    @Value("${code.output.path}")
    private String codeOutputPath;


    public String getPackageDirPath() {
        return packageDirPath;
    }

    public void setPackageDirPath(String packageDirPath) {
        this.packageDirPath = packageDirPath;
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

    public String getCodeOutputPath() {
        return codeOutputPath;
    }
}