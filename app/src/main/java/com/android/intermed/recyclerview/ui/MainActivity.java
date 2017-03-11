package com.android.intermed.recyclerview.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.intermed.recyclerview.R;
import com.android.intermed.recyclerview.adapter.ClassAdapter;
import com.android.intermed.recyclerview.adapter.ListAdapter;
import com.android.intermed.recyclerview.model.ClassData;
import com.android.intermed.recyclerview.model.ListItem;

import java.util.ArrayList;

//gua off kan event onclick callback untuk sementara
//public class MainActivity extends AppCompatActivity implements ClassAdapter.ItemClickCallback

public class MainActivity extends AppCompatActivity{
//    private static final String bundle = "bundle";
//    private static final String bundle1 = "bundle1";


//    private ClassAdapter adapter1;

    private RecyclerView recyclerView;
    //object untuk layout manager dan adapter dari Recyclerview
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    //untuk set gambar
    private static final int[] icon = {R.drawable.user, R.drawable.si, R.drawable.comp, R.drawable.home, R.drawable.music};
    //batas set gambar

    //array list untuk class pojo list item
    ArrayList<ListItem> listItems = new ArrayList<>();
    //akhir array list

//    private ArrayList listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listData = (ArrayList) ClassData.getListData();
//        adapter1 = new ClassAdapter(ClassData.getListData(), this);
//        recyclerView.setAdapter(adapter1);
//        adapter1.setItemClickCallback(this);

        String[] title = getResources().getStringArray(R.array.title);

        for (int i=0; i<=title.length;i++ ){
            ListItem listItem = new ListItem(title[i],icon[i]);
            listItems.add(listItem);
        }

        recyclerView = (RecyclerView) findViewById(R.id.rv_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //kita mencoba membuat layout manager dalam recyclerview untuk membantu meanmpung tampilan
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        //akhir code dari bantuan layout manager

        adapter =new  ListAdapter(listItems, MainActivity.this);
        recyclerView.setAdapter(adapter);

    }

//    @Override
//    public void onItemClick(int p) {
//
//        ListItem item = (ListItem) listData.get(p);
//
//        Intent i = new Intent(this, DetailActivity.class);
//
//        Bundle extras = new Bundle();
//        extras.putString(bundle1, item.getTitle());
//        i.putExtra(bundle, extras);
//        startActivity(i);
//
//    }
//
//
//    @Override
//    public void onSecondaryIconClick(int p) {
//        ListItem item = (ListItem) listData.get(p);
//
//
//        if (item.isFavourite()) {
//            item.setFavourite(false);
//        } else {
//            item.setFavourite(true);
//        }
//
//        adapter1.setListItemData(listData);
//        adapter1.notifyDataSetChanged();
//    }

}