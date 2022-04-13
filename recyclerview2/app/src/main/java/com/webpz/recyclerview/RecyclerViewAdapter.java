package com.webpz.recyclerview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<customLinear> customlinears = new ArrayList<>();
    private Context context;
    private int[] DrawableResource =
            {R.drawable.item_background, R.drawable.item_background, R.drawable.item_background};
    private String[] textResource =
            {"김트럭 Iphone", "헤일리 USB", "이트럭 USB"};


    RecyclerViewAdapter(Context context) {
        this.context = context;

    }

    public void setGraphViews(int num) {
        this.customlinears.clear();
        for (int i = 0; i < num; i++) {
            customLinear graphView = new customLinear(context);
            graphView.initView(textResource[i], DrawableResource[i]);
            this.customlinears.add(graphView);
        }
        notifyDataSetChanged();
    }

    public void setHide() {
        customlinears.get(1).setVisibility(View.INVISIBLE);
        customlinears.get(2).setVisibility(View.INVISIBLE);
    }

    public void setShow() {
        customlinears.get(1).setVisibility(View.VISIBLE);
        customlinears.get(2).setVisibility(View.VISIBLE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgView_item;
        TextView txt_main;
        LinearLayout row;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            row = itemView.findViewById(R.id.ltem_layout);
            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    Log.d("anna##", "position" + pos);
                    customLinear customTemp = customlinears.get(pos);
                    customlinears.add(0, customTemp);
                    customlinears.remove(pos + 1);
                    customlinears.get(0).setSelected(true);
                    customlinears.get(1).setSelected(false);
                    customlinears.get(2).setSelected(false);
                    setHide();
                    notifyDataSetChanged();
                }
            });
        }
    }

    private ArrayList<RecyclerViewItem> mList = null;

    public RecyclerViewAdapter(ArrayList<RecyclerViewItem> mList) {
        this.mList = mList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item, parent, false);
        return new ViewHolder(view);
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (customlinears.get(position).getParent() != null) {
            ((ViewGroup) customlinears.get(position).getParent()).removeView(customlinears.get(position));
        }
        holder.row.addView(customlinears.get(position));
    }

    @Override
    public int getItemCount() {
        return customlinears.size();
    }
}
