// ViewEntriesFragment.java
package com.project.bluebellsschool.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.project.bluebellsschool.R;
import com.project.bluebellsschool.data.Contact;
import com.project.bluebellsschool.data.DatabaseHelper;

import java.util.List;

public class ViewEntriesFragment extends Fragment {

    DatabaseHelper dbHelper;
    TableLayout tableLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_entries, container, false);

        tableLayout = view.findViewById(R.id.table_layout_entries);
        dbHelper = new DatabaseHelper(getContext());


        List<Contact> contactList = dbHelper.getAllContacts();
        for (Contact contact : contactList) {
            TableRow tableRow = new TableRow(getContext());
            TableLayout.LayoutParams params = new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.WRAP_CONTENT
            );
            params.setMargins(8, 8, 8, 8); // Adds 8dp spacing around each row, 0, 0, 16); // Adds 16dp spacing between rows
            tableRow.setLayoutParams(params);

            TextView textViewId = new TextView(getContext());
            textViewId.setText(String.valueOf(contact.getId()));
            textViewId.setPadding(8, 8, 8, 8);
            textViewId.setTextColor(getResources().getColor(R.color.white));
            tableRow.addView(textViewId);

            TextView textViewName = new TextView(getContext());
            textViewName.setText(contact.getName());
            textViewName.setPadding(8, 8, 8, 8);
            textViewName.setTextColor(getResources().getColor(R.color.white));
            tableRow.addView(textViewName);

            TextView textViewMobile = new TextView(getContext());
            textViewMobile.setText(contact.getMobile());
            textViewMobile.setPadding(8, 8, 8, 8);
            textViewMobile.setTextColor(getResources().getColor(R.color.white));
            tableRow.addView(textViewMobile);

            TextView textViewEmail = new TextView(getContext());
            textViewEmail.setText(contact.getEmail());
            textViewEmail.setPadding(8, 8, 8, 8);
            textViewEmail.setTextColor(getResources().getColor(R.color.white));
            tableRow.addView(textViewEmail);

            TextView textViewMessage = new TextView(getContext());
            textViewMessage.setText(contact.getMessage());
            textViewMessage.setPadding(8, 8, 8, 8);
            textViewMessage.setTextColor(getResources().getColor(R.color.white));
            tableRow.addView(textViewMessage);

            tableLayout.addView(tableRow);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        dbHelper.close();
    }
}