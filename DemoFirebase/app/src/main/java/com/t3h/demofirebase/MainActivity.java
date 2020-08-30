package com.t3h.demofirebase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.t3h.demofirebase.adapter.ChatAdapter;
import com.t3h.demofirebase.databinding.ActivityMainBinding;
import com.t3h.demofirebase.models.Chat;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements MainLister, OnSuccessListener<Void>, OnFailureListener, ValueEventListener {
    private ActivityMainBinding binding;
    private ChatAdapter adapter;
    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference reference = database.getReference("chat");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        adapter = new ChatAdapter(getLayoutInflater());
        binding.setAdapter(adapter);
        binding.setListener(this);
        reference.addValueEventListener(this);
    }

    @Override
    public void send() {
        String message = binding.edtMessage.getText().toString();
        if (message.isEmpty()) {
            Toast.makeText(this, "Message must not empty", Toast.LENGTH_SHORT).show();
            return;
        }
        Chat chat = new Chat("BacNV", message);
        reference
                .child(chat.getTime() +"")
                .setValue(chat)
                .addOnSuccessListener(this)
                .addOnFailureListener(this);
    }

    @Override
    public void onSuccess(Void aVoid) {
        binding.edtMessage.setText("");
    }

    @Override
    public void onFailure(@NonNull Exception e) {
        Toast.makeText(this, e.getMessage()
                , Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDataChange(@NonNull DataSnapshot snapshot) {
        ArrayList<Chat> data = new ArrayList<>();
        for (DataSnapshot s : snapshot.getChildren()) {
            Chat chat = s.getValue(Chat.class);
            data.add(chat);
        }
        Collections.reverse(data);
        adapter.setData(data);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError error) {

    }

    @Override
    public boolean longSend() {
        Toast.makeText(this, "Long click", Toast.LENGTH_SHORT).show();
        return true;
    }
}