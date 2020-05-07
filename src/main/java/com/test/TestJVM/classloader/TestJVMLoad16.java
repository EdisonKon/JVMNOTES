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

public class TestJVMLoad16 extends ClassLoader{

    private String classLoaderName;

    private final String fileExtension = ".class";

    /**
     * 将系统类加载器当做该类加载器的父加载器
     * @param classLoaderName
     */
    public TestJVMLoad16( String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    /**
     * 指定某类加载器当做该类加载器的父加载器
     * @param parent
     * @param classLoaderName
     */
    public TestJVMLoad16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    @Override
    public String toString() {
        return "TestJVMLoad16{" +
                "classLoaderName='" + classLoaderName + '\'' +
                '}';
    }

    @Override
    protected Class<?> findClass(String className) throws ClassNotFoundException {
        byte[] data = loadClassData(className);
        return this.defineClass(className,data,0,data.length);
    }

    private byte[] loadClassData(String className){
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            this.classLoaderName = this.classLoaderName.replace(",","/");
            is = new FileInputStream(new File(className+this.fileExtension));
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
         * 输出：
         * null
         * ------------------
         * sun.misc.Launcher$AppClassLoader@18b4aac2
         * ------------------
         * null
         */
        TestJVMLoad16 t16 = new TestJVMLoad16("TestCLassLoader");

        test(t16);

    }

}

