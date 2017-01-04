package com.sandeep.mvpwithretrofit.view.views.login;

import com.sandeep.mvpwithretrofit.model.server.entities.Login;

/**
 * This is presenter for login activity
 * @author SandeepD
 */
public class LoginPresenterImpl implements LoginPresenter, LoginInteractor.OnLoginFinishedListener
{

    private LoginView loginView;
    private LoginInteractor loginInteractor;

    public LoginPresenterImpl(LoginView loginView)
    {
        this.loginView = loginView;
        this.loginInteractor = new LoginInteractorImpl();
    }

    @Override
    public void validateCredentials(String username, String password)
    {
        if (loginView != null)
        {
            loginView.showProgress();
        }

        loginInteractor.login(username, password, this);
    }

    @Override
    public void onDestroy()
    {
        loginView = null;
    }

    @Override
    public void onUsernameError()
    {
        if (loginView != null)
        {
            loginView.setUsernameError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onPasswordError()
    {
        if (loginView != null)
        {
            loginView.setPasswordError();
            loginView.hideProgress();
        }
    }

    @Override
    public void onSuccess(Login login)
    {
        if (loginView != null)
        {

            loginView.hideProgress();

            if (login != null)
                loginView.navigateToHome();
            else
                loginView.displayLoginError();
        }
    }

    @Override
    public void onFailure(Object obj)
    {
        if (loginView != null)
        {
            loginView.displayLoginError();
            loginView.hideProgress();
        }
    }

}
