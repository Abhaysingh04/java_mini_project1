package com.example.demo2;

public class returnmodel {
    Integer Return_custid;
    Integer Return_r_id;
    Integer Return_Tamount;

    Integer Return_NOD;
    String Return_DOP;

    public returnmodel(Integer return_custid, Integer return_days, Integer return_Tamount, Integer return_r_id, String return_DOP) {

        this.Return_custid = return_custid;

        this.Return_NOD =return_days;

        this.Return_Tamount = return_Tamount;

        this.Return_r_id = return_r_id;

        this.Return_DOP = return_DOP;

    }

    public Integer getReturn_custid() {
        return Return_custid;
    }

    public Integer getReturn_NOD() {
        return Return_NOD;
    }

    public Integer getReturn_Tamount() {
        return Return_Tamount;
    }


    public Integer getReturn_r_id() {
        return Return_r_id;
    }

    public String getReturn_DOP() {
        return Return_DOP;
    }


    public void setReturn_custid(Integer return_custid) {
        Return_custid = return_custid;
    }

    public void setReturn_NOD(Integer return_NOD) {
        Return_NOD = return_NOD;
    }

    public void setReturn_Tamount(Integer return_Tamount) {
        Return_Tamount = return_Tamount;
    }

    public void setReturn_DOP(String return_DOP) {
        Return_DOP = return_DOP;
    }


    public void setReturn_r_id(Integer return_r_id) {
        Return_r_id = return_r_id;
    }
}

