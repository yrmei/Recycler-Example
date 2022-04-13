package com.webpz.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.ToggleButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ArrayList<customLinear> mList;
    private RecyclerViewAdapter mRecyclerViewAdapter;
    private ToggleButton mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mList = new ArrayList<>();
        mRecyclerView = findViewById(R.id.recyclerView);
        mToggle = findViewById(R.id.change_mode);

        mRecyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext());
        mRecyclerViewAdapter.setGraphViews(3);
        mRecyclerView.setAdapter(mRecyclerViewAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mToggle.isChecked()) {
                    mRecyclerViewAdapter.setHide();
                } else {
                    mRecyclerViewAdapter.setShow();
                }
            }
        });
    }
}