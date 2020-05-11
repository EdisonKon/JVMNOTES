package com.test.TestJVM.bytecode.uncompile;

public enum ConstantInfoEnum {

    /**
     *
     */
    CONSTANT_Utf8_info("CONSTANT_Utf8_info",2,0,ValueTypeEnum.LENGTH,ValueTypeEnum.BYTES,1),
    CONSTANT_Integer_info("CONSTANT_Integer_info",4,0,ValueTypeEnum.BYTES,ValueTypeEnum.NULL,3),
    CONSTANT_Float_info("CONSTANT_Float_info",4,0,ValueTypeEnum.BYTES,ValueTypeEnum.NULL,4),
    CONSTANT_Long_info("CONSTANT_Long_info",8,0,ValueTypeEnum.BYTES,ValueTypeEnum.NULL,5),
    CONSTANT_Double_info("CONSTANT_Double_info",8,0,ValueTypeEnum.BYTES,ValueTypeEnum.NULL,6),
    CONSTANT_Class_info("CONSTANT_Class_info",2,0,ValueTypeEnum.INDEX,ValueTypeEnum.NULL,7),
    CONSTANT_String_info("CONSTANT_String_info",2,0,ValueTypeEnum.INDEX,ValueTypeEnum.NULL,8),
    CONSTANT_Fieldref_info("CONSTANT_Fieldref_info",2,2,ValueTypeEnum.INDEX,ValueTypeEnum.INDEX,9),
    CONSTANT_Methodref_info("CONSTANT_Methodref_info",2,2,ValueTypeEnum.INDEX,ValueTypeEnum.INDEX,10),
    CONSTANT_InrerfaceMethodref_info("CONSTANT_InrerfaceMethodref_info",2,2,ValueTypeEnum.INDEX,ValueTypeEnum.INDEX,11),
    CONSTANT_NameAndType_info("CONSTANT_NameAndType_info",2,2,ValueTypeEnum.INDEX,ValueTypeEnum.INDEX,12),
    ;
    private String name;
    private int value1Len;
    private int value2Len;
    private ValueTypeEnum value1Type;
    private ValueTypeEnum value2Type;
    private int flag;

    ConstantInfoEnum(String name, int value1Len, int value2Len, ValueTypeEnum value1Type, ValueTypeEnum value2Type, int flag) {
        this.name = name;
        this.value1Len = value1Len;
        this.value2Len = value2Len;
        this.value1Type = value1Type;
        this.value2Type = value2Type;
        this.flag = flag;
    }

    public static ConstantInfoEnum getByflag(int flag){
        ConstantInfoEnum[] arr = values();
        int len = arr.length;

        for (int i = 0; i < len; ++i) {
            ConstantInfoEnum s = arr[i];
            if (s.getFlag()==(flag)) {
                return s;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getValue1Len() {
        return value1Len;
    }

    public void setValue1Len(int value1Len) {
        this.value1Len = value1Len;
    }

    public int getValue2Len() {
        return value2Len;
    }

    public void setValue2Len(int value2Len) {
        this.value2Len = value2Len;
    }

    public ValueTypeEnum getValue1Type() {
        return value1Type;
    }

    public void setValue1Type(ValueTypeEnum value1Type) {
        this.value1Type = value1Type;
    }

    public ValueTypeEnum getValue2Type() {
        return value2Type;
    }

    public void setValue2Type(ValueTypeEnum value2Type) {
        this.value2Type = value2Type;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    enum ValueTypeEnum{
        INDEX,
        LENGTH,
        BYTES,
        NULL,
        ;
        private int index;

        ValueTypeEnum(int index) {
            this.index = index;
        }

        ValueTypeEnum() {

        }
    }


    /**
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_Utf8_info                  tag                 u1                  值为1
                                        length              u2                  UF-8编码的字符串占用的字节数
                                        bytes               u1                  长度为length的UTF-8编码的字符串
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_Integer_info               tag                 u1                  值为3
                                        bytes               u4                  按照高位在前存储的int值
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_Float_info                 tag                 u1                  值为4
                                        bytes               u4                  按照高位在前存储的float值
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_Long_info                  tag                 u1                  值为5
                                        bytes               u8                  按照高位在前存储的long值
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_Double_info                tag                 u1                  值为6
                                        bytes               u8                  按照高位在前存储的double值
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_Class_info                 tag                 u1                  值为7
                                        index               u2                  指向全限定名常量项的索引
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_String_info                tag                 u1                  值为8
                                        index               u2                  指向字符串字面量的索引
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_Fieldref_info              tag                 u1                  值为9
                                        index               u2                  指向声明字段的类或接口描述符CONSTANT_Class_info的索引项
                                        index               u2                  指向字段名称及类型描述符CONSTANT_NameAndType_info的索引项
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_Methodref_info             tag                 u1                  值为10
                                        index               u2                  指向声明方法的类描述符CONSTANT_Class_info的索引项
                                        index               u2                  指向方法名称及类型描述符CONSTANT_NameAndType_info的索引项
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_InrerfaceMethodref_info    tag                 u1                  值为11
                                        index               u2                  指向声明方法的接口描述符CONSTANT_Class_info的索引项
                                        index               u2                  指向方法名称及类型描述符CONSTANT_NameAndType_info的索引项
    -----------------------------------------------------------------------------------------------------------
    CONSTANT_NameAndType_info           tag                 u1                  值为12
    其表示为成员变量/方法                 index               u2                  指向字段或方法名称常量项目的索引
                                        index               u2                  指向该字段或方法描述符常量项的索引
    -----------------------------------------------------------------------------------------------------------
 */
}
