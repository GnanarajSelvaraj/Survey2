package org.mahiti.recycler_frag;


import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerView_fragment extends Fragment {

    DatabaseHelper mDatabaseHelper;
    private RecyclerView mListView;
    List<UserClass> list = new ArrayList<>();
    //DatabaseHelper helper;
    User_Adapter adapter;
    String username,phone_number,gender,hobbies,dob,address;
    TextView txt_name,txt_phone,txt_gender,txt_hobby,txt_dob,txt_address;
    Cursor incomedata;


    //public Button button;
    public FloatingActionButton fab;
    RecyclerView recyclerView;


    public RecyclerView_fragment() {

        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_no_record_fragment, container, false);

        fab = view.findViewById(R.id.fab);
        mDatabaseHelper = new DatabaseHelper(getActivity());
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.fragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, new Fragment1(), null)
                        .addToBackStack(null)
                        .commit();

                //                Intent i = new Intent(getActivity(), ImageSliderActivity.class);
//                i.putExtra("Name",txt_name.getText().toString());
//                i.putExtra("PhoneNumber",txt_phone.getText().toString());
//                i.putExtra("Gender",txt_gender.getText().toString());
//                i.putExtra("Hobbies",txt_hobby.getText().toString());
//                i.putExtra("DOB",txt_dob.getText().toString());
//                i.putExtra("Address",txt_address.getText().toString());
//                getActivity().startActivity(i);
            }
        });





        list = mDatabaseHelper.getAllData();
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        adapter = new User_Adapter(list, getContext());
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
//        recyclerView.notifyAll();
//        getActivity().notify();
    return view;
    }



}
