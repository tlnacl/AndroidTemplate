package nz.co.sush.simplelistdetail.di.components;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import nz.co.sush.simplelistdetail.MainActivity;
import nz.co.sush.simplelistdetail.PostExecutionThread;
import nz.co.sush.simplelistdetail.ThreadExecutor;
import nz.co.sush.simplelistdetail.di.modules.ApplicationModule;

/**
 * Created by tomtang on 2/11/15.
 */
@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MainActivity activity);

    //Exposed to sub-graphs.
    Context context();
    ThreadExecutor threadExecutor();
    PostExecutionThread postExecutionThread();
}
