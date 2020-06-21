package com.t3h.buoi10.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.t3h.buoi10.R;
import com.t3h.buoi10.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentHolder> {
    private LayoutInflater inflater;
    private List<Student> data;

    public StudentAdapter(LayoutInflater inflater) {
        this.inflater = inflater;
    }

    public void setData(List<Student> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StudentHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentHolder(
                inflater.inflate(R.layout.item_student, parent, false)
        );
    }

    @Override
    public void onBindViewHolder(@NonNull StudentHolder holder, int position) {
        holder.bindView(data.get(position));
    }

    @Override
    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public class StudentHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvAge;
        private TextView tvAddress;
        private TextView tvPhone;
        public StudentHolder(@NonNull View itemView) {
            super(itemView);
            tvAddress = itemView.findViewById(R.id.tv_address);
            tvAge = itemView.findViewById(R.id.tv_age);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            tvName = itemView.findViewById(R.id.tv_name);
        }

        public void bindView(Student student) {
            tvAge.setText(student.getAge() + "");
            tvPhone.setText(student.getPhone());
            tvName.setText(student.getName());
            tvAddress.setText(student.getAddress());
        }
    }
}
