package com.turbo.codegenerator.service;

import com.turbo.codegenerator.dto.ModelReqDto;
import com.turbo.codegenerator.enums.DataTypeEnum;
import com.turbo.codegenerator.enums.ModuleEnum;
import com.turbo.codegenerator.model.templet.model.Model;
import com.turbo.codegenerator.util.FieldUtil;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Mapper接口生成
 *
 * @author hailong.Yang
 * @create 2019-01-17 下午5:54
 **/

@Service("mapperCodeHandle")
public class MapperHandle extends AbstractCodeGenerator{

    @Override
    protected Model buildExecuteCodeModel(ModelReqDto modelReqDto) {
        Model model = this.getModel(modelReqDto);
        model.setTemplatePath("vm/MybatisMapper.vm");
        Set<String> importList = new HashSet<>();
        importList.add(DataTypeEnum.getTypePackage("list"));
        importList.add(new StringBuilder(
                modelReqDto.getPackageDir())
                .append(".")
                .append(ModuleEnum.MODLE.getModuleName())
                .append(".")
                .append(model.getModelName()).toString());
        model.setImportList(importList);
        model.setClassName(this.getClassFileName(modelReqDto.getTableName()));
        model.setPackageName(modelReqDto.getPackageDir() + "." + ModuleEnum.MAPPER.getModuleName());
        return model;
    }

    @Override
    protected String getProjectModule() {
        return FieldUtil.getFieldNameUpcase(ModuleEnum.MAPPER.getModuleName());
    }

    @Override
    protected String getClassFileName(String tableName) {
        return FieldUtil.getFieldNameUpcase(FieldUtil.getFieldName(tableName)) + this.getProjectModule();
    }

    @Override
    protected String getTemplatePath() {
        return "vm/MybatisMapper.vm";
    }

    @Override
    protected String getClassFilePath() {
        return systemProperties.getMapperDirPath();
    }
}
