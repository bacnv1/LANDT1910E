package com.t3h.covidtour.utils;

import android.widget.EditText;

public class Validator {
    public static boolean isEmpty(EditText... editTexts) {
        boolean isEmpty = false;
        for (EditText edt: editTexts) {
            if (edt.getText().toString().isEmpty()) {
                isEmpty = true;
                edt.setError("Empty");
            }
        }
        return isEmpty;
    }
}
