package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerViewContacts;
    private ContactsAdapter contactsAdapter;
    private EditText editTextContactname;
    private ImageView imageViewAddcontact;
    private int editingItemPosition=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewContacts = findViewById(R.id.tv_contacts);
        contactsAdapter = new ContactsAdapter();
        editTextContactname=findViewById(R.id.editTextContactname);
        imageViewAddcontact=findViewById(R.id.imageViewAddcontact);


        recyclerViewContacts.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerViewContacts.setAdapter(contactsAdapter);

        imageViewAddcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contactsAdapter.addContact(editTextContactname.getText().toString());
                recyclerViewContacts.smoothScrollToPosition(0);
            }
        });
    }
}
