package com.sandeep.mvpwithretrofit.server.rest;

import com.sandeep.mvpwithretrofit.model.server.entities.Login;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Retrofit interface for login API
 *
 * @author SandeepD
 */
public interface LoginAPI
{
    /*{
        "email": "peter@klaven",
            "password": "cityslicka"
    }
*/
    /**
     * Method for retrieving word list using retrofit interface
     */
    @FormUrlEncoded
    @POST("/api/login")
    Call<Login> validateUser(@Field("email") String email, @Field("password") String password);
}
