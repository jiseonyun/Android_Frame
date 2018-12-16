package com.example.jiseo.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
public class DataPair {
    @SerializedName("id")
            @Expose
    private Integer id;

    @SerializedName("target_id")
    @Expose
    private Integer target_id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("source")
    @Expose
    private String source;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("update_at")
    @Expose
    private String update_at;

    @SerializedName("create_at")
    @Expose
    private String create_at;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTarget_id() {
        return target_id;
    }

    public void setTarget_id(int target_id) {
        this.target_id = target_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(String update_at) {
        this.update_at = update_at;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public DataPair(String title, String image, int id)
    {
        this.title= title;
        this.image= image;
        this.id= id;
    }
    private boolean favorite = false;
    public void Save(){
        //internal save
    }
    public void TEST(String text){
        title =  text + "id: "+ id;
    }
}


