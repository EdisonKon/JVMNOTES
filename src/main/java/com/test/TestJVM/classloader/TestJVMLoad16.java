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

    private String path;

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
        System.out.println("cur class:"+className);
        System.out.println("cur classloader:"+classLoaderName);
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
//        TestJVMLoad16 t16 = new TestJVMLoad16("TestCLassLoader");
//        t16.setPath("J:\\Work\\GITHUB\\JVMNOTES\\target\\classes\\com\\test\\TestJVM\\classloader\\");
        /**
         * 当app加载器在classpath下加载不到该class那么就会使用自定义的加载器进行加载
         */
        TestJVMLoad16 t16 = new TestJVMLoad16("TestCLassLoader");
        t16.setPath("J:\\");
        Class<?> clazz = t16.loadClass("com.test.TestJVM.classloader.TestJVMLoad14");
        System.out.println("class:"+clazz.hashCode());
        System.out.println("class:"+clazz.getClassLoader());

        TestJVMLoad16 t162 = new TestJVMLoad16("TestCLassLoader2");
        t162.setPath("J:\\");
        Class<?> clazz2 = t162.loadClass("com.test.TestJVM.classloader.TestJVMLoad14");
        System.out.println("class2:"+clazz2.hashCode());
        System.out.println("class2:"+clazz2.getClassLoader());

        /**
         * ###类加载器命名空间
         1. 每个**类加载器实例**都有自己的命名空间 **命名空间由该加载器及所有父加载器所加载的类组成**
         2. 在同一个命名空间中，不会出现类的完整名字（包括类的包名的名称）相同的两个类
         3. 在不同命名空间中，有可能出现类的完整名字（包括类的包名的名称）相同的两个类

         删掉target中的TestJVMLoad14.class后 系统类加载器（appclassloader）无法加载到该类（classpath下找不到），所以由自定义类加载器进行加载
         当前输出：
         cur:com.test.TestJVM.classloader.TestJVMLoad14
         cur:TestCLassLoader
         class:1265094477
         class:TestJVMLoad16{classLoaderName='TestCLassLoader'}
         cur:com.test.TestJVM.classloader.TestJVMLoad14
         cur:TestCLassLoader2
         class2:692404036
         class2:TestJVMLoad16{classLoaderName='TestCLassLoader2'}
         输出这个的原因在于两个自定义类加载器实例是不同的命名空间
         */

        TestJVMLoad16 t161 = new TestJVMLoad16("TestCLassLoader161");
        t161.setPath("J:\\");
        Class<?> clazz1 = t161.loadClass("com.test.TestJVM.classloader.TestJVMLoad14");
        System.out.println("class1:"+clazz1.hashCode());
        System.out.println("class1:"+clazz1.getClassLoader());

        /**
         * 调用了传入父类的方法，使t161成为了t1612的父加载器，输出为：
         * cur:com.test.TestJVM.classloader.TestJVMLoad14
         * cur:TestCLassLoader
         * class:1265094477
         * class:TestJVMLoad16{classLoaderName='TestCLassLoader'}
         * class2:1265094477
         * class2:TestJVMLoad16{classLoaderName='TestCLassLoader'}
         * 可知先去找父类是否加载过该类，加载过就不再次进行加载
         */
        TestJVMLoad16 t1612 = new TestJVMLoad16(t161,"TestCLassLoader1612");
        t1612.setPath("J:\\");
        Class<?> clazz12 = t1612.loadClass("com.test.TestJVM.classloader.TestJVMLoad14");
        System.out.println("class12:"+clazz12.hashCode());
        System.out.println("class12:"+clazz12.getClassLoader());


//        test(t16);

    }

}

