package com.turbo.codegenerator;

import com.turbo.codegenerator.model.templet.model.Model;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * @author hailong.Yang
 * @create 2019-01-17 上午10:08
 **/
public class VmGeneCodeTest {



    @Test
    public void generatorModelCode() throws IOException {
        Properties properties=new Properties();
        //设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class",
                "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");

        //文件路径输出
//        properties.setProperty(VelocityEngine.FILE_RESOURCE_LOADER_PATH, "/Users/yanghl/testFile/vm");


        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine = new VelocityEngine(properties);

        // 实例化一个VelocityContext
        VelocityContext context = new VelocityContext();
        // 向VelocityContext中放入键值

        Model model = this.buildModel();
        context.put("model", this.buildModel());


//        context.put("user", u);
        // 实例化一个StringWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/yanghl/testFile/vm/java/"+model.getClassName()+".java"));
        System.out.println(context.toString());
        // 从src目录下加载hello.vm模板
        // 假若在com.velocity.test包下有一个hello.vm文件,那么加载路径为com/velocity/test/hello.vm
        velocityEngine.mergeTemplate("vm/MybatisMapper.vm", "UTF-8", context, bufferedWriter);
        bufferedWriter.flush();
        bufferedWriter.close();
        // velocityEngine.mergeTemplate("hello.vm", "gbk", context, writer);

    }

    private Model buildModel() {
        Model model = new Model();
        model.setPackageName("com.turbo.test.code.api");
        model.setClassName("TestCode");
        model.setCreatDate(new Date().toLocaleString());
        model.setClassDesc("代码生成");
        System.out.println(model.getFieldList());
        return model;
    }


    @Test
    public void handleer222(){

        System.out.println(System.getProperty("user.dir"));

        System.out.println(Class.class.getClass().getResource("/").getPath() );

        File directory = new File("");//设定为当前文件夹

        File f = new File(this.getClass().getResource("/").getPath());
        System.out.println(f.getPath());
    }



}
