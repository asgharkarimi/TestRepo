package com.example.testapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ContactsHolder> {
    private ArrayList<String> contacts = new ArrayList<>();

    public ContactsAdapter() {
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
        contacts.add("Asghar Karimi");
    }

    public void addContact(String contactName) {
        contacts.add(0, contactName);
        notifyItemInserted(0);
    }

    @NonNull
    @Override
    public ContactsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        return new ContactsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactsHolder holder, int position) {
        holder.bindContact(contacts.get(position));
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public class ContactsHolder extends RecyclerView.ViewHolder {
        private TextView tv_firstChar;
        private TextView tv_fullName;

        public ContactsHolder(@NonNull View itemView) {
            super(itemView);
            tv_firstChar = itemView.findViewById(R.id.textViewfirstChar);
            tv_fullName = itemView.findViewById(R.id.textViewFullname);
        }

        public void bindContact(String contactName) {
            tv_firstChar.setText(contactName.substring(0, 1).toUpperCase());
            tv_fullName.setText(contactName);
        }
    }

    public interface ItemEventListener {
        void Onclick(int position, String contactName);
    }
}
