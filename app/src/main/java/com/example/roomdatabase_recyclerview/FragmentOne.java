package com.example.roomdatabase_recyclerview;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentOne extends Fragment {
    private UserListAdapter userListAdapter;

    public FragmentOne() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_one, container, false);

        final EditText firstNameInput = v.findViewById(R.id.firstNameInput);
        final EditText lastNameInput =v.findViewById(R.id.lastNameInput);
        Button saveButton =v.findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveNewUser(firstNameInput.getText().toString(), lastNameInput.getText().toString());

            }
        });
        return v;
    }

    private void saveNewUser(String firstName, String lastName) {
        AppDatabase db  = AppDatabase.getDbInstance(this.getContext());

        User user = new User();
        user.firstName =firstName;
        user.lastName =lastName;
        db.userDao().insertUser(user);

        


    }
}