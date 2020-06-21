package com.t3h.buoi10.utils;

import android.widget.EditText;

public class Validator {
    public static boolean isEmpty(EditText ... edts) {
        boolean isEmpty = false;
        for (EditText edt: edts) {
            if (edt.getText().toString().isEmpty()) {
                isEmpty = true;
                edt.setError("Input empty");
            }
        }
        return isEmpty;
    }
}
