package com.lifeng.beam;

import android.content.Context;

import com.lifeng.beam.bijection.ActivityLifeCycleDelegate;
import com.lifeng.beam.bijection.ActivityLifeCycleDelegateProvider;
import com.lifeng.beam.bijection.BeamAppCompatActivity;
import com.lifeng.beam.expansion.BeamBaseActivity;
import com.lifeng.beam.expansion.overlay.ViewExpansionDelegate;
import com.lifeng.beam.expansion.overlay.ViewExpansionDelegateProvider;
import com.lifeng.beam.model.ModelManager;

/**
 * Created by Mr.Jude on 2015/7/26.
 */
public final class Beam {
    private static ActivityLifeCycleDelegateProvider mActivityLIfeCycleDelegateProvider;

    private static ViewExpansionDelegateProvider mViewExpansionDelegateProvider;


    public static ActivityLifeCycleDelegate createActivityLifeCycleDelegate(BeamAppCompatActivity activity) {
        if (mActivityLIfeCycleDelegateProvider!=null)
            return mActivityLIfeCycleDelegateProvider.createActivityLifeCycleDelegate(activity);
        else return null;
    }

    public static ViewExpansionDelegate createViewExpansionDelegate(BeamBaseActivity activity){
        if (mViewExpansionDelegateProvider==null)
            return ViewExpansionDelegateProvider.DEFAULT.createViewExpansionDelegate(activity);
        else return mViewExpansionDelegateProvider.createViewExpansionDelegate(activity);
    }

    public static void setActivityLifeCycleDelegateProvider(ActivityLifeCycleDelegateProvider activityLifeCycleDelegateClass){
        mActivityLIfeCycleDelegateProvider = activityLifeCycleDelegateClass;
    }

    public static void setViewExpansionDelegateProvider(ViewExpansionDelegateProvider viewExpansionDelegateProvider) {
        mViewExpansionDelegateProvider = viewExpansionDelegateProvider;
    }
    public static void init(Context ctx){
        ModelManager.init(ctx);
    }

}
