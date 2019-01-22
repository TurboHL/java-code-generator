package com.turbo.codegenerator;

import com.turbo.codegenerator.service.AbstractCodeGenerator;
import com.turbo.codegenerator.service.MapperXmlHandle;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;

/**
 * @author hailong.Yang
 * @create 2019-01-22 下午1:52
 **/
public class ClassUtilTest {



    @Test
    public void getAllClassByInterface() throws Exception {


        Class c = AbstractCodeGenerator.class;
        System.out.println("result=" + c.isInterface());

            List<Class> returnClassList = new ArrayList<>();
            List<Class> allClass = getClasses(c);
            for(int i=0;i<allClass.size();i++){
                if(c.isAssignableFrom(allClass.get(i))){ //判断是不是一个接口 if(!c.equals(allClass.get(i))){ //本身不加进去
                    if(c.getName().equals(allClass.get(i).getName())){
                       continue;
                    }
                    returnClassList.add(allClass.get(i));
                }
            }

        returnClassList.forEach(e -> System.out.println("最终输出=" + e.getSimpleName()));


    }

    public List<Class> getClasses(Class clazz) throws Exception {

        String packageName = clazz.getPackage().getName();
        System.out.println(packageName);

        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        packageName = packageName.replaceAll("\\.", File.separator);

        System.out.println(packageName);

        List<File>  dirList = new ArrayList<>();
        Enumeration<URL> resources = classLoader.getResources(packageName);
        while (resources.hasMoreElements()) {
            URL resource = resources.nextElement();
            dirList.add(new File(resource.getPath()));
        }

        List<Class> classList = new ArrayList<>();
        for(File dir : dirList){
            classList.addAll(findClass(dir,packageName));
        }
        return classList;
    }

    private List<Class> findClass(File dir, String packageName) throws Exception {

        List<Class> classList = new ArrayList<>();
        if(!dir.isDirectory()){
            return classList;
        }

        File[] classFile  = dir.listFiles();
        for(File file : classFile){
            if(file.isDirectory()){
                assert !file.getName().contains(".");
                classList.addAll(findClass(file, packageName + "\\." + file.getName()));
            }
            else if(file.getName().endsWith(".class")){
                String aa = packageName + File.separator  + file.getName().substring(0, file.getName().length() - 6);
                aa = aa.replaceAll(File.separator ,"\\.");
                System.out.println("----" + aa );
                classList.add(Class.forName(aa));            }
        }
        return classList;
    }



    @Test
    public void test2(){

//        class1.isAssignableFrom(class2) 判定此 class1 对象所表示的类或接口与指定的
//        class2 参数所表示的类或接口是否相同，或是否是其超类或超接口。如果是则返回 true；否则返回 false。
//        如果该 Class 表示一个基本类型，且指定的 Class 参数正是该 Class 对象，则该方法返回 true；否则返回 false。

        System.out.println(AbstractCodeGenerator.class.isAssignableFrom(AbstractCodeGenerator.class));
        System.out.println(AbstractCodeGenerator.class.isAssignableFrom(MapperXmlHandle.class));
        System.out.println(MapperXmlHandle.class.isAssignableFrom(AbstractCodeGenerator.class));
        if(!AbstractCodeGenerator.class.isInterface() && AbstractCodeGenerator.class.isAssignableFrom(MapperXmlHandle.class)){
            System.out.println("我是你爹");
        }
    }

    @Test
    public void test3(){
        Class<MapperXmlHandle> xmlHandleClass = MapperXmlHandle.class;
        Class<?>  clazz =  xmlHandleClass.getSuperclass();
        System.out.println(clazz.getName());
    }

}

