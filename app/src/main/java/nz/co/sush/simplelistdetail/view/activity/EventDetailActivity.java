package nz.co.sush.simplelistdetail.view.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;

import butterknife.BindView;
import nz.co.sush.simplelistdetail.R;
import nz.co.sush.simplelistdetail.di.components.AppComponent;
import nz.co.sush.simplelistdetail.network.model.Event;

/**
 * Created by tomtang on 2/11/15.
 */
public class EventDetailActivity extends BaseActivity {
    private static final String EVENT = "event";

    @BindView(R.id.event_type)
    TextView eventType;
    @BindView(R.id.is_public)
    TextView isPublic;

    public static Intent getCallingIntent(Context context, Event event) {
        Intent intent = new Intent(context, EventDetailActivity.class);
        intent.putExtra(EVENT, event);
        return intent;
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_event_detail;
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Event event = getIntent().getParcelableExtra(EVENT);
        eventType.setText(getString(R.string.event_id,event.id()));
        isPublic.setText(event.isPublic() ? "true" : "false");
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {

    }
}
