package com.project.bluebellsschool.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.project.bluebellsschool.R;
import com.project.bluebellsschool.data.DatabaseHelper;

public class ContactFragment extends Fragment {

    EditText editTextName, editTextMobile, editTextEmail, editTextMessage;
    Button buttonSubmit,buttonViewEntries;
    DatabaseHelper dbHelper ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contact, container, false);

        editTextName = view.findViewById(R.id.edit_text_name);
        editTextMobile = view.findViewById(R.id.edit_text_mobile);
        editTextEmail = view.findViewById(R.id.edit_text_email);
        editTextMessage = view.findViewById(R.id.edit_text_message);
        buttonSubmit = view.findViewById(R.id.button_submit);

        dbHelper = new DatabaseHelper(getContext());

        buttonSubmit.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String mobile = editTextMobile.getText().toString();
            String email = editTextEmail.getText().toString();
            String message = editTextMessage.getText().toString();

            if (name.isEmpty() || mobile.isEmpty() || email.isEmpty() || message.isEmpty()) {
                Toast.makeText(getContext(), "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            long newRowId = dbHelper.insertContact(name, mobile, email, message);
            if (newRowId != -1) {
                Toast.makeText(getContext(), "Contact added successfully", Toast.LENGTH_SHORT).show();
                clearFields();
            } else {
                Toast.makeText(getContext(), "Error adding contact", Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

    private void clearFields() {
        editTextName.setText("");
        editTextMobile.setText("");
        editTextEmail.setText("");
        editTextMessage.setText("");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dbHelper.close();
    }
}