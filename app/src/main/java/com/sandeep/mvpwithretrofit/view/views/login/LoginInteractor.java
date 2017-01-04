package com.sandeep.mvpwithretrofit.view.views.login;

import com.sandeep.mvpwithretrofit.model.server.entities.Login;

/**
 * A service/interactor interface for login with network/database
 *
 * @author SandeepD
 */
public interface LoginInteractor
{

    void login(String username, String password, OnLoginFinishedListener listener);

    interface OnLoginFinishedListener
    {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(Login login);
        void onFailure(Object obj);
    }

}
