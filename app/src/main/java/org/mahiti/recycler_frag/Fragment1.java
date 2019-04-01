package org.mahiti.recycler_frag;


import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.View.GONE;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment {

    EditText et_name, et_phone, et_dob, et_address;
    CheckBox cb_cricket, cb_football, cb_photography;
    //CheckBox hbcricket,hbfootball,hbphotography;
    CheckBox ch_hobbies;
    DatabaseHelper msql;
    RadioButton rd_male, rd_female;


    RadioGroup rg_gender;
    // RadioButton rd_gender;
    TextView txt_gender_item;
    RadioButton rbmale, rbfemale;


    TextView txt_address;


    Button btn_Submit;
    String username;
    String phone_number;
    String gender;
    String hobbies = ",";
    String dob;
    Button btn;


    TextView txt_hobbies_item;


    LinearLayout llXml;


    public Button button;

    public Fragment1() {
        // Required empty public constructor
    }


    @SuppressLint("ResourceAsColor")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fragment1,  container, false);
        msql = new DatabaseHelper(getActivity());
        et_name = (EditText) view.findViewById(R.id.et_name);
        et_phone = (EditText) view.findViewById(R.id.et_phone);
        rg_gender = view.findViewById(R.id.rg_gender);
        rd_male = (RadioButton) view.findViewById(R.id.rd_male);
        rd_female = (RadioButton) view.findViewById(R.id.rd_female);
        rbmale = view.findViewById(R.id.rd_male);
        rbfemale = view.findViewById(R.id.rd_female);
        rbfemale.setEnabled(true);
        cb_cricket = (CheckBox) view.findViewById(R.id.cb_cricket);
        cb_football = (CheckBox) view.findViewById(R.id.cb_football);
        cb_photography = (CheckBox) view.findViewById(R.id.cb_photgraphy);
        txt_hobbies_item = (TextView) view.findViewById(R.id.txt_hobbies_item);
        et_dob = (EditText) view.findViewById(R.id.et_dob);
        et_address = (EditText) view.findViewById(R.id.et_address);
        btn_Submit = (Button) view.findViewById(R.id.btn_Submit);
        txt_gender_item = (TextView) view.findViewById(R.id.txt_gender_item);


        //BUndle
        Bundle bundle1=new Bundle();
        String username= (String) bundle1.get("Name");
        String phone= (String) bundle1.get("PhoneNumber");
        String gender= (String) bundle1.get("Gender");
        String hobby= (String) bundle1.get("Hobbies");
        String dob= (String) bundle1.get("DOB");
        String address= (String) bundle1.get("Address");

        et_name.setText(username);
        et_phone.setText(phone);
        txt_gender_item.setText(gender);
        txt_hobbies_item.setText(hobby);
        et_dob.setText(dob);
        et_address.setText(address);

        btn_Submit.setBackgroundColor(R.color.colorAccent);
        btn_Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = et_name.getText().toString();
                String phone_number = et_phone.getText().toString();
                String gender = txt_gender_item.getText().toString();
                String hobbies = txt_hobbies_item.getText().toString();
                String dob = et_dob.getText().toString();
                String address = et_address.getText().toString();

                if (username.length() != 0 && phone_number.length() != 0 && gender.length() != 0 && hobbies.length() != 0 && dob.length() != 0 && address.length()!=0) {
                    AddData(username, phone_number, gender, hobbies, dob,address);
                    et_name.setText("");
                    et_phone.setText("");
                    txt_gender_item.setText("");
                    txt_hobbies_item.setText("");
                    et_dob.setText("");
                    et_address.setText("");
                    MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new RecyclerView_fragment(), null).commit();
                } else {
                    Toast.makeText(getActivity(), "you must fill the details field", Toast.LENGTH_LONG).show();
                }
            }


        });


        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int id = rg_gender.getCheckedRadioButtonId();
                View radioButton = rg_gender.findViewById(id);
                if (checkedId == R.id.rd_male) {

                    rbmale.setEnabled(true);
                    txt_gender_item.setText("" + rd_male.getText());
                    txt_gender_item.setVisibility(GONE);

                } else {

                    rbfemale.setEnabled(true);
                    txt_gender_item.setText("" + rd_female.getText());
                    txt_gender_item.setVisibility(GONE);
//                    textView.setEnabled(true);
                }
            }
        });
//        button = view.findViewById(R.id.btn_Submit);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });
        cb_cricket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkone(v);
            }

        });
        cb_football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkone(v);
            }
        });
        cb_photography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkone(v);
            }
        });
        return view;

    }



    public void AddData(String username, String phone_number, String gender, String hobbies, String date, String address) {
        boolean insertData = (boolean) msql.addData(username, phone_number, gender, hobbies, date, address);
        if (insertData == true) {
            Toast.makeText(getActivity(), "Data Succesfull", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getActivity(), "Data not Succesfull", Toast.LENGTH_SHORT).show();

        }
        
    }


    public void checkone(View v) {
        if (cb_cricket.isChecked() && cb_football.isChecked() && cb_photography.isChecked()) {
            txt_hobbies_item.setText("Cricket,Football,Photo");
        } else if (cb_cricket.isChecked() && cb_photography.isChecked()) {
            txt_hobbies_item.setText("Cricket,Photographhy");
        } else if (cb_cricket.isChecked() && cb_football.isChecked()) {
            txt_hobbies_item.setText("Cricket,Football");
        } else if (cb_cricket.isChecked()) {
            txt_hobbies_item.setText("Cricket");
        } else if (cb_football.isChecked() && cb_photography.isChecked()) {
            txt_hobbies_item.setText("Football,Photography");
        } else if (cb_football.isChecked()) {
            txt_hobbies_item.setText("Football");
        } else if (cb_photography.isChecked()) {
            txt_hobbies_item.setText("Photography");
        } else {
            txt_hobbies_item.setText("None");
        }
//    }
    }


}
