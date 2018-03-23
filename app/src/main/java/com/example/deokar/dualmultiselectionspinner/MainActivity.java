package com.example.deokar.dualmultiselectionspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dualmultiselectionspinner.MyDualMultiSelectionSpinner;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList<String> listOne = new ArrayList<>();
    ArrayList<String> listTwo = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 10; i++){

            listOne.add("new Added"+i);
            listTwo.add("Two new"+i);

        }

        mss();

    }

    private void mss(){

        MyDualMultiSelectionSpinner myDualMultiSelectionSpinner = new MyDualMultiSelectionSpinner(this, listOne, listTwo);
        myDualMultiSelectionSpinner.show();

    }

}
