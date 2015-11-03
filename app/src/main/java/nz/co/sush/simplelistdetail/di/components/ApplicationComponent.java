package nz.co.sush.simplelistdetail.di.components;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Component;
import nz.co.sush.simplelistdetail.PostExecutionThread;
import nz.co.sush.simplelistdetail.ThreadExecutor;
import nz.co.sush.simplelistdetail.di.modules.ApplicationModule;
import nz.co.sush.simplelistdetail.di.modules.NetworkModule;
import nz.co.sush.simplelistdetail.network.ApiAdapter;
import nz.co.sush.simplelistdetail.view.activity.BaseActivity;

/**
 * Created by tomtang on 2/11/15.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {
    void inject(BaseActivity activity);

    //Exposed to sub-graphs.
    Context context();
    SharedPreferences preferences();

    ThreadExecutor threadExecutor();

    PostExecutionThread postExecutionThread();

    ApiAdapter apiAdapter();
}
