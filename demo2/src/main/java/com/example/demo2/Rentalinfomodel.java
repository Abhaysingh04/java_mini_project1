package com.example.demo2;

public class Rentalinfomodel{

    Integer REGISTRATION_ID;
    Integer CUSTOMER_ID;
    String DATE;

    Integer  NO_OF_DAYS;
    Integer TOTAL_RENT;

    public Rentalinfomodel(Integer RegId, Integer CustId , String CustDate, Integer Cust_Days, Integer Cust_Rent){

        this.REGISTRATION_ID=RegId;

        this.CUSTOMER_ID=CustId;

        this.DATE=CustDate;

        this.NO_OF_DAYS=Cust_Days;

        this.TOTAL_RENT=Cust_Rent;

    }

    public Integer getREGISTRATION_NO() {
        return REGISTRATION_ID;
    }

    public Integer getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }
    public String getDATE() {
        return DATE;
    }


    public Integer getNO_OF_DAYS() {
        return NO_OF_DAYS;
    }

    public Integer getRENT_PER_DAY() {
        return TOTAL_RENT;}



    public void setREGISTRATION_ID(Integer REGISTRATION_ID) {
        REGISTRATION_ID = REGISTRATION_ID;
    }

    public void setCUSTOMER_ID(Integer CUSTOMER_ID) {
        CUSTOMER_ID = CUSTOMER_ID;
    }
    public void getNO_OF_DAYS(Integer NO_OF_DAYS) {
        NO_OF_DAYS = NO_OF_DAYS;
    }



    public void setTOTAL_RENT(Integer TOTAL_RENT) {TOTAL_RENT = TOTAL_RENT;}


    public void getDATE(String DATE) {
        DATE = DATE;
    }
}
