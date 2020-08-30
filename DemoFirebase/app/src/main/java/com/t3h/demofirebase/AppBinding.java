package com.t3h.demofirebase;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import java.text.SimpleDateFormat;

public class AppBinding {
    private static final SimpleDateFormat dateFormat
            = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    @BindingAdapter("duration")
    public static void duration(TextView tv, long time) {
        tv.setText(dateFormat.format(time));
    }
}
