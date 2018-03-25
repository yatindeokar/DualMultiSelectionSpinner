package com.example.deokar.dualmultiselectionspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dualmultiselectionspinner.MyDualMultiSelectionSpinner;
import com.example.dualmultiselectionspinner.listenerInterface.DualSpinnerListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DualSpinnerListener{

    String TAG = MainActivity.class.getSimpleName();

    ArrayList<String> listOne = new ArrayList<>();
    ArrayList<String> listTwo = new ArrayList<>();

    ArrayList<Integer> listOneSelected = new ArrayList<>();
    ArrayList<Integer> listTwoSelected = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < 10; i++){

            listOne.add("new Added"+i);
            listTwo.add("Two new"+i);

        }

        listOneSelected.add(3);
        listOneSelected.add(5);
        listTwoSelected.add(1);

        mss();

    }

    private void mss(){

        MyDualMultiSelectionSpinner myDualMultiSelectionSpinner = new MyDualMultiSelectionSpinner(this, listOne, listTwo, listOneSelected, listTwoSelected);
        myDualMultiSelectionSpinner.setListener(this);
        myDualMultiSelectionSpinner.setLabels("List one", "List Two");
        myDualMultiSelectionSpinner.show();

    }

    @Override
    public void DualSpinnerPositiveListener(ArrayList<Integer> selectedListOne, ArrayList<Integer> selectedListTwo, ArrayList<String> oneSelectedText, ArrayList<String> twoSelectedText) {

        Toast.makeText(this, "cli", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "DualSpinnerPositiveListener:1 "+selectedListOne);
        Log.d(TAG, "DualSpinnerPositiveListener:2 "+selectedListTwo);
        Log.d(TAG, "DualSpinnerPositiveListener:1T "+oneSelectedText);
        Log.d(TAG, "DualSpinnerPositiveListener:2T "+twoSelectedText);

    }
}
