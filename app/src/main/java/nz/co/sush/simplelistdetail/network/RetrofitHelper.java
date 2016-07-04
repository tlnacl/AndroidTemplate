package nz.co.sush.simplelistdetail.network;


import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tomtang on 2/11/15.
 */
public class RetrofitHelper {
    private static final String END_POINT = "https://api.github.com";
    private static ApiAdapter sApiAdapter;

    public static ApiAdapter getApiAdapter() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        if (sApiAdapter == null) {
            Retrofit restAdapter = new Retrofit.Builder()
                    .client(okHttpClient)
                    .baseUrl(END_POINT)
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            sApiAdapter = restAdapter.create(ApiAdapter.class);
        }
        return sApiAdapter;
    }
}
