package com.turbo.codegenerator.service;

import com.turbo.codegenerator.dto.ModelReqDto;
import com.turbo.codegenerator.enums.DataTypeEnum;
import com.turbo.codegenerator.enums.ModuleEnum;
import com.turbo.codegenerator.model.TableColumn;
import com.turbo.codegenerator.model.templet.model.Model;
import com.turbo.codegenerator.model.templet.model.ModelField;
import com.turbo.codegenerator.util.FieldUtil;
import org.springframework.stereotype.Service;
import sun.tools.jconsole.Tab;

import javax.xml.crypto.Data;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper接口生成
 *
 * @author hailong.Yang
 * @create 2019-01-17 下午5:54
 **/

@Service("mapperXmlHandle")
public class MapperXmlHandle extends AbstractCodeGenerator{

    @Override
    protected Model buildExecuteCodeModel(ModelReqDto modelReqDto) {
        Model model = this.getModel(modelReqDto);
        model.setSuffix(".xml");

        List<TableColumn> tableColumnList = this.getTableColumnList(modelReqDto);
        //构建表字段list
        List<ModelField> modelFieldList = tableColumnList.stream().map(e -> {
            ModelField modelField = new ModelField();
            modelField.setFieldName(FieldUtil.getFieldName(e.getCOLUMN_NAME()));
            modelField.setFieldType(DataTypeEnum.getJdbcType(e.getDATA_TYPE()));
            modelField.setTableFieldName(e.getCOLUMN_NAME());
            return modelField;
        }).collect(Collectors.toList());

        //构建主键对象
        TableColumn primarykeyColumn = tableColumnList.stream().filter(e -> e.getCOLUMN_KEY().equals("PRI"))
                .collect(Collectors.toList()).get(0);

        model.setModelFieldList(modelFieldList);

        model.setTablePrimaryKey(primarykeyColumn.getCOLUMN_NAME());
        model.setTablePrimaryKeyType(DataTypeEnum.getJdbcType(primarykeyColumn.getDATA_TYPE()));

        model.setModelPrimaryKey(FieldUtil.getFieldName(primarykeyColumn.getCOLUMN_NAME()));
        model.setModelPrimaryKeyType(DataTypeEnum.getTypePackage(primarykeyColumn.getDATA_TYPE()));

        model.setModelDirPath(model.getPackageName() + "." + ModuleEnum.MODLE.getModuleName() + "." + model.getModelName());
        model.setMapperDirPath(model.getPackageName() + "." + ModuleEnum.MAPPER.getModuleName() + "." + model.getClassName());
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
        return "vm/MybatisMapperXml.vm";
    }

    @Override
    protected String getClassFilePath() {
        return systemProperties.getMapperDirPath();
    }
}
