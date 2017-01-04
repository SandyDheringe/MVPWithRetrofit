package com.sandeep.mvpwithretrofit.model.server.entities;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Login entity
 *
 * @author SandeepD
 */
public class Login
{

    @SerializedName("token")
    @Expose
    private String token;

    public String getToken()
    {
        return token;
    }

    public void setToken(String token)
    {
        this.token = token;
    }

}


