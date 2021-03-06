package nz.co.sush.simplelistdetail.view;

/**
 * Created by tomtang on 3/11/15.
 */

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;
import javax.inject.Singleton;

import nz.co.sush.simplelistdetail.network.model.Event;
import nz.co.sush.simplelistdetail.view.activity.EventDetailActivity;
import nz.co.sush.simplelistdetail.view.activity.EventListActivity;

/**
 * Class used to navigate through the application.
 */
@Singleton
public class Navigator {

    @Inject
    public void Navigator() {
        //empty
    }

    public void navigateToEventList(Context context){
        Intent intentToLaunch = EventListActivity.getCallingIntent(context);
        context.startActivity(intentToLaunch);
    }

    public void navigateToEventDetail(Context context, Event event) {
        Intent intentToLaunch = EventDetailActivity.getCallingIntent(context,event);
        context.startActivity(intentToLaunch);
    }
}
