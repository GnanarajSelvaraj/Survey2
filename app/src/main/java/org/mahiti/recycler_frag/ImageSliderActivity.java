package org.mahiti.recycler_frag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;


public class ImageSliderActivity extends AppCompatActivity {

    List<UserClass> list =new ArrayList<>();

   // FragmentActivity activity=new FragmentActivity();

    List<String> getUser=new ArrayList<>();
    List<ViewFragment> fragmentList = new ArrayList<>();
    MyPagerAdapter adapterViewPager;
    String id, username,phone_number,gender,hobbies,dob,address;
 //intent textbox
    TextView txt_id,txt_name,txt_phone,txt_gender,txt_hobby,txt_dob,txt_address;
    int position1;
    Button btnEdit;
    SharedPreferences sharedPreferences;



    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SharedPreferences prefs = getSharedPreferences("pref", MODE_PRIVATE);
        int restoredText = prefs.getInt("theme",0);

        setTheme(restoredText);

        setContentView(R.layout.activity_main1);
//        FragmentManager fragmentManager=getSupportFragmentManager();
//       final FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//        final Fragment1 fragment1=new Fragment1();
      //intent
        txt_id = (TextView) findViewById(R.id.txt_id);
        txt_name = (TextView) findViewById(R.id.txt_name);
        txt_phone = (TextView) findViewById(R.id.txt_phone);
        txt_gender = (TextView) findViewById(R.id.txt_gender);
        txt_hobby = (TextView) findViewById(R.id.txt_hobby);
        txt_dob = (TextView) findViewById(R.id.txt_dob);
        txt_address = (TextView) findViewById(R.id.txt_address);
        btnEdit=(Button) findViewById(R.id.btnEdit);
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                List<String> list1=ViewFragment.getUser();
                //Create bunndle
                Intent i = new Intent(ImageSliderActivity.this, Main2Activity.class);
                i.putExtra("Id",ViewFragment.id);
                i.putExtra("Name",ViewFragment.username);
                i.putExtra("PhoneNumber",ViewFragment.phone_number);
                i.putExtra("Gender",ViewFragment.gender);
                i.putExtra("Hobbies",ViewFragment.hobbies);
                i.putExtra("DOB",ViewFragment.dob);
                i.putExtra("Address",ViewFragment.address);
                ImageSliderActivity.this.startActivity(i);
            }


        });
        ViewPager viewPage = (ViewPager) findViewById(R.id.viewPage);
        if (getIntent()!=null){
         id=getIntent().getStringExtra("Id");
            username = getIntent().getStringExtra("Name");
            phone_number=getIntent().getStringExtra("PhoneNumber");
            gender=getIntent().getStringExtra("Gender");
            hobbies = getIntent().getStringExtra("Hobbies");
            dob=getIntent().getStringExtra("DOB");
            address=getIntent().getStringExtra("Address");
            position1 = getIntent().getIntExtra("position",0);

        }
        getDataFromDb();
//        UserClass clas = new UserClass(username,phone_number,gender,hobbies,dob,address);
//        list.add(clas);

        for (int j =0; j< list.size();j++) {
             fragmentList.add(ViewFragment.newInstance(list.get(j).id, list.get(j).username, list.get(j).phone_number, list.get(j).gender, list.get(j).hobbies, list.get(j).dob, list.get(j).address));

        }

//            fragmentList.add(ViewFragment.newInstance(list.gtxt_phoneet(position).username, list.get(position).phone_number, list.get(position).gender, list.get(position).hobbies, list.get(position).dob, list.get(position).address));
//                Toast.makeText(this, "ur able to view", Toast.LENGTH_SHORT).show();


            // fragmentList.add(ViewFragment.newInstance(list.get(position).username, list.get(position).phone_number, list.get(position).gender, list.get(position).hobbies, list.get(position).dob, list.get(position).address));




        adapterViewPager = new MyPagerAdapter(getSupportFragmentManager(), fragmentList);
        viewPage.setAdapter(adapterViewPager);
        viewPage.setCurrentItem(position1);
        adapterViewPager.notifyDataSetChanged();

    }

    private void getDataFromDb() {
        DatabaseHelper helper = new DatabaseHelper(this);
        list = helper.getAllData();

    }

    //getUser


    @Override
    public View onCreateView(String name, Context context, AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    public class MyPagerAdapter extends FragmentStatePagerAdapter {

        private List<ViewFragment> list;

        public MyPagerAdapter(FragmentManager fm, List<ViewFragment> list) {
            super(fm);
            this.list = list;
        }


        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public int getItemPosition(Object object) {
            return POSITION_NONE;
        }

        @Override
        public Fragment getItem(int position)
        {
            return fragmentList.get(position);
        }
    }
}
