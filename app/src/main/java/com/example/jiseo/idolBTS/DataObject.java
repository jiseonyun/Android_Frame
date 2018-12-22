package com.example.jiseo.idolBTS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataObject {
// response class

    @SerializedName("code")
    @Expose
    private int code;



    @SerializedName("datas")
    @Expose
    private List<DataPair> datas;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public List<DataPair> getDatas() {
        return datas;
    }
    public void setDatas(List<DataPair> datas) {
        this.datas = datas;
    }

}
