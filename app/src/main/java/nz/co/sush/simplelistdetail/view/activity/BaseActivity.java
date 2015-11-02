package nz.co.sush.simplelistdetail.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import nz.co.sush.simplelistdetail.AndroidApplication;
import nz.co.sush.simplelistdetail.di.components.ApplicationComponent;
import nz.co.sush.simplelistdetail.network.ApiAdapter;

/**
 * Created by tomtang on 2/11/15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Inject
    ApiAdapter mApiAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getApplicationComponent().inject(this);
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((AndroidApplication)getApplication()).getApplicationComponent();
    }
}