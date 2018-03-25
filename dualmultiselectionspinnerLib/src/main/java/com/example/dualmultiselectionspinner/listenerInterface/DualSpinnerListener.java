package com.example.dualmultiselectionspinner.listenerInterface;

import java.util.ArrayList;

/**
 * Created by tantragyan-18 on 3/3/18.
 */

public interface DualSpinnerListener {

    void DualSpinnerPositiveListener(ArrayList<Integer> selectedListOne,
                                     ArrayList<Integer> selectedListTwo,
                                     ArrayList<String> oneSelectedText,
                                     ArrayList<String> twoSelectedText
    );

    void DualSpinnerCancelListener();

}
