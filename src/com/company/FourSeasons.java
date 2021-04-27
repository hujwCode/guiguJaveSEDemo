package com.company;

import com.company.tread.CountryEnum;
import lombok.Data;
import lombok.Getter;


public enum FourSeasons {

    SPRING(1,"spring"),
    SUMMER(2,"summer"),
    AUTUMN(3,"automn"),
    WINTER(4,"winter");

    @Getter
    private int code;
    @Getter
    private String name;


    FourSeasons(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public static String foreach(int code) {
//        FourSeasons[] fourSeasons = FourSeasons.values();
//        if (code == fourSeasons.) {
//            return "";
//        }
        return "";
    }
}
