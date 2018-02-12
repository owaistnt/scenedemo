package com.loneos.scenedemo.mvp;

/**
 * Created by owais on 12/2/18.
 */

public interface IBasePresenter<V extends IBaseView> {

    void onAttach(V mvpView);

    void onDetach();

    V getMvpView();

    boolean isViewAttached();
}
