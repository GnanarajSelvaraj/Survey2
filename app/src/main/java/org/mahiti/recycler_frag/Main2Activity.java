package org.mahiti.recycler_frag;

import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
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

public class Main2Activity extends AppCompatActivity {
    private static FragmentManager fragmentManager;
    EditText et_id,et_name, et_phone, et_dob, et_address;
    CheckBox cb_cricket, cb_football, cb_photography;
    //CheckBox hbcricket,hbfootball,hbphotography;
    CheckBox ch_hobbies;
    DatabaseHelper msql;
    RadioButton rd_male, rd_female;
    RecyclerView recyclerView;


    RadioGroup rg_gender;
    // RadioButton rd_gender;
    TextView txt_gender_item;
    RadioButton rbmale, rbfemale;


    TextView txt_address;


    Button btn_Submit;
    String id;
    String username;
    String phone_number;
    String gender;
    String hobbies;
    String dob;
    String address;
    Button btn;


    TextView txt_hobbies_item;


    LinearLayout llXml;


    public Button button;






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.updatevalues);
       // View view = inflater.inflate(R.layout.fragment_fragment1,  container, false);
        msql = new DatabaseHelper(Main2Activity.this);
        et_id = (EditText) findViewById(R.id.et_id);
        et_name = (EditText) findViewById(R.id.et_name);
        et_phone = (EditText) findViewById(R.id.et_phone);
        rg_gender = findViewById(R.id.rg_gender);
        rd_male = (RadioButton) findViewById(R.id.rd_male);
        rd_female = (RadioButton) findViewById(R.id.rd_female);
        rbmale = findViewById(R.id.rd_male);
        rbfemale = findViewById(R.id.rd_female);
       // rbfemale.setEnabled(true);
        cb_cricket = (CheckBox) findViewById(R.id.cb_cricket);
        cb_football = (CheckBox) findViewById(R.id.cb_football);
        cb_photography = (CheckBox) findViewById(R.id.cb_photgraphy);
        txt_hobbies_item = (TextView) findViewById(R.id.txt_hobbies_item);
        et_dob = (EditText) findViewById(R.id.et_dob);
        et_address = (EditText) findViewById(R.id.et_address);
        btn_Submit = (Button) findViewById(R.id.btn_Submit);
        txt_gender_item = (TextView) findViewById(R.id.txt_gender_item);

        UpdateData();

        if (getIntent()!=null) {
            id=getIntent().getStringExtra("Id");
            username = getIntent().getStringExtra("Name");
            phone_number = getIntent().getStringExtra("PhoneNumber");
            gender = getIntent().getStringExtra("Gender");
            hobbies = getIntent().getStringExtra("Hobbies");
            dob = getIntent().getStringExtra("DOB");
            address = getIntent().getStringExtra("Address");
        }
        et_id.setText(id);
         et_name.setText(username);
                    et_phone.setText(phone_number);
                    txt_gender_item.setText(gender);
                    txt_hobbies_item.setText(hobbies);
                    et_dob.setText(dob);
                    et_address.setText(address);

//btn_Submit.setOnClickListener(new View.OnClickListener() {
//    @Override
//    public void onClick(View v) {
//        boolean isUpdate = (boolean) msql.updateData(et_name.getText().toString(),
//                et_phone.getText().toString(),txt_gender_item.getText().toString(),
//                txt_hobbies_item.getText().toString(),
//                et_dob.getText().toString(),et_address.getText().toString());
//        if(isUpdate == true)
//            Toast.makeText(Main2Activity.this,"Data Update",Toast.LENGTH_LONG).show();
//        else
//            Toast.makeText(Main2Activity.this,"Data not Updated",Toast.LENGTH_LONG).show();
//    }
//});
//        btn_Submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String username = et_name.getText().toString();
//                String phone_number = et_phone.getText().toString();
//                String gender = txt_gender_item.getText().toString();
//                String hobbies = txt_hobbies_item.getText().toString();
//                String dob = et_dob.getText().toString();
//                String address = et_address.getText().toString();
//
//                if (username.length() != 0 && phone_number.length() != 0 && gender.length() != 0 && hobbies.length() != 0 && dob.length() != 0 && address.length()!=0) {
//                    AddData(username, phone_number, gender, hobbies, dob,address);
//                    et_name.setText("");
//                    et_phone.setText("");
//                    txt_gender_item.setText("");
//                    txt_hobbies_item.setText("");
//                    et_dob.setText("");
//                    et_address.setText("");
//                    Toast.makeText(Main2Activity.this, "data is edited", Toast.LENGTH_LONG).show();
//                    //Main2Activity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new RecyclerView_fragment(), null).commit();
//                } else {
//                    Toast.makeText(Main2Activity.this, "you must fill the details field", Toast.LENGTH_LONG).show();
//                }
//            }
//
//
//        });


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


    }



//    public void AddData(String username, String phone_number, String gender, String hobbies, String date, String address) {
//        boolean insertData = (boolean) msql.addData(username, phone_number, gender, hobbies, date, address);
//        if (insertData == true) {
//            Toast.makeText(Main2Activity.this, "Data Succesfull", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(Main2Activity.this, "Data not Succesfull", Toast.LENGTH_SHORT).show();
//
//        }
//
//    }





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
    public void UpdateData() {
        btn_Submit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        boolean isUpdate =msql.updateData(et_id.getText().toString(),et_name.getText().toString(),
                                et_phone.getText().toString(),
                                txt_gender_item.getText().toString(),
                                txt_hobbies_item.getText().toString(),
                                et_dob.getText().toString(),et_address.getText().toString());
                        if(isUpdate) {
                            Toast.makeText(Main2Activity.this, "Data Update", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent();
                            intent.setClass(Main2Activity.this, MainActivity.class);
                            Main2Activity.this.startActivity(intent);
                        }
                        else {
                            Toast.makeText(Main2Activity.this, "Data not Updated", Toast.LENGTH_LONG).show();
                        }
                    }
                }
        );
    }
}
