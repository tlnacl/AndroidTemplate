package nz.co.sush.simplelistdetail;

import android.app.Application;

import com.facebook.stetho.Stetho;

import nz.co.sush.simplelistdetail.di.components.AppComponent;
import nz.co.sush.simplelistdetail.di.components.DaggerAppComponent;
import nz.co.sush.simplelistdetail.di.modules.ApplicationModule;

/**
 * Created by tomtang on 2/11/15.
 */
public class AndroidApplication extends Application {
    private static AppComponent appComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
        Stetho.initializeWithDefaults(this);
    }

    private void initializeInjector() {
        appComponent = DaggerAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
