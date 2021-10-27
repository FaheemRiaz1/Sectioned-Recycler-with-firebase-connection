package com.example.sectionedrecylerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    List<Section> sectionList = new ArrayList<>();
    RecyclerView mainRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mainRecyclerView = findViewById(R.id.mainRecyclerView);
        MainRecyclerAdapter mainRecyclerAdapter = new MainRecyclerAdapter(sectionList);
        mainRecyclerView.setAdapter(mainRecyclerAdapter);
        mainRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    private void initData() {

        String sectionOneName = "Section 1";
        List<String> sectionOneItems = new ArrayList<>();
        List<String> sectionOneItems1 = new ArrayList<>();
        List<Integer> sectionOneImage = new ArrayList<>();
        List<Integer> sectionOneImage1 = new ArrayList<>();

        sectionOneImage.add(R.drawable.jam_heart_chocolate_and_vanilla_3d);
        sectionOneItems.add("Item 1 data 1"+'\n'+"Item 1 data 2");
        sectionOneImage1.add(R.drawable.jam_heart_chocolate_3d);
        sectionOneItems1.add("Item 1 data 3"+'\n'+"Item 1 data 4");

        String sectionTwoName = "Section 2";
        String sectionThreeName = "Section 3";
        String sectionFourName = "Section 4";

        List<String> sectionTwoItems = new ArrayList<>();

        sectionTwoItems.add("Item 2 data 1"+'\n'+"Item 2 data 2");

        List<String> sectionThreeItems = new ArrayList<>();
        sectionThreeItems.add("Item 3 data 1"+'\n'+"Item 4 data 2");

        List<String> sectionFourItems = new ArrayList<>();
        sectionFourItems.add("Item 4 data 1"+'\n'+"Item 4 data 2");

        sectionList.add(new Section(sectionOneName, sectionOneItems, sectionOneItems1,sectionOneImage));
        sectionList.add(new Section(sectionTwoName, sectionTwoItems, sectionOneItems1, sectionOneImage));
        sectionList.add(new Section(sectionThreeName, sectionThreeItems, sectionOneItems1, sectionOneImage));
        sectionList.add(new Section(sectionFourName, sectionFourItems, sectionOneItems1, sectionOneImage));

        Log.d(TAG, "initData: " + sectionList);
    }
}