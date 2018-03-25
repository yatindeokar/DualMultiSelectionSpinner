package com.example.dualmultiselectionspinner;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.example.dualmultiselectionspinner.listenerInterface.DualSpinnerListener;

import java.util.ArrayList;

/**
 * Created by deokar on 25/2/18.
 */

public class MyDualMultiSelectionSpinner extends Dialog implements View.OnClickListener {


    // List one label and list two label string
    String labelOne = "Label One", labelTwo = "Label Two";

    // List label text size by default it is 10
    float labelOneTextSize = 20, labelTwoTextSize = 20;

    // List label text color by default it is 0, #nothing
    int labelOneTextColor = 0, labelTwoTextColor = 0;

    // CheckBox list of list one an list two
    ArrayList<CheckBox> CHECK_BOX_LIST_ONE = new ArrayList<>();
    ArrayList<CheckBox> CHECK_BOX_LIST_TWO = new ArrayList<>();

    // List of selected index of list one and list two
    ArrayList<Integer> LIST_ONE_SELECTED_INDEX = new ArrayList<>();
    ArrayList<Integer> LIST_TWO_SELECTED_INDEX = new ArrayList<>();

    ArrayList<String> selected_item_list_one = new ArrayList<>();
    ArrayList<String> selected_item_list_two = new ArrayList<>();

    ArrayList<Integer> list_one_checked_item_position = new ArrayList<>();
    ArrayList<Integer> list_two_checked_item_position = new ArrayList<>();

    // List of items of list one and list two
    ArrayList<String> listOne = new ArrayList<>();
    ArrayList<String> listTwo = new ArrayList<>();

    // Ok an cancel button
    Button okButton, cancelButton;

    LinearLayout listOneLinearLayout, listTwoLinearLayout;

    // List one and list two label text view
    TextView listOneLabelTv, listTwoLabelTv;

    // This is interface of ok an cancel button listener
    DualSpinnerListener dualSpinnerListener;

    public MyDualMultiSelectionSpinner(@NonNull Context context,
                                       ArrayList<String> listOne,
                                       ArrayList<String> listTwo,
                                       ArrayList<Integer> list_one_checked_item_position,
                                       ArrayList<Integer> list_two_checked_item_position

    ) {
        super(context);
        this.listOne = listOne;
        this.listTwo = listTwo;

        this.list_one_checked_item_position = list_one_checked_item_position;
        this.list_two_checked_item_position = list_two_checked_item_position;
    }

