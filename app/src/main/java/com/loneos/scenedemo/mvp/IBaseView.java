package com.loneos.scenedemo.mvp;

import android.support.annotation.StringRes;

/**
 * Created by owais on 12/2/18.
 */

public interface IBaseView {

    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(@StringRes int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(@StringRes int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

}
