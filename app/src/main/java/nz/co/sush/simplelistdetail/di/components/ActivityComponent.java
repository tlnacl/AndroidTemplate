package nz.co.sush.simplelistdetail.di.components;

/**
 * Created by tomtang on 3/11/15.
 */

import android.app.Activity;

import dagger.Component;
import nz.co.sush.simplelistdetail.di.PerActivity;
import nz.co.sush.simplelistdetail.di.modules.ActivityModule;

/**
 * A base component upon which fragment's components may depend.
 * Activity-level components should extend this component.
 *
 * Subtypes of ActivityComponent should be decorated with annotation:
 */
@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    //Exposed to sub-graphs.
    Activity activity();
}
