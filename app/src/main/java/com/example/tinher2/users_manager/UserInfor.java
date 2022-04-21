
package com.example.tinher2.users_manager;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserInfor {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("preface")
    @Expose
    private String preface;
    @SerializedName("tdx")
    @Expose
    private String tdx;
    @SerializedName("tdy")
    @Expose
    private String tdy;
    @SerializedName("user_search")
    @Expose
    private String userSearch;
    @SerializedName("id_love")
    @Expose
    private String idLove;
    @SerializedName("id_like")
    @Expose
    private String idLike;
    @SerializedName("id_unlike")
    @Expose
    private String idUnlike;
    @SerializedName("id_likeback")
    @Expose
    private String idLikeback;
    @SerializedName("image1")
    @Expose
    private String image1;
    @SerializedName("image2")
    @Expose
    private String image2;
    @SerializedName("image3")
    @Expose
    private String image3;
    @SerializedName("image4")
    @Expose
    private String image4;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserInfor() {
    }

    /**
     *
     * @param idLike
     * @param preface
     * @param image3
     * @param image4
     * @param sex
     * @param tdy
     * @param tdx
     * @param image1
     * @param image2
     * @param idLikeback
     * @param password
     * @param phone
     * @param name
     * @param userSearch
     * @param id
     * @param idUnlike
     * @param age
     * @param idLove
     */
    public UserInfor(String id, String phone, String password, String name, String age, String sex, String preface, String tdx, String tdy, String userSearch, String idLove, String idLike, String idUnlike, String idLikeback, String image1, String image2, String image3, String image4) {
        super();
        this.id = id;
        this.phone = phone;
        this.password = password;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.preface = preface;
        this.tdx = tdx;
        this.tdy = tdy;
        this.userSearch = userSearch;
        this.idLove = idLove;
        this.idLike = idLike;
        this.idUnlike = idUnlike;
        this.idLikeback = idLikeback;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.image4 = image4;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPreface() {
        return preface;
    }

    public void setPreface(String preface) {
        this.preface = preface;
    }

    public String getTdx() {
        return tdx;
    }

    public void setTdx(String tdx) {
        this.tdx = tdx;
    }

    public String getTdy() {
        return tdy;
    }

    public void setTdy(String tdy) {
        this.tdy = tdy;
    }

    public String getUserSearch() {
        return userSearch;
    }

    public void setUserSearch(String userSearch) {
        this.userSearch = userSearch;
    }

    public String getIdLove() {
        return idLove;
    }

    public void setIdLove(String idLove) {
        this.idLove = idLove;
    }

    public String getIdLike() {
        return idLike;
    }

    public void setIdLike(String idLike) {
        this.idLike = idLike;
    }

    public String getIdUnlike() {
        return idUnlike;
    }

    public void setIdUnlike(String idUnlike) {
        this.idUnlike = idUnlike;
    }

    public String getIdLikeback() {
        return idLikeback;
    }

    public void setIdLikeback(String idLikeback) {
        this.idLikeback = idLikeback;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

}