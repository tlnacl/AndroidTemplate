package nz.co.sush.simplelistdetail.view.activity;

import android.os.Bundle;

import javax.inject.Inject;

import nz.co.sush.simplelistdetail.AndroidApplication;
import nz.co.sush.simplelistdetail.R;
import nz.co.sush.simplelistdetail.di.components.AppComponent;
import nz.co.sush.simplelistdetail.view.Navigator;

public class MainActivity extends BaseActivity {
    @Inject
    Navigator mNavigator;
    private static final String LOGIN_STATUS = "login_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //TODO
//        final boolean isLogin = mSharedPreferences.getBoolean(LOGIN_STATUS,false);
        mNavigator.navigateToEventList(this);
    }

    @Override
    protected int getContentViewResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setupComponent(AppComponent appComponent) {
        AndroidApplication.getAppComponent().inject(this);
    }
}
