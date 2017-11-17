package com.example.ankika.practiceforpolosoft;

import android.test.suitebuilder.annotation.LargeTest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Ankika on 11/16/2017.
 */

public interface GetUserService {

    @GET("users")
    Call<List<UserModelForOne>> getModel();
}
