package nz.co.sush.simplelistdetail.di.modules;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nz.co.sush.simplelistdetail.AndroidApplication;
import nz.co.sush.simplelistdetail.JobExecutor;
import nz.co.sush.simplelistdetail.PostExecutionThread;
import nz.co.sush.simplelistdetail.ThreadExecutor;
import nz.co.sush.simplelistdetail.UIThread;

/**
 * Created by tomtang on 2/11/15.
 */
@Module
public class ApplicationModule {
    private final AndroidApplication application;

    public ApplicationModule(AndroidApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return this.application;
    }

    @Provides @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides @Singleton
    PostExecutionThread providePostExecutionThread(UIThread uiThread) {
        return uiThread;
    }
}
