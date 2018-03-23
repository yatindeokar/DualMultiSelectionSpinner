package com.example.dualmultiselectionspinner;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import java.util.ArrayList;

/**
 * Created by deokar on 25/2/18.
 */

public class MyDualMultiSelectionSpinner extends Dialog implements View.OnClickListener {


    ArrayList<CheckBox> CHECK_BOX_LIST_ONE = new ArrayList<>();
    ArrayList<CheckBox> CHECK_BOX_LIST_TWO = new ArrayList<>();

    ArrayList<Integer> LIST_ONE_SELECTED_INDEX = new ArrayList<>();
    ArrayList<Integer> LIST_TWO_SELECTED_INDEX = new ArrayList<>();

    ArrayList<String> selected_item_list = new ArrayList<>();

    ArrayList<String> listOne = new ArrayList<>();
    ArrayList<String> listTwo = new ArrayList<>();

    Button okButton, cancelButton;

    LinearLayout listOneLinearLayout, listTwoLinearLayout;


    public MyDualMultiSelectionSpinner(@NonNull Context context, ArrayList<String> listOne, ArrayList<String> listTwo) {
        super(context);
        this.listOne = listOne;
        this.listTwo = listTwo;
    }

    public MyDualMultiSelectionSpinner(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MyDualMultiSelectionSpinner(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_loding_button_layout);

        initView();


        addItemToLayoutOne();
        addItemToLayoutTwo();
    }

    private void initView() {

        listOneLinearLayout = findViewById(R.id.list_layout_one);
        listTwoLinearLayout = findViewById(R.id.list_layout_two);


        okButton = findViewById(R.id.ok_button);
        cancelButton = findViewById(R.id.cancel_button);


        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);

    }

    private void addItemToLayoutOne() {

        TableLayout tableLayout = new TableLayout(getContext());

        for (int i = 0; i < listOne.size(); i++) {


            TableRow tableRow = new TableRow(getContext());

            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(listOne.get(i));

//            tableLayout.addView(tableRow);

            tableRow.addView(checkBox);

            CHECK_BOX_LIST_ONE.add(checkBox);

            listOneLinearLayout.addView(tableRow);


        }


        CHECK_BOX_LIST_ONE.get(1).setChecked(true);

    }


    private void addItemToLayoutTwo() {

        TableLayout tableLayout = new TableLayout(getContext());

        for (int i = 0; i < listTwo.size(); i++) {

            TableRow tableRow = new TableRow(getContext());

            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(listTwo.get(i));

//            tableLayout.addView(tableRow);

            tableRow.addView(checkBox);

            CHECK_BOX_LIST_TWO.add(checkBox);

            listTwoLinearLayout.addView(tableRow);


        }

    }


    private ArrayList<String> getOne() {

        ArrayList<String> one = new ArrayList<>();

        for (int i = 0; i < CHECK_BOX_LIST_ONE.size(); i++) {

            if (CHECK_BOX_LIST_ONE.get(i).isChecked()) {


                one.add(String.valueOf(i));
                LIST_ONE_SELECTED_INDEX.add(i);
                selected_item_list.add(CHECK_BOX_LIST_ONE.get(i).getText().toString());

            }


        }


        return one;
    }


    private ArrayList<String> getTwo() {

        ArrayList<String> one = new ArrayList<>();

        for (int i = 0; i < CHECK_BOX_LIST_TWO.size(); i++) {

            if (CHECK_BOX_LIST_TWO.get(i).isChecked()) {

                one.add(String.valueOf(i));
                LIST_TWO_SELECTED_INDEX.add(i);
                selected_item_list.add(CHECK_BOX_LIST_TWO.get(i).getText().toString());
            }

        }


        return one;
    }


    public ArrayList<Integer> getListOneSelectedIndex(){

        return LIST_ONE_SELECTED_INDEX;


    }

    public ArrayList<Integer> getListTwoSelectedIndex(){

        return LIST_TWO_SELECTED_INDEX;

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.ok_button){

            selected_item_list.clear();
            Log.d("TAG", "onClick: ONE = " + getOne());
            Log.d("TAG", "onClick: TWO = " + getTwo());
            Log.d("TAG", "onClick: TWO = " + selected_item_list);

        }

        if (id == R.id.cancel_button){

            dismiss();

        }

    }
}
