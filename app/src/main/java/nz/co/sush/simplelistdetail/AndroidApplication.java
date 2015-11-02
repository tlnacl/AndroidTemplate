package nz.co.sush.simplelistdetail;

import android.app.Application;

import nz.co.sush.simplelistdetail.di.components.ApplicationComponent;
import nz.co.sush.simplelistdetail.di.components.DaggerApplicationComponent;
import nz.co.sush.simplelistdetail.di.modules.ApplicationModule;

/**
 * Created by tomtang on 2/11/15.
 */
public class AndroidApplication extends Application {
    private ApplicationComponent applicationComponent;

    @Override public void onCreate() {
        super.onCreate();
        this.initializeInjector();
    }

    private void initializeInjector() {
        this.applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return this.applicationComponent;
    }
}
