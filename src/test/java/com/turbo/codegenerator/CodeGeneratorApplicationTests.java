package com.turbo.codegenerator;

import com.turbo.codegenerator.config.SystemProperties;
import com.turbo.codegenerator.dto.ModelReqDto;
import com.turbo.codegenerator.mapper.InformationSchemaMapper;
import com.turbo.codegenerator.model.GpsInfo;
import com.turbo.codegenerator.model.Schemata;
import com.turbo.codegenerator.model.TableColumn;
import com.turbo.codegenerator.service.CodeGeneratorHandle;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CodeGeneratorApplicationTests {

    @Autowired
	private CodeGeneratorHandle codeGeneratorHandle;

    @Autowired
	private SystemProperties systemProperties;


	@Test
	public void contextLoads() {
	}

	@Test
	public void handleer(){
		ModelReqDto dto = new ModelReqDto();
		dto.setTableName("gps_info");
		dto.setDatabaseName("risk_management");

		//工作目录
		String baseDir = System.getProperty("user.dir") + File.separator;
		//maven指定目录
		String basePackage = "src/main/java/";

		//自定义路径
		String aa = "/Users/yanghl/workspace_code/code-generator/src/main/java/";

		dto.setOutputPath(aa);
		dto.setPackageDir(systemProperties.getPackageDirPath());
		codeGeneratorHandle.executeCodeGen(dto);
	}

}

