package com.company.tread;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import lombok.Getter;

public enum CountryEnum {
    ONE(1,"秦"),TWO(2,"楚"),THREE(3,"赵")
    ,FOUR(4,"魏国"),FIVE(5,"韩"),SIX(6,"法");

    @Getter private Integer retCode;
    @Getter private String retMsg;

    CountryEnum(Integer retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }
    public static CountryEnum forEach_Country(int index) {
        CountryEnum [] myArray = CountryEnum.values();
        for (CountryEnum countryEnum : myArray) {
            if (index == countryEnum.getRetCode()) {
                return countryEnum;
            }
        }
        return null;
    }
}
