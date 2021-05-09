package com.alexandersolovyov.myfirstapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mButton1;
    private Button mButton2;
    private Button mButton3;

    private void switchFragment(String name, int color) {
        Fragment fragment;
        fragment = getSupportFragmentManager().findFragmentByTag(name);
        if(fragment == null) {
            fragment = DemoFragment.newInstance(name, ContextCompat.getColor(this, color));
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container_colortext, fragment, name)
                    .commit();
        }else {
            Toast.makeText(this, "Fragment not created", Toast.LENGTH_SHORT).show();
        }
    }

    private void toggleFragment(int container_id, String name) {
        Fragment fragment;
        FragmentManager fragment_manager = getSupportFragmentManager();
        fragment = fragment_manager.findFragmentByTag(name);
        if(fragment == null) {
            fragment = DemoFragment.newInstance(name, ContextCompat.getColor(this, R.color.design_default_color_background));
            fragment_manager.beginTransaction()
                    .add(container_id, fragment, name)
                    .commit();
        }else {
            // hide/show fragment
            if(fragment.isVisible()) {
                //show
                fragment_manager.beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .hide(fragment)
                        .commit();
            }else {
                //hide
                fragment_manager.beginTransaction()
                        .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                        .show(fragment)
                        .commit();
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        mButton1 = findViewById(R.id.fa_btn_1);
        mButton2 = findViewById(R.id.fa_btn_2);
        mButton3 = findViewById(R.id.fa_btn_3);

        mButton1.setText(getString(R.string.buttonx, 1));
        mButton2.setText(getString(R.string.buttonx, 2));
        mButton3.setText(getString(R.string.buttonx, 3));

        mButton1.setOnClickListener(this);
        mButton2.setOnClickListener(this);
        mButton3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.fa_btn_1:
                switchFragment("one", R.color.red);
                toggleFragment(R.id.fragment_1, "Buton-1_fragment");
                break;
            case R.id.fa_btn_2:
                switchFragment("two", R.color.green);
                toggleFragment(R.id.fragment_2, "Buton-2_fragment");
                break;
            case R.id.fa_btn_3:
                switchFragment("three", R.color.blue);
                toggleFragment(R.id.fragment_3, "Buton-3_fragment");
                break;
        }
    }
}