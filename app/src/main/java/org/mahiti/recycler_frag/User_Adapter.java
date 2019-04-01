package org.mahiti.recycler_frag;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class User_Adapter extends RecyclerView.Adapter<User_Adapter.MyViewHolder> {

    //String txt_Id;
    TextView txt_id,txt_name,txt_phone,txt_gender,txt_hobby,txt_dob,txt_address;
    String username,phone_number,gender,hobbies,dob,address;


        Context activity;
    List<UserClass> list = new ArrayList<>();
    LayoutInflater inflater;

    public User_Adapter(List<UserClass> list, Context activity) {


        this.list = list;
        this.activity=activity;
        //inflater = (LayoutInflater) list.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        txt_id = (TextView) itemView.findViewById(R.id.txt_id);
        txt_name = (TextView) itemView.findViewById(R.id.txt_name);
        txt_phone = (TextView) itemView.findViewById(R.id.txt_phone);
        txt_gender = (TextView) itemView.findViewById(R.id.txt_gender);
        txt_hobby = (TextView) itemView.findViewById(R.id.txt_hobby);
        txt_dob = (TextView) itemView.findViewById(R.id.txt_dob);
        txt_address = (TextView) itemView.findViewById(R.id.txt_address);
        return new MyViewHolder(itemView);



    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        UserClass lists = list.get(position);
        //Pass the values of feeds object to Views
        final String id= String.valueOf(lists.getId());
        final String username = lists.getUsername();
        final String phone_number = lists.getPhone_number();
        final String gender = lists.getGender();
        final String hobbies = lists.getHobbies();
        final String dob    = lists.getDob();
        final String address = lists.getAddress();

    holder.txt_id.setText(id);
        holder.txt_name.setText(username);
        holder.txt_phone.setText(phone_number);
        holder.txt_gender.setText(gender);
        holder.txt_hobbies.setText(hobbies);
        holder.txt_dob.setText(dob);
        holder.txt_address.setText(address);

        holder.List1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(activity, ImageSliderActivity.class);
                i.putExtra("Id",id);
                i.putExtra("Name",username);
                i.putExtra("PhoneNumber",phone_number);
                i.putExtra("Gender",gender);
                i.putExtra("Hobbies",hobbies);
                i.putExtra("DOB",dob);
                i.putExtra("Address",address);
                i.putExtra("position",position);


                activity.startActivity(i);

                txt_name.getText();
                 txt_phone.getText();
                 txt_gender.getText();
                 txt_hobby.getText();
                 txt_dob.getText();
                 txt_address.getText();


            }
        });
        //txt_Id = lists.getId();


//      //  Log.d("LOGTAG", "id : " + txt_Id);
//        Log.d("LOGTAG", "lists.getUsername():" + lists.getUsername());
//        Log.d("LOGTAG", "lists.getPhone_number():" + lists.getPhone_number());
//        Log.d("LOGTAG", "lists.getGender():" + lists.getGender());
//        Log.d("LOGTAG", "lists.getHobbies():" + lists.getHobbies());
//        Log.d("LOGTAG", "lists.getDob():" + lists.getDob());
//        Log.d("LOGTAG", "lists.getAddress():" + lists.getAddress());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

//    public List<UserClass> getAllData() {
//        return allData;
//    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txt_id;
        public TextView txt_name;
        public TextView txt_phone;
        public TextView txt_gender;
        public TextView txt_hobbies;
        public TextView txt_dob;
        public TextView txt_address;
        public LinearLayout List1;

        public MyViewHolder(View itemView) {
            super(itemView);
            txt_id=itemView.findViewById(R.id.txt_id);
            txt_name = itemView.findViewById(R.id.txt_name);
            txt_phone = itemView.findViewById(R.id.txt_phone);
            txt_gender = itemView.findViewById(R.id.txt_gender);
            txt_hobbies = itemView.findViewById(R.id.txt_hobby);
            txt_dob = itemView.findViewById(R.id.txt_dob);
            txt_address = itemView.findViewById(R.id.txt_address);
            List1 = itemView.findViewById(R.id.List1);

        }
    }
}

