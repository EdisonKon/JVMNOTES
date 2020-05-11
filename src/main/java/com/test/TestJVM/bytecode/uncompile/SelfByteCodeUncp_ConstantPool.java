package com.test.TestJVM.bytecode.uncompile;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-11 11:26
 * @from
 *
 * 获取编译之后16进制字节码的反编译常量池
 **/
public class SelfByteCodeUncp_ConstantPool {
    private static final int CA = 202;
    private static final int FE = 254;
    private static final int BA = 186;
    private static final int BE = 190;

    private Integer[] codeints;
    private List<Integer> listHex;
    private int curIndex;


    public SelfByteCodeUncp_ConstantPool(Integer[] codeints) {
        this.codeints = codeints;
        listHex = Arrays.stream(codeints).collect(Collectors.toList());
    }

    /**
     * 获取常量池数据
     * @return
     */
    public String getConstantPool(){
        StringBuilder Constant_pool = new StringBuilder("Constant pool:");

        int conLen = getHexlistToInt(2);
        Constant_pool.append("常量池大小:"+(conLen-1)+"\n");
        List<ConstantEntity> listce = new ArrayList<>(conLen);
        for (int i = 0; i < conLen - 1; i++) {
            ConstantEntity ce = doGetCpoolStep(i+1);
            listce.add(ce);
        }
        for (ConstantEntity ce :listce) {
            for (ConstantEntity.TureValue tv:ce.getValues()) {
                int tvIndex = tv.getIndex();
                setRemark(listce,tv,tvIndex);
            }
            Constant_pool.append(ce.toString());
        }
        return Constant_pool.toString();
    }

    public ConstantEntity.TureValue setRemark(List<ConstantEntity> listce,ConstantEntity.TureValue tv ,int tvIndex,boolean... add){
        while(tvIndex!=0){
            ConstantEntity cex = listce.get(tvIndex-1);
            String tvMk = cex.getValues().get(0).getValue();
            if(tvMk == null){
                tvIndex = cex.getValues().get(0).getIndex();
                tv = setRemark(listce,tv,tvIndex);
                if(ConstantInfoEnum.CONSTANT_NameAndType_info.equals(cex.getType())){
                    tvIndex = cex.getValues().get(1).getIndex();
                    tv = setRemark(listce,tv,tvIndex,true);
                    tvIndex = 0;
                    continue;
                }
            }else{
                if(add.length>0){
                    tv.setRemark(tv.getRemark()+":"+tvMk);
                }else{
                    tv.setRemark(tvMk);
                }
                tvIndex = 0;
            }
        }
        return tv;
    }

    public ConstantEntity doGetCpoolStep(int constantidx){
        ConstantEntity ce = new ConstantEntity();
        ConstantInfoEnum curInfo = ConstantInfoEnum.getByflag(getHexlistToInt(1));
        ce.setIndex(constantidx);
        ce.setTypeName(curInfo.getName());
        List<ConstantEntity.TureValue> tureValues = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            //Value 1 + value 2
            ConstantEntity.TureValue tureValue = new ConstantEntity.TureValue();
            if(ConstantInfoEnum.ValueTypeEnum.LENGTH.equals(i==0?curInfo.getValue1Type():curInfo.getValue2Type())){
                int nextLen = getHexlistToInt(i==0?curInfo.getValue1Len():curInfo.getValue2Len());
                tureValue.setValue(getHexlistToString(nextLen));
                tureValues.add(tureValue);
                break;
            }else if(ConstantInfoEnum.ValueTypeEnum.INDEX.equals(i==0?curInfo.getValue1Type():curInfo.getValue2Type())){
                tureValue.setIndex(getHexlistToInt(i==0?curInfo.getValue1Len():curInfo.getValue2Len()));
                tureValues.add(tureValue);
            }else if(ConstantInfoEnum.ValueTypeEnum.BYTES.equals(i==0?curInfo.getValue1Type():curInfo.getValue2Type())){
                tureValue.setValue(getHexlistToString(i==0?curInfo.getValue1Len():curInfo.getValue2Len()));
                tureValues.add(tureValue);
                break;
            }else if(ConstantInfoEnum.ValueTypeEnum.NULL.equals(i==0?curInfo.getValue1Type():curInfo.getValue2Type())){
                break;
            }
        }

        ce.setValues(tureValues);
        ce.setType(curInfo);
        curInfo.getValue1Len();

        return ce;
    }

    public void check_info(){
        if (codeints==null||codeints.length==0){
            System.out.println("选中文件是空的!");
        }
        if(codeints.length<4||codeints[0] != CA||codeints[1] != FE||codeints[2] != BA||codeints[3] != BE){
            System.out.println("选中文件不是标准的Java.class!");
        }
        curIndex = 4;
    }
    /**
     * 获取java版本
     * @return
     */
    public String java_version(){
        String minor_version = "minor_version: ";
        String major_version = "major_version: ";
        minor_version += getHexlistToInt(2);
        major_version += getHexlistToInt(2);
        System.out.println(minor_version);
        System.out.println(major_version);

        return minor_version+" , "+major_version;
    }


    /**
     * 获取hexlist 的数值
     * @param ux 代表u几 u1 u2 u4 u8 字节数
     * @return
     */
    private int getHexlistToInt(Integer ux){
        int cur = 0;
        for (int i = 0; i < ux; i++) {
            int innCur = listHex.get(curIndex++);
            for (int j = 1; j < ux-i; j++) {
                innCur *= 256;
            }
            cur += innCur;
        }
        return cur;
    }

    private String getHexlistToString(Integer ux){
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < ux; i++) {
            cur.append((char)listHex.get(curIndex++).intValue());
        }
        return cur.toString();
    }

    public static void main(String[] args) {
    }
}
