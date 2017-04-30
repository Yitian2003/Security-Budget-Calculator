package com.witlife.budgetcaculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    TextView tvCCTV;
    TextView tvAlarm;
    LinearLayout layoutCCTV;
    LinearLayout layoutAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initLinstener();
    }

    private void initView(){
        tvCCTV = (TextView)findViewById(R.id.tvCCTV);
        tvAlarm = (TextView)findViewById(R.id.tvAlarm);
        layoutCCTV = (LinearLayout)findViewById(R.id.layoutCCTV);

        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/lobster_regular.ttf");

        tvCCTV.setTypeface(custom_font);
        tvAlarm.setTypeface(custom_font);
    }

    private void initLinstener(){
        layoutCCTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CaculateActivity.class);
                startActivity(intent);
            }
        });
    }
}
