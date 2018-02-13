package com.loneos.scenedemo.main_page;

import android.os.CountDownTimer;

/**
 * Created by owais on 12/2/18.
 */

public class MainPresenter implements IMainContract.IPresenter<IMainContract.IView>{
    IMainContract.IView mView;
    @Override
    public void onAttach(IMainContract.IView mvpView) {
        this.mView = mvpView;
    }

    @Override
    public void onDetach() {
        this.mView = null;
    }

    @Override
    public IMainContract.IView getMvpView() {
        return mView;
    }

    @Override
    public boolean isViewAttached() {
        return (mView!=null);
    }

    @Override
    public void start() {
        getMvpView().showSplash();
        new CountDownTimer(3000, 1000){

            @Override
            public void onTick(long l) {

            }

            @Override
            public void onFinish() {
                getMvpView().showLogin();
            }
        }.start();
    }

    @Override
    public void userIsNotRegistered() {
        getMvpView().showSignUp();
    }

    @Override
    public void signIn() {
            getMvpView().showLoadingScreen();
            new CountDownTimer(3000, 1000){

                @Override
                public void onTick(long l) {

                }

                @Override
                public void onFinish() {
                    if (getMvpView().isNetworkConnected()) {
                        getMvpView().goToNextScreen();
                    }else{
                        getMvpView().showEmptyScreen();
                    }
            }
        }.start();
    }

    @Override
    public void signUp() {
        signIn();
    }
}
