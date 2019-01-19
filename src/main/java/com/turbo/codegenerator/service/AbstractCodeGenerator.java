package com.turbo.codegenerator.service;

import com.turbo.codegenerator.config.SystemProperties;
import com.turbo.codegenerator.dto.ModelReqDto;
import com.turbo.codegenerator.mapper.InformationSchemaMapper;
import com.turbo.codegenerator.model.SchemaTable;
import com.turbo.codegenerator.model.TableColumn;
import com.turbo.codegenerator.model.templet.model.Model;
import com.turbo.codegenerator.util.FieldUtil;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * @author hailong.Yang
 * @create 2019-01-17 下午3:29
 **/
public abstract class AbstractCodeGenerator {

    private static final Logger logger = LoggerFactory.getLogger(AbstractCodeGenerator.class);

    @Autowired
    protected InformationSchemaMapper informationSchemaMapper;

    @Autowired
    protected SystemProperties systemProperties;

    public boolean executeCodeGenerator(ModelReqDto modelReqDto) throws IOException {

        BufferedWriter bufferedWriter = null;
        try{
            //构建引擎
            VelocityEngine velocityEngine = getVelocityEngine();

            //赋值
            VelocityContext context = new VelocityContext();
            Model model = this.buildExecuteCodeModel(modelReqDto);
            context.put("model", model);

            //构建输出目录
            String outputFilePath = model.getOutputPath();
            logger.info("[文件生成路径] outputFilePath={}",outputFilePath);
            String classFilePath = this.getClassFilePath();
            logger.info("[文件生成路径] classFilePath={}",classFilePath);
            classFilePath = classFilePath.replaceAll("\\.", File.separator);
            logger.info("[文件生成路径] classFilePath={}",classFilePath);
            String classFileName = model.getClassName() + model.getSuffix();
            logger.info("[文件生成路径] classFileName={}",classFileName);
            String outputPath = outputFilePath + classFilePath;
            //构建路径
            buildFileDir(outputPath);
            outputPath = outputPath + File.separator + classFileName;
            logger.info("[文件生成路径] filePath={}",outputPath);
            File file = new File(outputPath);
            if(file.exists()){
                file.delete();
            }
            bufferedWriter = new BufferedWriter(new FileWriter(file));
            velocityEngine.mergeTemplate(this.getTemplatePath(), "UTF-8", context, bufferedWriter);
        }catch (Exception e){
            logger.error("代码生成异常",e);
            return false;
        }finally {
            if(bufferedWriter != null){
                bufferedWriter.flush();
                bufferedWriter.close();
            }
        }
        return true;
    }

    private VelocityEngine getVelocityEngine() {
        Properties properties=new Properties();
        //设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        //文件路径输出
//        properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "/Users/yanghl/testFile/vm");

        //实例化一个VelocityEngine对象
        return new VelocityEngine(properties);
    }


    protected abstract Model buildExecuteCodeModel(ModelReqDto modelReqDto);

    protected Model getModel(ModelReqDto modelReqDto){
        Model model = new Model();
        model.setOutputPath(modelReqDto.getOutputPath());
        model.setPackageName(modelReqDto.getPackageDir());
        model.setModelName(FieldUtil.getFieldNameUpcase(FieldUtil.getFieldName(modelReqDto.getTableName())));
        model.setClassName(model.getModelName() + this.getProjectModule());
        model.setCreatDate(new Date().toLocaleString());
        model.setClassDesc(this.getTableDesc(modelReqDto));
        model.setTableName(modelReqDto.getTableName());
        return model;
    }

    private String getTableDesc(ModelReqDto modelReqDto){
        Map<String,String> map = new HashMap<>();
        map.put("tableSchema",modelReqDto.getDatabaseName());
        map.put("tableName",modelReqDto.getTableName());
        List<SchemaTable> list = informationSchemaMapper.querySchemaTableList(map);
        if(null != list && !list.isEmpty()){
            return list.get(0).getTABLE_COMMENT();
        }
        return null;
    }


    protected List<TableColumn> getTableColumnList(ModelReqDto modelReqDto) {
        Map<String,String> map = new HashMap<>();
        map.put("tableSchema",modelReqDto.getDatabaseName());
        map.put("tableName",modelReqDto.getTableName());
        List<TableColumn> list = informationSchemaMapper.queryTableColumnList(map);
        return list;
    }

    private void buildFileDir(String outputPath){
        File file = new File(outputPath);
        if(!file.exists()){
            file.mkdirs();
        }
    }

    protected abstract String getProjectModule();

    protected abstract String getClassFileName(String tableName);

    protected abstract String getTemplatePath();

    protected abstract String getClassFilePath();
}
