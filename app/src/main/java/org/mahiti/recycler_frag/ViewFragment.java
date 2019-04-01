package org.mahiti.recycler_frag;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ViewFragment extends Fragment {
    // Store instance variables

    static  String id;
    static String username;
    static String phone_number;
    static String gender;
    static  String hobbies;
    static String dob ;
    static   String address;
   // Button btn_edit;



    // newInstance constructor for creating fragment with arguments
    public static ViewFragment newInstance(int id, String username, String phone_number, String gender, String hobbies, String dob, String address) {
        ViewFragment viewFragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putString("Id", String.valueOf(id));
        args.putString("Name",username);
        args.putString("PhoneNumber", phone_number);
        args.putString("Gender",gender);
        args.putString("Hobbies", hobbies);
        args.putString("DOB",dob  );
        args.putString("Address", address);
        viewFragment.setArguments(args);
        return viewFragment;
    }


    // Store instance variables based on arguments passed
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id=getArguments().getString("Id");
        username = getArguments().getString("Name");
        phone_number = getArguments().getString("PhoneNumber");
        gender = getArguments().getString("Gender");
        hobbies = getArguments().getString("Hobbies");
        dob = getArguments().getString("DOB");
        address = getArguments().getString("Address");
    }

    // Inflate the view for the fragment based on layout XML
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpage, container, false);


        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

              //  Log.v("ImageSliderActivity", "Deleting at pos - " +list);
               // MainActivity activity = (MainActivity) getActivity();
              //  activity.delete(pos);
            }
        });

        TextView txt_id = (TextView) view.findViewById(R.id.txt_id);
        txt_id.setText("  " + id);
        TextView txt_name = (TextView) view.findViewById(R.id.txt_name);
        txt_name.setText("  " + username);
        TextView txt_phone = (TextView) view.findViewById(R.id.txt_phone);
        txt_phone.setText("  " + phone_number);
        TextView txt_gender = (TextView) view.findViewById(R.id.txt_gender);
        txt_gender.setText("  " + gender);
        TextView txt_hobby = (TextView) view.findViewById(R.id.txt_hobby);
        txt_hobby.setText(" " + hobbies);
        TextView txt_dob = (TextView) view.findViewById(R.id.txt_dob);
        txt_dob.setText("  " + dob);
        TextView txt_address = (TextView) view.findViewById(R.id.txt_address);
        txt_address.setText("  " + address);

        //btn_edit=(Button) view.findViewById(R.id.btn_edit);



//        btn_edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle=new Bundle();
//
//                bundle.putString("Name",username);
//                bundle.putString("PhoneNumber", phone_number);
//                bundle.putString("Gender",gender);
//                bundle.putString("Hobbies", hobbies);
//                bundle.putString("DOB",dob  );
//                bundle.putString("Address", address);
//
//                    FragmentManager fragmentManager=getActivity().getSupportFragmentManager();
//
//                    FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//
//                    Fragement_edit fragement_edit=new Fragement_edit();
//
//                fragement_edit.setArguments(bundle);
//
//                fragmentTransaction.addToBackStack(null);
//
//                fragmentTransaction.replace(R.id.fragment_container,fragement_edit);
//
//                fragmentTransaction.commit();
//
//            }
//});
                return view;
    }

    public static List<String> getUser() {
        List<String> getUser=new ArrayList<>();
        getUser.add(id);
        getUser.add(username);
        getUser.add(phone_number);
        getUser.add(gender);
        getUser.add(hobbies);
        getUser.add(dob);
        getUser.add(address);

        // return getUser;
        return getUser;
    }


}
