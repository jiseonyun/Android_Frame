package com.example.jiseo.idolBTS;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPair_chat {
    @SerializedName("target_id")
    @Expose
    private Integer target_id;

    @SerializedName("userid")
    @Expose
    private String userid;

    @SerializedName("content")
    @Expose
    private String content;
}
