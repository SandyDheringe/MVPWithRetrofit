package com.sandeep.mvpwithretrofit.view.views.login;

/**
 * Login view to provide communication between activity and presenter
 */
public interface LoginView
{
    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome();
    void displayLoginError();
}
