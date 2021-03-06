package com.lifeng.szx;

import android.app.Activity;
import android.os.Bundle;

import com.jude.utils.JActivityManager;
import com.lifeng.beam.bijection.ActivityLifeCycleDelegate;
//import com.umeng.analytics.MobclickAgent;


/**
 * Created by Mr.Jude on 2015/9/9.
 */
public class ActivityDelegate extends ActivityLifeCycleDelegate {

    public ActivityDelegate(Activity act) {
        super(act);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //APP.getInstance().RefWatcher.watch(getActivity());
        //SwipeBackHelper.onCreate(getActivity());
        JActivityManager.getInstance().pushActivity(getActivity());
        //PushAgent.getInstance(getActivity()).onAppStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //MobclickAgent.onResume(getActivity());

    }

    @Override
    protected void onPause() {
        super.onPause();
        //MobclickAgent.onPause(getActivity());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //SwipeBackHelper.onDestroy(getActivity());
        JActivityManager.getInstance().popActivity(getActivity());
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        //SwipeBackHelper.onPostCreate(getActivity());
    }
}
