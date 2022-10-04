package com.example.roomdatabase_recyclerview;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class FragmentTwo extends Fragment {
    RecyclerView recyclerView;
    UserListAdapter userListAdapter;

    public FragmentTwo() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_two, container, false);

        recyclerView =v.findViewById(R.id.recyclerid);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(), DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        userListAdapter = new UserListAdapter(getContext());
        recyclerView.setAdapter(userListAdapter);

        loadUserList();

        return v;
    }

    private void loadUserList() {
        AppDatabase db = AppDatabase.getDbInstance(this.getContext());
        List<User> userList =db.userDao().getAllUsers();
        userListAdapter.setUserList(userList);
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100) {
            loadUserList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}