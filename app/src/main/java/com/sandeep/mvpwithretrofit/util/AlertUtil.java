package com.sandeep.mvpwithretrofit.util;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Toast;

import com.sandeep.mvpwithretrofit.R;


/**
 * Utility class o display alert in the application
 * Created by SandeepD on 29-03-2016.
 */
public class AlertUtil
{
    private static AlertUtil mAlertUtil;
    private ProgressDialog progressDialog;

    private AlertUtil()
    {
    }

    public static AlertUtil getInstance()
    {
        if (mAlertUtil == null)
            synchronized (AlertUtil.class)
            {
                if (mAlertUtil == null)
                {
                    mAlertUtil = new AlertUtil();
                }

            }
        return mAlertUtil;
    }

    public void showSnack(View view,int iResourceId)
    {
        Snackbar snackbar = Snackbar
                .make(view, iResourceId, Snackbar.LENGTH_LONG);

        snackbar.show();
    }
    public void showSnack(View view,String strMessage)
    {
        Snackbar snackbar = Snackbar
                .make(view, strMessage, Snackbar.LENGTH_LONG);

        snackbar.show();
    }
    public void showToast(Context context, String msg)
    {
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }

    public void showProgressDialog(Context context, int iMessageId)
    {
        progressDialog = ProgressDialog.show(context, context.getString(R.string.app_name), context.getString(iMessageId));
    }

    public void dismissDialog()
    {
        progressDialog.dismiss();
    }


}
