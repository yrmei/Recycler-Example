package com.webpz.recyclerview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;


public class customLinear extends LinearLayout {
    Context mContext;
    TextView text;
    ImageView imageView;
    public interface InfoClickListener{
        void onClick(View v);
    }

    public customLinear(Context context) {
        super(context);
        mContext = context;
    }

    public customLinear(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs, 0);
        mContext = context;
    }

    public void initView(String texts, int Drawable) {
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.recycler_items, this, false);
        addView(view);
        imageView = findViewById(R.id.list_icon);
        imageView.setImageResource(Drawable);
        text = findViewById(R.id.list_text);
        text.setText(texts);
    }
}

