package com.example.demo2;

import java.sql.Date;

public class CarRegistrationinfomodel{


    Integer REGISTRATION_NO;
    String MODEL_NAME;
    String MODEL_COLOUR;

    String MODEL_NO;
    String RENT_PER_DAY;

    public CarRegistrationinfomodel(Integer RegId, String Tb_ModNa , String Tb_Colour, String Tb_Num, String Tb_Rent){

        this.REGISTRATION_NO=RegId;
        this.MODEL_NAME=Tb_ModNa;
        this.MODEL_COLOUR=Tb_Colour;
        this.MODEL_NO=Tb_Num;
        this.RENT_PER_DAY=Tb_Rent;

    }

    public Integer getREGISTRATION_NO() {
        return REGISTRATION_NO;
    }

    public String getMODEL_NAME() {
        return MODEL_NAME;
    }
    public String getMODEL_COLOUR() {
        return MODEL_COLOUR;
    }


    public String getMODEL_NO() {
        return MODEL_NO;
    }

    public String getRENT_PER_DAY() {return RENT_PER_DAY;}



    public void setREGISTRATION_NO(Integer REGISTRATION_NO) {
        REGISTRATION_NO = REGISTRATION_NO;
    }

    public void setMODEL_NAME(String MODEL_NAME) {
        MODEL_NAME = MODEL_NAME;
    }
    public void setMODEL_COLOUR(String MODEL_NAME) {
        MODEL_COLOUR = MODEL_COLOUR;
    }


    public void setMODEL_NO(String MODEL_NO ) {
        MODEL_NO = MODEL_NO;
    }

    public void setRENT_PER_DAY(String RENT_PER_DAY) {RENT_PER_DAY = RENT_PER_DAY;
    }
}
