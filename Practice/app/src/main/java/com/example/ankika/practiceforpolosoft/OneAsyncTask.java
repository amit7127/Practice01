package com.example.ankika.practiceforpolosoft;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ankika on 11/16/2017.
 */

public class OneAsyncTask extends AsyncTask<Object, Void, List<UserModelForOne>> {
    Context context;
    GetUserListener getUserListener;

    public void setListener(GetUserListener listener){
        getUserListener = listener;
    }

    public OneAsyncTask(Context context) {
        this.context = context;
    }

    @Override
    protected List<UserModelForOne> doInBackground(Object[] objects) {

        List<UserModelForOne> userModelForOnes = null;

        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(5000, TimeUnit.SECONDS)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .build();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build();

        GetUserService getUserService = retrofit.create(GetUserService.class);
        Call<List<UserModelForOne>> call = getUserService.getModel();
        call.enqueue(new Callback<List<UserModelForOne>>() {
            @Override
            public void onResponse(Call<List<UserModelForOne>> call, Response<List<UserModelForOne>> response) {
                if (response.code() == 200) {
                    Toast.makeText(context, "Successsssssss.....", Toast.LENGTH_SHORT).show();

                    onPostExecute(response.body());

                } else {
                    Toast.makeText(context, "Failssssss.....", Toast.LENGTH_SHORT).show();

                    onPostExecute(null);
                }
            }

            @Override
            public void onFailure(Call<List<UserModelForOne>> call, Throwable t) {
                Toast.makeText(context, "Fail.....", Toast.LENGTH_SHORT).show();
            }
        });

        return null;
    }

    @Override
    protected void onPostExecute(List<UserModelForOne> forOneList) {
        if (forOneList != null) {
            getUserListener.userFetched(forOneList);
        }

        super.onPostExecute(forOneList);
    }
}
