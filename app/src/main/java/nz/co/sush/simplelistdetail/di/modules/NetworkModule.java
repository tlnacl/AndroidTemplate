package nz.co.sush.simplelistdetail.di.modules;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nz.co.sush.simplelistdetail.network.ApiAdapter;
import retrofit.RestAdapter;

/**
 * Created by tomtang on 2/11/15.
 */
@Module
public class NetworkModule {
    private static final String END_POINT = "https://api.github.com";

    @Provides
    @Singleton
    ApiAdapter provideApiAdapter(){
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(END_POINT)
                .build();
        return restAdapter.create(ApiAdapter.class);
    }
}
