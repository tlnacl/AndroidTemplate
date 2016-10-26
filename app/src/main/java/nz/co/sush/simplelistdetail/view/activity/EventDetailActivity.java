package nz.co.sush.simplelistdetail.view.activity;

import android.content.Context;
import android.content.Intent;

import nz.co.sush.simplelistdetail.di.components.AppComponent;

/**
 * Created by tomtang on 2/11/15.
 */
public class EventDetailActivity extends BaseActivity {
    public static Intent getCallingIntent(Context context){
        return new Intent(context,EventDetailActivity.class);
    }

    @Override
    protected int getContentViewResId() {
        return 0;
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {

    }
}
