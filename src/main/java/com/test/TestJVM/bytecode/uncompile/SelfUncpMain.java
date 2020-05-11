package com.test.TestJVM.bytecode.uncompile;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-11 11:36
 * @from
 **/
public class SelfUncpMain {
    private String path;
    public SelfUncpMain(String path) {
        this.path = path;
    }

    public Integer[] readFile(){
        List<Integer> listData = new ArrayList<Integer>();
        InputStream is = null;
        Integer[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            is = new FileInputStream(new File(path));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while(-1 != (ch = is.read())){
                listData.add(ch);
            }
            data = listData.toArray(new Integer[listData.size()]);
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

    public String doUncpToByteCode(){
        Integer[] hexCode = readFile();
        System.out.println("生成的16进制字节码: ");
        for (Integer x:hexCode) {
            System.out.print(x+" ");
        }
        SelfByteCodeUncp_ConstantPool sc = new SelfByteCodeUncp_ConstantPool(hexCode);
        sc.check_info();
        System.out.println("java_version = " + sc.java_version());
        System.out.println("Constant Pool = " + sc.getConstantPool());
        return null;
    }

    public String doUncpToJava(){
        return null;
    }

    public static void main(String[] args) {
        System.out.println((char)202);
        SelfUncpMain main = new SelfUncpMain("/Users/edison/github/JVMNOTES/target/classes/com/test/TestJVM/bytecode/MyTest1.class");
        String strcodebyte =  main.doUncpToByteCode();
        System.out.println("strcodebyte = " + strcodebyte);
    }
}
