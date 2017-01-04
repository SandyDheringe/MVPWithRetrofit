package com.sandeep.mvpwithretrofit.network;


import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.sandeep.mvpwithretrofit.constant.URLConstants.BASE_URL;

/**
 * Rest adapter for creating retrofit's (2.1) rest adapter
 *
 * @author SandeepD
 */
public class RestAdapter
{

    private static volatile RestAdapter instance = null;

    // Trailing slash is needed

    private static Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private RestAdapter()
    {
    }

    public static RestAdapter getInstance()
    {
        if (instance == null)
        {
            synchronized (RestAdapter.class)
            {
                if (instance == null)
                {
                    instance = new RestAdapter();
                }
            }
        }
        return instance;
    }

    public Retrofit getRetrofit()
    {
        return retrofit;
    }


}
