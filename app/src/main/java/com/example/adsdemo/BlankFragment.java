package com.example.adsdemo;


import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.List;


public class BlankFragment extends Fragment {
    public static final String TAG = MainActivity.class.getSimpleName();
    private Context mContext;
    private List<MyListModel> mList;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    // TODO: 13/9/19 New Data


    //ANDROICFF
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_blank, container, false);


       /* MobileAds.initialize(MainActivity.this,"ca-app-pub-3940256099942544/3347511713");
        adView=findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);*/

        mRecyclerView = (RecyclerView)view.findViewById(R.id.recycler_view);
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
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        // specify an adapter (see also next example)
        mAdapter = new RecyclerViewAdopter(getContext(), mList);
        mRecyclerView.setAdapter(mAdapter);
        return view;
    }
}
