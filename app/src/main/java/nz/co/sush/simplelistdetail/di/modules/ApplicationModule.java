package nz.co.sush.simplelistdetail.di.modules;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import nz.co.sush.simplelistdetail.AndroidApplication;
import nz.co.sush.simplelistdetail.JobExecutor;
import nz.co.sush.simplelistdetail.PostExecutionThread;
import nz.co.sush.simplelistdetail.ThreadExecutor;
import nz.co.sush.simplelistdetail.UIThread;
import nz.co.sush.simplelistdetail.view.Navigator;

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

    @Provides
    @Singleton
    SharedPreferences providePreferences() {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    Navigator provideNavigator(){
        return new Navigator();
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
