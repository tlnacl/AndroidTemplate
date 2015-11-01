package nz.co.sush.simplelistdetail.network;

import retrofit.RestAdapter;

/**
 * Created by tomtang on 2/11/15.
 */
public class RetrofitHelper {
    private static final String END_POINT = "https://api.github.com";
    private static ApiAdapter sApiAdapter;

    public static ApiAdapter getApiAdapter() {
        if (sApiAdapter == null) {
            RestAdapter restAdapter = new RestAdapter.Builder()
                    .setEndpoint(END_POINT)
                    .build();
            sApiAdapter = restAdapter.create(ApiAdapter.class);
        }
        return sApiAdapter;
    }
}
