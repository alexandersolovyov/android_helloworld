package com.alexandersolovyov.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LaunchActivity extends AppCompatActivity {

    private TextView mText;
    private Button mBtnClick;
    private Button mBtnFragment;
    private Button mBtnDialog;

    private Bundle bundle;

    private int clicked;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch);

        this.clicked = 0;

        int colorRed = 0;
        /*
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            colorRed = getColor(R.color.red);
        }
         */
        colorRed = ContextCompat.getColor(this, R.color.red);

        //final String newText = getString(R.string.buttton_clicked);

        bundle = new Bundle();
        bundle.putString("btnStatus", "off");

        mText = findViewById(R.id.tv_text);
        mBtnClick = findViewById(R.id.btn_click);
        mBtnFragment = findViewById(R.id.btn_fragment);
        mBtnDialog = findViewById(R.id.btn_dialog);

        mText.setTextColor(colorRed);

        mBtnClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clicked++;
                if(clicked > 0) {
                    mText.setText(getString(R.string.button_clicks, clicked));
                }
            }
            //if(bundle.)
        });

        mBtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LaunchActivity.this, FragmentActivity.class);
                startActivity(intent);
            }
        });

        mBtnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyPopupDialog.show(getSupportFragmentManager());
            }
        });
    }

}