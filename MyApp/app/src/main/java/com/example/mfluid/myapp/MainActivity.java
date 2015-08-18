package com.example.mfluid.myapp;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends Activity {

    Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Test();
        mContext=this;

        FrameLayout frameLayout= (FrameLayout) findViewById(R.id.frameLayout);



        SemiCircleProgressBarView semiCircleProgressBarView = new SemiCircleProgressBarView(mContext,R.drawable.white, 164, 164);
        semiCircleProgressBarView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        semiCircleProgressBarView.setClipping(100);

        SemiCircleProgressBarView semiCircleProgressBarView2 = new SemiCircleProgressBarView(mContext,R.drawable.yellow, 164, 164);
        semiCircleProgressBarView2.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        semiCircleProgressBarView2.setClipping(80);

        frameLayout.addView(semiCircleProgressBarView);
        frameLayout.addView(semiCircleProgressBarView2);



    }



    private void Test() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
