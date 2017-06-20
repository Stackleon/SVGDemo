package com.example.user.testdemoproj;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.patac.hmi.wiget.CurvePickerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    Handler mhandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            int width = msg.what;

            Log.i("shiwan","handler:"+width);

            RelativeLayout.LayoutParams realtiveParams = (RelativeLayout.LayoutParams) loadingImg.getLayoutParams();
            realtiveParams.width = width;
            loadingImg.setLayoutParams(realtiveParams);


        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initView();

        //initData();

       // initViews();

        initAnimate();
    }

    private void initAnimate() {

        ImageView androidImageView = (ImageView) findViewById(R.id.romain);
        Drawable drawable = androidImageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    /**

    private void initViews() {
        final ArrayList<String> dataList = new ArrayList<>();
        for (int i = 0; i < 100; i++)
            dataList.add("" + i);

        CurvePickerView epv = (CurvePickerView) findViewById(R.id.epv);
        epv.setDataList(dataList);

        epv.setOnScrollChangedListener(new CurvePickerView.OnScrollChangedListener() {
            @Override
            public void onScrollChanged(int curIndex) {

            }

            @Override
            public void onScrollFinished(int curIndex) {
                Log.i("shiwan",dataList.get(curIndex));
            }
        });
    }

 */
    private ImageView loadingImg;
    private ImageView line;
    private AnimationDrawable loadingAnimation;

    private void initView() {
        //loadingImg = (ImageView) findViewById(R.id.can_translate);
        //line = (ImageView) findViewById(R.id.line);


        loadingImg.setBackgroundResource(R.drawable.loading);
        loadingAnimation = (AnimationDrawable) loadingImg.getBackground();
    }






    int sumWidth;
    int sumTime = 60;
    int marginTop = 65;
    int unit;
//    @Override
//    public void onWindowFocusChanged(boolean hasFocus) {
//        super.onWindowFocusChanged(hasFocus);
//
//        sumWidth = line.getMeasuredWidth();
//
//        unit = sumWidth/sumTime;
//        if(hasFocus){
//            loadingAnimation.start();
//        }
//
//        new Thread(){
//            @Override
//            public void run() {
//                int time = 0;
//                int width = 0;
//                while (time < sumTime) {
//                    width = time*unit;
//
//                    Log.i("shiwan",""+width);
//                    mhandler.sendEmptyMessage(width);
//                    try {
//                        sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//
//                    time++;
//                }
//            }
//        }.start();
//
//
//    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        loadingAnimation.stop();
    }
}