    public MyDualMultiSelectionSpinner(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    protected MyDualMultiSelectionSpinner(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    /**
     * Set ok and cancel button listener
     * @param dualSpinnerListener
     */
    public void setListener(DualSpinnerListener dualSpinnerListener) {

        this.dualSpinnerListener = dualSpinnerListener;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_dual_spinner_dialog_layout);

        initView();


        addItemToListOne();
        addItemToListTwo();
    }

    /**
     * Initialise views and set listeners
     */
    private void initView() {

        listOneLinearLayout = findViewById(R.id.list_layout_one);
        listTwoLinearLayout = findViewById(R.id.list_layout_two);


        okButton = findViewById(R.id.ok_button);
        cancelButton = findViewById(R.id.cancel_button);

        listOneLabelTv = findViewById(R.id.list_one_label);
        listTwoLabelTv = findViewById(R.id.list_two_label);

        listOneLabelTv.setText(labelOne);
        listTwoLabelTv.setText(labelTwo);

        okButton.setOnClickListener(this);
        cancelButton.setOnClickListener(this);


        setStyle();
    }

    /**
     * Set style to views
     */
    private void setStyle() {

        listOneLabelTv.setTextSize(labelOneTextSize);
        listTwoLabelTv.setTextSize(labelTwoTextSize);


        if (labelOneTextColor != 0)
            listOneLabelTv.setTextColor(ContextCompat.getColor(getContext(), labelOneTextColor));

        if (labelTwoTextColor != 0)
            listTwoLabelTv.setTextColor(ContextCompat.getColor(getContext(), labelTwoTextColor));

    }

    /**
     * Add items to section one list
     */
    private void addItemToListOne() {

        Log.d("TAG", "addItemToListOne: " + listOne);

        for (int i = 0; i < listOne.size(); i++) {


            TableRow tableRow = new TableRow(getContext());

            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(listOne.get(i));

            Log.d("TAG", "addItemToListOne: " + i);

            tableRow.addView(checkBox);

            CHECK_BOX_LIST_ONE.add(checkBox);

            listOneLinearLayout.addView(tableRow);

            //Set height of view


        }


        checkedListOneItems();

    }

    /**
     * Set items checked in list one
     */
    private void checkedListOneItems() {

        for (int i = 0; i < list_one_checked_item_position.size(); i++) {

            CHECK_BOX_LIST_ONE.get(list_one_checked_item_position.get(i)).setChecked(true);

        }

    }

    /**
     * Add items to section two list
     */
    private void checkedListTwoItems() {

        for (int i = 0; i < list_two_checked_item_position.size(); i++) {

            CHECK_BOX_LIST_TWO.get(list_two_checked_item_position.get(i)).setChecked(true);

        }

    }

    /**
     * Set items checked in list two
     */
    private void addItemToListTwo() {

        Log.d("TAG", "addItemToListTwo: " + listTwo);


        for (int i = 0; i < listTwo.size(); i++) {

            TableRow tableRow = new TableRow(getContext());

            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(listTwo.get(i));

            tableRow.addView(checkBox);

            CHECK_BOX_LIST_TWO.add(checkBox);

            listTwoLinearLayout.addView(tableRow);


        }

        checkedListTwoItems();

    }

    /**
     * Get list one selected item position
     * @return
     */
    private ArrayList<Integer> getListOneSelectedPosition() {

        ArrayList<Integer> one = new ArrayList<>();

        for (int i = 0; i < CHECK_BOX_LIST_ONE.size(); i++) {

            if (CHECK_BOX_LIST_ONE.get(i).isChecked()) {


                one.add(i);
                LIST_ONE_SELECTED_INDEX.add(i);
                selected_item_list_one.add(CHECK_BOX_LIST_ONE.get(i).getText().toString());

            }


        }


        return one;
    }

    /**
     * Get list two selected item position
     * @return
     */
    private ArrayList<Integer> getListTwoSelectedPosition() {

        ArrayList<Integer> one = new ArrayList<>();

        for (int i = 0; i < CHECK_BOX_LIST_TWO.size(); i++) {

            if (CHECK_BOX_LIST_TWO.get(i).isChecked()) {

                one.add(i);
                LIST_TWO_SELECTED_INDEX.add(i);
                selected_item_list_two.add(CHECK_BOX_LIST_TWO.get(i).getText().toString());
            }

        }


        return one;
    }

    /**
     * Set list one and list two label
     * @param labelOne
     * @param labelTwo
     */
    public void setLabels(String labelOne, String labelTwo) {

        this.labelOne = labelOne;
        this.labelTwo = labelTwo;

    }

    /**
     * Set label one text style, text size and text color
     * @param labelTextSize
     * @param labelTextColor
     */
    public void setLabelOneStyle(float labelTextSize, int labelTextColor) {

        this.labelOneTextSize = labelTextSize;
        this.labelOneTextColor = labelTextColor;

    }

    /**
     * Set label two text style, text size and text color
     * @param labelTextSize
     * @param labelTextColor
     */
    public void setLabelTwoStyle(float labelTextSize, int labelTextColor) {

        this.labelTwoTextSize = labelTextSize;
        this.labelTwoTextColor = labelTextColor;
    }

    public ArrayList<Integer> getListOneSelectedIndex() {

        return LIST_ONE_SELECTED_INDEX;


    }

    public ArrayList<Integer> getListTwoSelectedIndex() {

        return LIST_TWO_SELECTED_INDEX;

    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R.id.ok_button) {

            //Clear list to avoid duplication
            selected_item_list_one.clear();
            selected_item_list_two.clear();

            // Set ok button click listener
            dualSpinnerListener.DualSpinnerPositiveListener(getListOneSelectedPosition(),
                    getListTwoSelectedPosition(),
                    selected_item_list_one,
                    selected_item_list_two

            );

            dismiss();

        }

        if (id == R.id.cancel_button) {

            // Set cancel button click listener
            dualSpinnerListener.DualSpinnerCancelListener();

            dismiss();

        }


    }
}
