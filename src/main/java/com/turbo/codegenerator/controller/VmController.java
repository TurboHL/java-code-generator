package com.turbo.codegenerator.controller;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

/**
 * @author hailong.Yang
 * @create 2019-01-16 下午10:12
 **/

@Controller
public class VmController {

    @RequestMapping(value= {"/vm"} )
    public String news(){
        return "news.vm";
    }



    public static void main(String[] args) throws IOException {
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
        context.put("username", "张三");
        context.put("password", "123456789");

        context.put("vmc", new VmController());


//        context.put("user", u);
        // 实例化一个StringWriter
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("/Users/yanghl/testFile/vm/java/test1.java"));
        StringWriter writer = new StringWriter();
        System.out.println(context.toString());
        // 从src目录下加载hello.vm模板
        // 假若在com.velocity.test包下有一个hello.vm文件,那么加载路径为com/velocity/test/hello.vm
        velocityEngine.mergeTemplate("vm/hello.vm", "UTF-8", context, bufferedWriter);

        bufferedWriter.flush();

        // velocityEngine.mergeTemplate("hello.vm", "gbk", context, writer);
        System.out.println(writer.toString());
    }
    public String getName(String aa){
        System.out.println("++++++++" + aa);
        return aa + "你好";
    }
}
