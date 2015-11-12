package com.pop.tf_min;

import android.app.Application;
import android.content.Context;
import android.support.annotation.UiThread;
import android.util.DisplayMetrics;
import android.widget.Toast;

import org.androidannotations.annotations.EApplication;

/**
 * Created by pengfu on 15/11/12.
 */
@EApplication
public class App extends Application {


    /**
     * width of screen in pixels
     */
    public static int SCREEN_WIDTH = 0;
    /**
     * height of screen in pixels
     */
    public static int SCREEN_HEIGHT = 0;
    /**
     * this value used to transform pix to dip unit, pix = dp * SCREEN_DENSITY
     * screen density if screen size is 320*480 in pixels than SCREEN_DENSITY is 1.0f,
     * wile if screen size is 480*800 than SCREEN_DENSITY is 1.5f
     */
    public static float SCREEN_DENSITY = 0F;
    private static App instance ;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this ;
        DisplayMetrics dm = getResources().getDisplayMetrics();
        SCREEN_WIDTH = dm.widthPixels;
        SCREEN_HEIGHT = dm.heightPixels;
        SCREEN_DENSITY = dm.density;
    }

    public static App getInstance(){
        return instance ;
    }
    @UiThread
    public void showToast(String msg){
        Toast.makeText(this ,msg ,Toast.LENGTH_SHORT).show();
    }
}
