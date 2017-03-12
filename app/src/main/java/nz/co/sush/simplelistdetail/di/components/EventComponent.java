package nz.co.sush.simplelistdetail.di.components;

import dagger.Component;
import nz.co.sush.simplelistdetail.di.PerActivity;
import nz.co.sush.simplelistdetail.view.fragment.EventListFragment;

/**
 * Created by tom.t on 26/10/16.
 */
@PerActivity
@Component(dependencies = {AppComponent.class})
public interface EventComponent {
    void inject(EventListFragment eventListFragment);
}
