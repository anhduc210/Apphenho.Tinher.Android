package com.example.tinher2.users_manager;

public class ApiUtils {
    public static final  String User_Url = "http://demo0297066.mockable.io/";

    public static SOService getSOService() {
        return RetrofitClient.getClient(User_Url).create(SOService.class);
    }
}
