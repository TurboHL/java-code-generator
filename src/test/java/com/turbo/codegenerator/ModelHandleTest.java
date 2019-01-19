package com.turbo.codegenerator;

import com.turbo.codegenerator.dto.ModelReqDto;
import com.turbo.codegenerator.service.AbstractCodeGenerator;
import com.turbo.codegenerator.util.SpringUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author hailong.Yang
 * @create 2019-01-17 下午4:30
 **/

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelHandleTest {

    private static final Logger logger = LoggerFactory.getLogger(ModelHandleTest.class);


   @Test
   public void modelGeneratorCode() throws IOException {
       ModelReqDto modelReqDto = new ModelReqDto();
       modelReqDto.setPackageDir("com.turbo.codegenerator.api");
       modelReqDto.setTableName("gps_info");
       modelReqDto.setDatabaseName("risk_management");
       modelReqDto.setOutputPath("/Users/yanghl/testFile/vm/java/");
       AbstractCodeGenerator abstractCodeGenerator = (AbstractCodeGenerator) SpringUtil.getBean("modelCodeHandle");
       logger.info(abstractCodeGenerator.getClass().getSimpleName());

       boolean flag = abstractCodeGenerator.executeCodeGenerator(modelReqDto);
       logger.info("执行结果 ： " + flag);
   }


}
