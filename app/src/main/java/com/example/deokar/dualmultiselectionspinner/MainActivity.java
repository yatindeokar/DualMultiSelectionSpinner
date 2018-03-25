package com.example.deokar.dualmultiselectionspinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dualmultiselectionspinner.MyDualMultiSelectionSpinner;
import com.example.dualmultiselectionspinner.listenerInterface.DualSpinnerListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements DualSpinnerListener, View.OnClickListener{

    String TAG = MainActivity.class.getSimpleName();

    // Items of list one and list two
    ArrayList<String> listOne = new ArrayList<>();
    ArrayList<String> listTwo = new ArrayList<>();

    // List of selected item position
    ArrayList<Integer> listOneSelectedPosition = new ArrayList<>();
    ArrayList<Integer> listTwoSelectedPosition = new ArrayList<>();

    Button openSpinnerBtn;
    TextView resultTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        for (int i = 0; i < 10; i++){

            listOne.add("Item One_"+i);
            listTwo.add("Item Two_"+i);

        }

        listOneSelectedPosition.add(3);
        listOneSelectedPosition.add(5);
        listTwoSelectedPosition.add(1);



    }

    private void initView() {

        openSpinnerBtn = findViewById(R.id.open_spinner_btn);

        resultTv = findViewById(R.id.result_text_view);

        openSpinnerBtn.setOnClickListener(this);


    }


    private void openDualSpinner(){

        MyDualMultiSelectionSpinner myDualMultiSelectionSpinner = new MyDualMultiSelectionSpinner(this,
                listOne,
                listTwo,
                listOneSelectedPosition,
                listTwoSelectedPosition);

        myDualMultiSelectionSpinner.setListener(this);
        myDualMultiSelectionSpinner.setLabels("LIST ONE LABEL", "LIST TWO LABEL");
        myDualMultiSelectionSpinner.setLabelOneStyle(30, R.color.colorAccent);
        myDualMultiSelectionSpinner.setLabelTwoStyle(30, R.color.colorPrimaryDark);
        myDualMultiSelectionSpinner.show();

    }

    @Override
    public void DualSpinnerPositiveListener(ArrayList<Integer> selectedPositionOne,
                                            ArrayList<Integer> selectedPositionTwo,
                                            ArrayList<String> selectedItemsOne,
                                            ArrayList<String> selectedItemsTwo) {

        Toast.makeText(this, "cli", Toast.LENGTH_SHORT).show();

        Log.d(TAG, "DualSpinnerPositiveListener:1 "+selectedPositionOne);
        Log.d(TAG, "DualSpinnerPositiveListener:2 "+selectedPositionTwo);
        Log.d(TAG, "DualSpinnerPositiveListener:1T "+selectedItemsOne);
        Log.d(TAG, "DualSpinnerPositiveListener:2T "+selectedItemsTwo);

        resultTv.setText(selectedItemsOne.toString() + selectedItemsTwo.toString());

    }

    @Override
    public void DualSpinnerCancelListener() {

        Toast.makeText(this, "Cancel Click", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (id){

            case R.id.open_spinner_btn:

                openDualSpinner();

                break;

        }

    }
}
