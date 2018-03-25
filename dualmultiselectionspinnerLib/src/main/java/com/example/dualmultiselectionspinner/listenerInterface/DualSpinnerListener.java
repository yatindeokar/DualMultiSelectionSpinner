package com.example.dualmultiselectionspinner.listenerInterface;

import java.util.ArrayList;

/**
 * Created by tantragyan-18 on 3/3/18.
 */

public interface DualSpinnerListener {

    void DualSpinnerPositiveListener(ArrayList<Integer> selectedPositionOne,
                                     ArrayList<Integer> selectedPositionTwo,
                                     ArrayList<String> selectedItemsOne,
                                     ArrayList<String> selectedItemsTwo
    );

    void DualSpinnerCancelListener();

}
