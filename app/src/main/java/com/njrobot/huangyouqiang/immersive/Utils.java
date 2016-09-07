package com.njrobot.huangyouqiang.immersive;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;

/**
 * Created by huangyouqiang on 2016/9/6.
 */
public class Utils {
    public static View createStatuView(Activity activity,int color){
        //获取状态栏高度
        int statusBarHeight = getStatusBarHeight(activity);

        View statusView = new View(activity);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,statusBarHeight);
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);
        return statusView;
    }
    public static void setStatusColor(Activity activity,int color){
        if(Build.VERSION.SDK_INT<Build.VERSION_CODES.LOLLIPOP){
            //小于5.0
            //设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View statusView = createStatuView(activity,color);

            //添加statusview到布局中
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView();
            decorView.addView(statusView);

            //设置根布局
            ViewGroup rootView = (ViewGroup)((ViewGroup) activity.findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }
    public static int getStatusBarHeight(Activity activity){
        int resourceId = activity.getResources().getIdentifier("status_bar_height","dimen","android");
        int height =  activity.getResources().getDimensionPixelOffset(resourceId);
        Log.i("status bar ","height :"+height);
        return height;
    }

}
