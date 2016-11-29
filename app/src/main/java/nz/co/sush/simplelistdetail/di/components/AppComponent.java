package nz.co.sush.simplelistdetail.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import nz.co.sush.simplelistdetail.di.modules.ApplicationModule;
import nz.co.sush.simplelistdetail.di.modules.NetworkModule;
import nz.co.sush.simplelistdetail.network.ApiAdapter;
import nz.co.sush.simplelistdetail.view.activity.MainActivity;

/**
 * Created by tom.t on 26/10/16.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface AppComponent {
    void inject(MainActivity mainActivity);

    Context context();
    SharedPreferences preferences();

    ApiAdapter apiAdapter();
}
