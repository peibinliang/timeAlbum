package com.time.album.timealbum.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum LabelEnum {
    Recollect(1,"回忆"),
    Travel(2,"游玩"),
    Friend(3,"闺蜜"),
    Landscape(4,"风景"),
    Delicacy(5,"美食"),
    Student(6,"学生时代");

    private final Integer labelId;
    private final String labelName;

    public Integer getLabelId() {
        return labelId;
    }

    public String getLabelName() {
        return labelName;
    }

    public static String getTypeNameByTypeId(Integer typeId){
        for (LabelEnum labelEnum : values()){
            if (labelEnum.labelId == typeId){
                return labelEnum.labelName;
            }
        }
        return null;
    }

    public static Integer getTypeIdByTypeName(String typeName){
        for (LabelEnum labelEnum : values()){
            if (labelEnum.labelName.equals(typeName)){
                return labelEnum.labelId;
            }
        }
        return null;
    }
}
