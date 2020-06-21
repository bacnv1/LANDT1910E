package com.t3h.buoi10;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.t3h.buoi10.dao.AppDatabase;
import com.t3h.buoi10.model.Student;
import com.t3h.buoi10.utils.Validator;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText edtName;
    private EditText edtAge;
    private EditText edtAddress;
    private EditText edtPhone;
    private Button btnOk;
    private Student student = new Student();

    public static Intent getInstance(Context context, Student student) {
        Intent intent = new Intent(context, StudentActivity.class);
        if (student != null) {
            intent.putExtra(Student.class.getName(), student);
        }
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        Intent intent = getIntent();
        if (intent.hasExtra(Student.class.getName())) {
            student = (Student) intent
                    .getSerializableExtra(Student.class.getName());
        }
        initViews();
    }

    private void initViews() {
        edtAddress = findViewById(R.id.edt_address);
        edtAge = findViewById(R.id.edt_age);
        edtName = findViewById(R.id.edt_name);
        edtPhone = findViewById(R.id.edt_phone);
        edtPhone.setText(student.getPhone());
        edtName.setText(student.getName());
        edtAddress.setText(student.getAddress());
        edtAge.setText(student.getAge() + "");
        btnOk = findViewById(R.id.btn_ok);
        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (Validator.isEmpty(edtAddress, edtAge, edtName, edtPhone)) {
            return;
        }
        student.setAddress(edtAddress.getText().toString());
        student.setAge(Integer.parseInt(edtAge.getText().toString()));
        student.setName(edtName.getText().toString());
        student.setPhone(edtPhone.getText().toString());
        if (student.getId() > 0) {
            AppDatabase.getInstance(this).getStudentDao().update(student);
        } else {
            AppDatabase.getInstance(this).getStudentDao().insert(student);
        }
        setResult(RESULT_OK);
        finish();
    }
}
