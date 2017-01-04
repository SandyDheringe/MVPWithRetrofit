package com.sandeep.mvpwithretrofit.view.views.login;

import android.text.TextUtils;

import com.sandeep.mvpwithretrofit.network.RestAdapter;
import com.sandeep.mvpwithretrofit.model.server.entities.Login;
import com.sandeep.mvpwithretrofit.server.rest.LoginAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A service/interactor class for login with network/database
 *
 * @author SandeepD
 */
public class LoginInteractorImpl implements LoginInteractor
{

    @Override
    public void login(final String username, final String password, final OnLoginFinishedListener handler)
    {

        if (TextUtils.isEmpty(username))
        {
            handler.onUsernameError();
            return;
        }
        if (TextUtils.isEmpty(password))
        {
            handler.onPasswordError();
            return;
        }
/*
1.9
        Callback<Login> callback = new Callback<Login>()
        {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response)
            {
                handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t)
            {
                handler.onFailure(null);
            }

        };*/


        Call<Login> call = RestAdapter.getInstance().getRetrofit().create(LoginAPI.class).validateUser(username,password);
        call.enqueue(new Callback<Login>()
        {

            @Override
            public void onResponse(Call<Login> call, Response<Login> response)
            {
                handler.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t)
            {
                handler.onFailure(null);
            }
        });

    }
}
