package com.test.TestJVM.classloader;

import java.io.*;

/**
 * @Author dekai.kong
 * @description: 难度
 * @create: 2020-05-05 11:02
 * @from:
 *
 *  对于数组实例来说，其类型是由jvm在运行期间动态生成的，表示为class [LTestJVM.classloader.MyParent4;
 *
 *  但是其classloader与对象的类型的加载器是一致的,也就是例如String的加载器就是bootstrap加载器,自定义的类就是app的类加载器
 *
 *  对象类型是原生类型的情况,其加载器为null
 *
 **/

public class TestJVMLoad16_1 extends ClassLoader{

    private String classLoaderName;

    private final String fileExtension = ".class";

    private String path;

    /**
     * 将系统类加载器当做该类加载器的父加载器
     * @param classLoaderName
     */
    public TestJVMLoad16_1(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    /**
     * 指定某类加载器当做该类加载器的父加载器
     * @param parent
     * @param classLoaderName
     */
    public TestJVMLoad16_1(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "TestJVMLoad16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("cur:"+className);
        System.out.println("cur:"+classLoaderName);
        byte[] data = loadClassData(className);
        return this.defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String className){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            className = className.replace(".","\\");
            is = new FileInputStream(new File(path+className+this.fileExtension));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 != (ch = is.read())){
                baos.write(ch);
            }
            data = baos.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                is.close();
                baos.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        
        return data;
    }

    public static void test(ClassLoader classLoader) throws ClassNotFoundException {
        Class<?> clazz = classLoader.loadClass("com.test.TestJVM.classloader.TestJVMLoad14");
        System.out.println(clazz);
        //为什么当前的类加载器还是appclassloader?
        //因为双亲委托机制,把当前类委托给了其父亲加载了
        System.out.println(clazz.getClassLoader());

        System.out.println(classLoader.toString());
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        /**
         * 当app加载器在classpath下加载不到该class那么就会使用自定义的加载器进行加载
         */
        TestJVMLoad16_1 t16 = new TestJVMLoad16_1("TestCLassLoader");
        t16.setPath("J:\\");
        Class<?> clazz = t16.loadClass("com.test.TestJVM.classloader.TestJVMLoad14");
        System.out.println("class:"+clazz.hashCode());
        System.out.println("class:"+clazz.getClassLoader());

        t16 = null;
        clazz = null;
        System.gc();
        /**
         * 进行类的卸载
         cur:com.test.TestJVM.classloader.TestJVMLoad14
         cur:TestCLassLoader
         class:1265094477
         class:TestJVMLoad16{classLoaderName='TestCLassLoader'}
         [Unloading class com.test.TestJVM.classloader.TestJVMLoad14 0x0000000100061028]
         cur:com.test.TestJVM.classloader.TestJVMLoad14
         cur:TestCLassLoader
         class:692404036
         class:TestJVMLoad16{classLoaderName='TestCLassLoader'}
         */

        t16 = new TestJVMLoad16_1("TestCLassLoader");
        t16.setPath("J:\\");
        clazz = t16.loadClass("com.test.TestJVM.classloader.TestJVMLoad14");
        System.out.println("class:"+clazz.hashCode());
        System.out.println("class:"+clazz.getClassLoader());
    }

}

