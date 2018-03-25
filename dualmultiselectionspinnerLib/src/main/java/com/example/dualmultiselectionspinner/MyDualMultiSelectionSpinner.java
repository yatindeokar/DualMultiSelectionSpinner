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
import android.widget.TextView;

import com.example.dualmultiselectionspinner.listenerInterface.DualSpinnerListener;

import java.util.ArrayList;

/**
 * Created by deokar on 25/2/18.
 */

public class MyDualMultiSelectionSpinner extends Dialog implements View.OnClickListener {


    static String labelOne, labelTwo;

    ArrayList<CheckBox> CHECK_BOX_LIST_ONE = new ArrayList<>();
    ArrayList<CheckBox> CHECK_BOX_LIST_TWO = new ArrayList<>();
    ArrayList<Integer> LIST_ONE_SELECTED_INDEX = new ArrayList<>();
    ArrayList<Integer> LIST_TWO_SELECTED_INDEX = new ArrayList<>();
    ArrayList<String> selected_item_list_one = new ArrayList<>();
    ArrayList<String> selected_item_list_two = new ArrayList<>();
    ArrayList<Integer> list_one_checked_item_position = new ArrayList<>();
    ArrayList<Integer> list_two_checked_item_position = new ArrayList<>();
    ArrayList<String> listOne = new ArrayList<>();
    ArrayList<String> listTwo = new ArrayList<>();
    Button okButton, cancelButton;
    LinearLayout listOneLinearLayout, listTwoLinearLayout;

    TextView listOneLabelTv, listTwoLabelTv;

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


    public void setListener(DualSpinnerListener dualSpinnerListener) {

        this.dualSpinnerListener = dualSpinnerListener;

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.my_dual_spinner_dialog_layout);

        initView();


        addItemToLayoutOne();
        addItemToLayoutTwo();
    }

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

    }

    private void addItemToLayoutOne() {

        TableLayout tableLayout = new TableLayout(getContext());

        Log.d("TAG", "addItemToLayoutOne: " + listOne);

        for (int i = 0; i < listOne.size(); i++) {


            TableRow tableRow = new TableRow(getContext());

            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(listOne.get(i));

//            tableLayout.addView(tableRow);

            Log.d("TAG", "addItemToLayoutOne: " + i);

            tableRow.addView(checkBox);

            CHECK_BOX_LIST_ONE.add(checkBox);

            listOneLinearLayout.addView(tableRow);

            //Set height of view


        }


        checkedListOneItems();

    }

    private void checkedListOneItems() {

        for (int i = 0; i < list_one_checked_item_position.size(); i++) {

            CHECK_BOX_LIST_ONE.get(list_one_checked_item_position.get(i)).setChecked(true);

        }

    }

    private void checkedListTwoItems() {

        for (int i = 0; i < list_two_checked_item_position.size(); i++) {

            CHECK_BOX_LIST_TWO.get(list_two_checked_item_position.get(i)).setChecked(true);

        }

    }

    private void addItemToLayoutTwo() {

        TableLayout tableLayout = new TableLayout(getContext());

        Log.d("TAG", "addItemToLayoutTwo: " + listTwo);


        for (int i = 0; i < listTwo.size(); i++) {

            TableRow tableRow = new TableRow(getContext());

            CheckBox checkBox = new CheckBox(getContext());
            checkBox.setText(listTwo.get(i));

//            tableLayout.addView(tableRow);

            tableRow.addView(checkBox);

            CHECK_BOX_LIST_TWO.add(checkBox);

            listTwoLinearLayout.addView(tableRow);


        }

        checkedListTwoItems();

    }


    private ArrayList<Integer> getOne() {

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


    private ArrayList<Integer> getTwo() {

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

    public void setLabels(String labelOne, String labelTwo) {

        this.labelOne = labelOne;
        this.labelTwo = labelTwo;

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

            selected_item_list_one.clear();
            selected_item_list_two.clear();

            dualSpinnerListener.DualSpinnerPositiveListener(getOne(),
                    getTwo(),
                    selected_item_list_one,
                    selected_item_list_two

            );

            dismiss();

        }

        if (id == R.id.cancel_button) {

            dismiss();

        }


    }
}
