package com.loneos.scenedemo.main_page;

import com.loneos.scenedemo.mvp.IBasePresenter;
import com.loneos.scenedemo.mvp.IBaseView;

/**
 * Created by owais on 12/2/18.
 */

public interface IMainContract {

    interface IPresenter<I extends IBaseView> extends IBasePresenter<IView>{

        void start();
        void userIsNotRegistered();
        void signIn();
        void signUp();
    }

    interface IView extends IBaseView{

        public void showSplash();

        public void showLogin();

        public void showSignUp();

        public void showLoadingScreen();

        public void showEmptyScreen();

        public void goToNextScreen();
    }
}
