package com.sandeep.mvpwithretrofit.view.views.login;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.widget.ProgressBar;

import com.sandeep.mvpwithretrofit.R;
import com.sandeep.mvpwithretrofit.util.AlertUtil;

/**
 * This is simple login activity which accept user name and password from user
 *
 * @author SandeepD
 */
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener
{

    private ProgressBar progressBar;
    private AppCompatEditText username;
    private AppCompatEditText password;
    private LoginPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //progressBar = (ProgressBar) findViewById(R.id.progress);
        username = (AppCompatEditText) findViewById(R.id.username);
        password = (AppCompatEditText) findViewById(R.id.password);
        findViewById(R.id.button).setOnClickListener(this);

        presenter = new LoginPresenterImpl(this);
    }

    @Override
    protected void onDestroy()
    {
        presenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void showProgress()
    {
        AlertUtil.getInstance().showProgressDialog(this, R.string.title_loading);
    }

    @Override
    public void hideProgress()
    {
        AlertUtil.getInstance().dismissDialog();
    }

    @Override
    public void setUsernameError()
    {
        username.setError("user invalid");
    }

    @Override
    public void setPasswordError()
    {
        password.setError("pwd invalid");
    }

    @Override
    public void navigateToHome()
    {
        //startActivity(new Intent(this, MainActivity.class));
        //finish();

        AlertUtil.getInstance().showToast(this,"Login successful");
    }

    @Override
    public void displayLoginError()
    {
        AlertUtil.getInstance().showToast(this,"Error in login");
    }

    @Override
    public void onClick(View v)
    {
        presenter.validateCredentials(username.getText().toString(), password.getText().toString());
    }
}
