package com.example.adsdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;


public class MainActivity extends AppCompatActivity {
   // AdView adView;
    public static final String TAG = MainActivity.class.getSimpleName();
    private Context mContext;
    private List<MyListModel> mList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    Button bt;
    Button firstFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();
       /* MobileAds.initialize(MainActivity.this,"ca-app-pub-3940256099942544/3347511713");
        adView=findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);*/

        mRecyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        bt = (Button) findViewById(R.id.bt);


        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFragment(new BlankFragment(),false,"one");
                mRecyclerView.setVisibility(View.GONE);
            }
        });

        mList = new ArrayList<MyListModel>();

        for(int i=0;i<30;i++){
            MyListModel myString = new MyListModel();
            myString.setName(i+" - Ads Demo ");
            myString.setViewType(1);
            mList.add(myString);
        }

        //Place two Admob Ads at position index 1 and 5 in recyclerview
        MyListModel myString1 = new MyListModel();
        myString1.setViewType(2);
        mList.add(3,myString1);

        MyListModel myString2 = new MyListModel();
        myString2.setViewType(2);
        mList.add(6,myString2);





        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerViewAdopter(this, mList);
        mRecyclerView.setAdapter(mAdapter);



    }

    public void addFragment(Fragment fragment, boolean addToBackStack, String tag) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction ft = manager.beginTransaction();

        if (addToBackStack) {
            ft.addToBackStack(tag);
        }
        ft.replace(R.id.frameLayout, fragment, tag);
        ft.commitAllowingStateLoss();
    }
}
