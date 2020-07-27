package com.laduchuy.oderfood;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.laduchuy.oderfood.ui.BuyFragment;
import com.laduchuy.oderfood.ui.OrderFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    ImageView imgOrder;
    TextView tvSoluong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvSoluong = findViewById(R.id.tvsl);
        tvSoluong.setText(Integer.toString(OrderFragment.sl));
        imgOrder = findViewById(R.id.imgOrder);

        getFragment(OrderFragment.newInstance());

        imgOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragment(BuyFragment.newInstance());
            }
        });



    }


    public void getFragment(Fragment fragment) {
        try {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentlayout, fragment)
                    .commit();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "getFragment: " + e.getMessage());
        }
    }



}