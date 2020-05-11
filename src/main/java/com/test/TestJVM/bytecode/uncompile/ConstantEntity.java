package com.test.TestJVM.bytecode.uncompile;

import java.util.List;

/**
 * @author dekai.kong
 * @difficult
 * @create 2020-05-11 15:05
 * @from
 **/
public class ConstantEntity {


    private int index;
    private String typeName;
    private ConstantInfoEnum type;
    private List<TureValue> values;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public List<TureValue> getValues() {
        return values;
    }

    public void setValues(List<TureValue> values) {
        this.values = values;
    }

    public ConstantInfoEnum getType() {
        return type;
    }

    public void setType(ConstantInfoEnum type) {
        this.type = type;
    }

    static class TureValue{
        private int index;
        private String value;
        private String remark;

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }

    @Override
    public String toString() {
        String vlStr = "";
        for (TureValue v :values) {
            if(v.index != 0){
                vlStr+="#"+v.index+" ";
            }else{
                vlStr+=v.value+" ";
            }
        }
        String rmStr = "//";
        for (TureValue v :values) {
            if(v.index==0){
                rmStr = "";
                break;
            }
            rmStr+=v.remark+" ";
        }
        return "#" + index + " = " +
                typeName+"\t\t\t"+
                vlStr+"\t\t\t"+
                rmStr+"\n"
                ;
    }
}
