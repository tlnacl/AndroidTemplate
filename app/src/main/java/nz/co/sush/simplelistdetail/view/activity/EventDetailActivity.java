package nz.co.sush.simplelistdetail.view.activity;

import android.content.Context;
import android.content.Intent;

/**
 * Created by tomtang on 2/11/15.
 */
public class EventDetailActivity extends BaseActivity {
    public static Intent getCallingIntent(Context context){
        return new Intent(context,EventDetailActivity.class);
    }
}
