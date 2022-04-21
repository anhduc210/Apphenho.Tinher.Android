package com.example.tinher2.users_manager;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface SOService {
    @GET("tinher_user")
    Call<List<UserInfor>> getUsersInfor();
}
