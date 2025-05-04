package org.example;

import org.example.conf.Component;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class ApplicationContext {

    String packageName;
    public ApplicationContext(String packageName) throws IOException {
        this.packageName = packageName;
        initApplicationContext();
//        scanPackage(packageName);
    }

    public void initApplicationContext() throws IOException {
        // 拿到对象 类
        List<BeanDefinition> list =  this.scanPackage(packageName).stream().filter(this::canCreate).map(this::wrapper).toList();

        scanPackage(packageName).stream().filter(this::canCreate).toList().forEach(
                item -> System.out.println(item)
        );

//        List<Class<?>> componentClassList = scanPackage(packageName).stream().filter(
//                (cls)-> cls.isAnnotationPresent(Component.class)
//        ).toList();


    }

    protected void createBean(BeanDefinition beanDefinition) throws NoSuchMethodException {
        Constructor<?> constructor = beanDefinition.getConstructor();
    }

    /**
     * 扫描包
     * @param packageName
     * @return
     */
    private List<Class<?>> scanPackage(String packageName) throws IOException {
        List<Class<?>> list = new ArrayList<>();
        // a.b.c
        // 类加载器
        URL url = this.getClass().getClassLoader().getResource(packageName.replace(".", File.separator));
        assert url != null;
        Path path = Path.of(url.getFile());
        Files.walkFileTree(path, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path absolutePath = file.toAbsolutePath();
                //
                if(absolutePath.toString().endsWith(".class")){
                    String className = absolutePath.toString().replace(File.separator, ".");
                    int index = className.lastIndexOf(packageName);
                    className = className.substring(index, className.length() - ".class".length());
//                    System.out.println(absolutePath.toString());
                    try {
                        list.add(Class.forName(className));
                    } catch (ClassNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                }
                return FileVisitResult.CONTINUE;

            }
        });
        return list;
    }

    protected BeanDefinition wrapper(Class<?> clazz){
        return new BeanDefinition(clazz);
    }

    protected boolean canCreate(Class<?> clazz){
        return clazz.isAnnotationPresent(Component.class)   ;
    }


    /**
     * 根据类名加载
     * @param name
     * @return
     */
    public Object getBean(String name){
        return null;
    }

    /**
     * 根据类型加载一个
     * @param beantype
     * @return
     * @param <T>
     */
    public <T> T getBean(Class<T> beantype){
        return null;
    }

    /**
     * 根据类型加载所有的类型对象
     * @param beantype
     * @return
     * @param <T>
     */
    public  <T> List<T> getBeans(Class<T> beantype){
        return null;
    }
}
