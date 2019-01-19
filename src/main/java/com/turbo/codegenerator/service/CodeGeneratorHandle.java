package com.turbo.codegenerator.service;

import com.turbo.codegenerator.dto.ModelReqDto;
import com.turbo.codegenerator.enums.ModuleEnum;
import com.turbo.codegenerator.util.SpringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author hailong.Yang
 * @create 2019-01-18 下午4:29
 **/

@Component("codeGeneratorHandle")
public class CodeGeneratorHandle {

    private static final Logger logger = LoggerFactory.getLogger(CodeGeneratorHandle.class);

    public void executeCodeGen(ModelReqDto modelReqDto){
        logger.info("【代码生成开始】---init---");
        try{
            ModuleEnum[] moduleEnums = ModuleEnum.values();
            for(ModuleEnum moduleEnum : moduleEnums){
                logger.info("【代码生成模块】名称={}",moduleEnum.getModuleName());
                AbstractCodeGenerator codeGeneratorHandle = (AbstractCodeGenerator) SpringUtil.getBean(moduleEnum.getBizServiceHandle());
                codeGeneratorHandle.executeCodeGenerator(modelReqDto);
            }
        }catch (Exception e){
            logger.error("【代码生成异常】" + e);
        }
        logger.info("【代码生成结束】--Finish-- 路径={}",modelReqDto.getOutputPath());
    }
}
