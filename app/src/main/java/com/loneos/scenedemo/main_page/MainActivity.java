package com.loneos.scenedemo.main_page;

import android.os.Bundle;

import com.loneos.scenedemo.R;
import com.loneos.scenedemo.base.BaseActivity;

public class MainActivity extends BaseActivity implements IMainContract.IView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public void showSplash() {
        
    }

    @Override
    public void showLogin() {

    }

    @Override
    public void showSignUp() {

    }

    @Override
    public void showLoadingScreen() {

    }

    @Override
    public void showEmptyScreen() {

    }

    @Override
    public void goToNextScreen() {

    }
}
