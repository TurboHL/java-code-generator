package com.turbo.codegenerator.service;

import com.turbo.codegenerator.dto.ModelReqDto;
import com.turbo.codegenerator.enums.DataTypeEnum;
import com.turbo.codegenerator.enums.ModuleEnum;
import com.turbo.codegenerator.mapper.InformationSchemaMapper;
import com.turbo.codegenerator.model.TableColumn;
import com.turbo.codegenerator.model.templet.model.Model;
import com.turbo.codegenerator.model.templet.model.ModelField;
import com.turbo.codegenerator.util.FieldUtil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 实体生成处理类
 *
 * @author hailong.Yang
 * @create 2019-01-17 下午3:53
 **/

@Service("modelCodeHandle")
public class ModelHandle extends AbstractCodeGenerator{

    private static final Logger logger = LoggerFactory.getLogger(ModelHandle.class);

    @Autowired
    private InformationSchemaMapper informationSchemaMapper;

    @Override
    protected Model buildExecuteCodeModel(ModelReqDto modelReqDto) {

        List<ModelField> modelFieldList = new ArrayList<>();
        Set<String> importList = new HashSet<>();
        List<TableColumn> tableColumnList = this.getTableColumnList(modelReqDto);
        for(TableColumn tableColumn : tableColumnList){

            //字段对象
            ModelField m1 = new ModelField();
            m1.setFieldName(FieldUtil.getFieldName(tableColumn.getCOLUMN_NAME()));
            m1.setFieldType(DataTypeEnum.getJavaType(tableColumn.getDATA_TYPE()));
            m1.setFieldDesc(tableColumn.getCOLUMN_COMMENT());
            m1.setFieldNameUpcase(FieldUtil.getFieldNameUpcase(m1.getFieldName()));

            //字段列表
            modelFieldList.add(m1);

            //引入列表
            String val = DataTypeEnum.getTypePackage(m1.getFieldType());
            if(StringUtils.isNotBlank(val)){
                importList.add(val);
            }
        }
        Model model = this.getModel(modelReqDto);
        model.setImportList(importList);
        model.setModelFieldList(modelFieldList);
        model.setClassName(this.getClassFileName(model.getTableName()));
        model.setPackageName(modelReqDto.getPackageDir() + "." + ModuleEnum.MODLE.getModuleName());
        return model;
    }

    @Override
    protected String getProjectModule() {
        return "";
    }

    @Override
    protected String getClassFileName(String tableName) {
        return FieldUtil.getFieldNameUpcase(FieldUtil.getFieldName(tableName));
    }

    @Override
    protected String getTemplatePath() {
        return "vm/Model.vm";
    }

    @Override
    protected String getClassFilePath() {
        return systemProperties.getModelDirPath();
    }
}
