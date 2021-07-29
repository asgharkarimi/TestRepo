package com.example.testapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements ContactsAdapter.ItemEventListener {
    private static final String TAG = "MainActivity";
    private RecyclerView recyclerViewContacts;
    private ContactsAdapter contactsAdapter;
    private EditText editTextContactname;
    private ImageView imageViewAddcontact;
    private int editingItemPosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerViewContacts = findViewById(R.id.tv_contacts);
        contactsAdapter = new ContactsAdapter(this);
        editTextContactname = findViewById(R.id.editTextContactname);
        imageViewAddcontact = findViewById(R.id.imageViewAddcontact);


        recyclerViewContacts.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerViewContacts.setAdapter(contactsAdapter);

        imageViewAddcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editingItemPosition == -1) {
                    contactsAdapter.addContact(editTextContactname.getText().toString());
                    recyclerViewContacts.smoothScrollToPosition(0);
                } else {
                    contactsAdapter.updateContact(editTextContactname.getText().toString(), editingItemPosition);
                    imageViewAddcontact.setImageResource(R.drawable.ic_add_white_24dp);
                }

                editTextContactname.setText("");

            }
        });
    }

    @Override
    public void Onclick(int position, String contactName) {
        editingItemPosition = position;
        editTextContactname.setText(contactName);
        imageViewAddcontact.setImageResource(R.drawable.ic_check_white_24dp);
    }
}
