package com.sandeep.mvpwithretrofit.view.views.login;

/**
 * This is presenter interface for login activity
 * @author SandeepD
 */
public interface LoginPresenter
{
    void validateCredentials(String username, String password);

    void onDestroy();
}
