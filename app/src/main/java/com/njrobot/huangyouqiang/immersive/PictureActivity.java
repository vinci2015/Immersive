package com.njrobot.huangyouqiang.immersive;

import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

public class PictureActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picture);
        setTranslucentBackground();
    }
    public void setTranslucentBackground(){
        this.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        // setup rootview
        ViewGroup rootview = (ViewGroup) ((ViewGroup) findViewById(android.R.id.content)).getChildAt(0);
        rootview.setFitsSystemWindows(true);
        rootview.setClipToPadding(true);
    }
}
