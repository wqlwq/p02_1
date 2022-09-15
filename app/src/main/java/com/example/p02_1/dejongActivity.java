package com.example.p02_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

public class dejongActivity extends AppCompatActivity {
    private Handler handler=new Handler();
    private Runnable runnableTOMainActivity =new Runnable() {
        @Override
        public void run() {
            toMainActivity();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dejong);
        handler.postDelayed(runnableTOMainActivity,3000);
    }

    private  void toMainActivity()
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        finish();
    }
    @Override
    protected  void onDestroy()
    {
        super.onDestroy();
        handler.removeCallbacks(runnableTOMainActivity);
    }
}