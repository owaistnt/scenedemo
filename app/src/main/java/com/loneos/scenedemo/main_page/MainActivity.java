package com.loneos.scenedemo.main_page;

import android.os.Bundle;
import android.support.animation.DynamicAnimation;
import android.support.animation.SpringAnimation;
import android.support.transition.ChangeBounds;
import android.support.transition.Scene;
import android.support.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;

import com.loneos.scenedemo.R;
import com.loneos.scenedemo.base.BaseActivity;

public class MainActivity extends BaseActivity implements IMainContract.IView{

    IMainContract.IPresenter mPresenter;
    Scene mSceneSplash, mSceneLogin, mSceneSignUp, mSceneLoading, mSceneEmpty;
    private ViewGroup mSceneRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadScenes();
        mPresenter = new MainPresenter();
        mPresenter.onAttach(this);
        mPresenter.start();
    }

    private void loadScenes(){
        mSceneRoot = findViewById(R.id.actMain_sceneRoot);
        mSceneSplash = Scene.getSceneForLayout(mSceneRoot, R.layout.layout_splash, MainActivity.this);
        mSceneEmpty= Scene.getSceneForLayout(mSceneRoot, R.layout.layout_empty, MainActivity.this);
        mSceneLoading= Scene.getSceneForLayout(mSceneRoot, R.layout.layout_loading, MainActivity.this);
        mSceneLogin= Scene.getSceneForLayout(mSceneRoot, R.layout.layout_sign_in, MainActivity.this);
        mSceneSignUp= Scene.getSceneForLayout(mSceneRoot, R.layout.layout_sign_up, MainActivity.this);
    }


    @Override
    public void showSplash() {
        //mSceneSplash.enter();
        TransitionManager.go(mSceneSplash);
        mSceneSplash.getSceneRoot().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogin();
            }
        });
    }

    @Override
    public void showLogin() {
        //Way 1
        //mSceneLogin.enter();

        //Way 2
       /* TransitionManager transitionManager = new TransitionManager();
        transitionManager.setTransition(mSceneSplash, mSceneLogin, new ChangeBounds());
        transitionManager.transitionTo(mSceneLogin);*/
       enterAnimation();
       TransitionManager.go(mSceneLogin, new ChangeBounds());
        Button btnSignIn = mSceneLogin.getSceneRoot().findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.signIn();
            }
        });

        Button btnSignUp = mSceneLogin.getSceneRoot().findViewById(R.id.btnSignUp);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.userIsNotRegistered();
            }
        });





    }

    private void enterAnimation(){
        mSceneLogin.setEnterAction(new Runnable() {
            @Override
            public void run() {
                //todo Animate Textviews.
                View view =mSceneLogin.getSceneRoot().findViewById(R.id.editText);
                View view2 =mSceneLogin.getSceneRoot().findViewById(R.id.editText2);
                AnimationSet animationSet = (AnimationSet) AnimationUtils.loadAnimation(MainActivity.this, R.anim.translate_up);
                view.startAnimation(animationSet);
                view2.startAnimation(animationSet);
                SpringAnimation slide;
                slide = new SpringAnimation(view, DynamicAnimation.TRANSLATION_Y, 0);
                slide.getSpring().setDampingRatio(0.4f).setStiffness(500);
                slide.setStartValue(400).start();
            }
        });
    }

    @Override
    public void showSignUp() {
        mSceneSignUp.enter();
        Button btnSignIn = mSceneLogin.getSceneRoot().findViewById(R.id.btnSignUp);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.signUp();
            }
        });
    }

    @Override
    public void showLoadingScreen() {
        mSceneLoading.enter();
    }

    @Override
    public void showEmptyScreen() {
        mSceneEmpty.enter();
        mSceneEmpty.getSceneRoot().findViewById(R.id.btnRetry).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSplash();
            }
        });
    }

    @Override
    public void goToNextScreen() {
        finish();
    }
}
