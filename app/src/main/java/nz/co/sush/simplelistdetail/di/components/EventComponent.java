package nz.co.sush.simplelistdetail.di.components;

import dagger.Component;
import nz.co.sush.simplelistdetail.di.PerActivity;
import nz.co.sush.simplelistdetail.di.modules.ActivityModule;
import nz.co.sush.simplelistdetail.view.activity.EventListActivity;

/**
 * Created by tomtang on 3/11/15.
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface EventComponent extends ActivityComponent{
    void inject(EventListActivity activity);
}
