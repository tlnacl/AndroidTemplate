package nz.co.sush.simplelistdetail.view.activity;

import android.os.Bundle;

import nz.co.sush.simplelistdetail.R;

public class MainActivity extends BaseActivity {

    private static final String LOGIN_STATUS = "login_status";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO
//        final boolean isLogin = mSharedPreferences.getBoolean(LOGIN_STATUS,false);
        mNavigator.navigateToEventList(this);
    }
}
