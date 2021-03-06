package com.t3h.buoi5;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int REQUEST_IMAGE = 1;
    private EditText edtValue;
    private Button btnCall;
    private Button btnBrowser;
    private Button btnGallery;
    private ImageView imGallery;
    private TextView tvInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        Intent intent = getIntent();
        String userName = intent.getStringExtra(RegisterActivity.EXTRA_USER_NAME);
        String password = intent.getStringExtra(RegisterActivity.EXTRA_PASSWORD);
        tvInfo.setText(userName + ":" + password);
    }

    private void initViews() {
        imGallery = findViewById(R.id.im_gallery);
        tvInfo = findViewById(R.id.tv_info);
        edtValue = findViewById(R.id.edt_value);
        btnCall = findViewById(R.id.btn_call);
        btnBrowser = findViewById(R.id.btn_browser);
        btnGallery = findViewById(R.id.btn_gallery);
        btnCall.setOnClickListener(this);
        btnGallery.setOnClickListener(this);
        btnBrowser.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String value = edtValue.getText().toString();
        switch (v.getId()) {
            case R.id.btn_browser:
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                browserIntent.setData(Uri.parse(value));
                startActivity(browserIntent);
                break;
            case R.id.btn_call:
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + value));
                startActivity(callIntent);
                break;
            case R.id.btn_gallery:
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(
                        Intent.createChooser(galleryIntent, "Pick image"),
                        REQUEST_IMAGE
                );
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE) {
            if (resultCode == RESULT_OK) {
                try {
                    Bitmap b = MediaStore.Images.Media.getBitmap(
                            getContentResolver(),
                            data.getData()
                    );
                    imGallery.setImageBitmap(b);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
