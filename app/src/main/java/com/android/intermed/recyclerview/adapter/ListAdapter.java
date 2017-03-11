package com.android.intermed.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.intermed.recyclerview.R;
import com.android.intermed.recyclerview.model.ListItem;
import com.android.intermed.recyclerview.ui.MainActivity;

import java.util.ArrayList;

/**
 * Created by DIM on 11/03/2017.
 */

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListViewHolder> {
    //membuat array list buat handle object di list item
    ArrayList<ListItem> arrayList= new ArrayList<>();

    Context ctx;
    MainActivity mainActivity;

    public ListAdapter(ArrayList<ListItem> arrayList, Context ctx) {
        this.arrayList = arrayList;
        this.ctx = ctx;
        mainActivity = (MainActivity) ctx;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
        ListViewHolder listViewHolder = new ListViewHolder(view,mainActivity);

        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        ListItem item = arrayList.get(position);
        holder.img.setImageResource(item.getImage());
        holder.title.setText(item.getTitle());
        if (item.isFavourite()){
            holder.starImg.setImageResource(R.drawable.staron);
        } else {
            holder.starImg.setImageResource(R.drawable.staroff);
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ListViewHolder extends RecyclerView.ViewHolder{

        ImageView img, starImg;
        TextView title;

        public ListViewHolder(View itemView, MainActivity mainActivity) {
            super(itemView);

            img =(ImageView)itemView.findViewById(R.id.iv1);
            starImg = (ImageView)itemView.findViewById(R.id.star);
            title =(TextView)itemView.findViewById(R.id.tv1);

        }
    }
}
