package com.example.sectionedrecylerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    List<Section> sectionList = new ArrayList<>();
    RecyclerView mainRecyclerView;
    String sectionOneName="Dummy";
   // List<String> sectionOneItems = new ArrayList<>();

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

       // String sectionOneName = "Section 1";
        List<String> sectionOneItems = new ArrayList<>();
        final String[] sectionOneName = {""};
        List<String> sectionNames = new ArrayList<>();
        List<String> sectionItems = new ArrayList<>();

        List<String> sectionOneItems1 = new ArrayList<>();
        List<Integer> sectionOneImage = new ArrayList<>();
        List<Integer> sectionOneImage1 = new ArrayList<>();

        sectionOneImage.add(R.drawable.jam_heart_chocolate_and_vanilla_3d);
      //  sectionOneItems.add("Item 1 data 1"+'\n'+"Item 1 data 2");
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


        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Products");

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

//                String nameofSection = dataSnapshot.child("1").child("name").getValue().toString();
//                sectionOneName =nameofSection;
                for(DataSnapshot SNAPSHOT : dataSnapshot.getChildren()){
                    sectionItems.add(SNAPSHOT.child("uid").getValue().toString());
                   Log.d("SECTION ITEMS' DATA MA ", sectionItems.toString());
                    sectionNames.add(SNAPSHOT.child("name").getValue().toString());
                  // Log.e("NAME NAME NAME NAME ", sectionNames.toString());

                }
                Log.e("INSIDE METHOD", ""+sectionNames);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
            }
        });

       // sectionList.add(new Section(sectionOneName[0], sectionOneItems, sectionOneItems1,sectionOneImage));
        Log.e("OUTSIDE METHOD", ""+sectionItems);

        sectionList.add(new Section(sectionNames, sectionTwoItems, sectionTwoItems,sectionOneImage));
        sectionList.add(new Section(sectionNames, sectionTwoItems, sectionOneItems1, sectionOneImage));
        sectionList.add(new Section(sectionNames, sectionThreeItems, sectionOneItems1, sectionOneImage));
        sectionList.add(new Section(sectionNames, sectionFourItems, sectionOneItems1, sectionOneImage));

      //  Log.d(TAG, "initData: " + sectionList);

    }
}