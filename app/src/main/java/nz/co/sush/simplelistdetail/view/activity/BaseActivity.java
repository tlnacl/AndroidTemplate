package nz.co.sush.simplelistdetail.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import nz.co.sush.simplelistdetail.AndroidApplication;
import nz.co.sush.simplelistdetail.di.components.AppComponent;

/**
 * Created by tomtang on 2/11/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentViewResId());
        ButterKnife.bind(this);
        setupComponent(AndroidApplication.getAppComponent());
    }

    protected abstract int getContentViewResId();

    protected abstract void setupComponent(AppComponent appComponent);
}
