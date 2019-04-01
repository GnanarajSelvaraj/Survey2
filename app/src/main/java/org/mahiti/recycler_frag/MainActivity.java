package org.mahiti.recycler_frag;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
RecyclerView recyclerView;
LayoutInflater inflater;
//ViewPage  viewPage;
    Button btnTheme;
 //   FloatingActionButton fab;

    public static FragmentManager fragmentManager;
    private ViewGroup parent_layout;
//    public static int SPLASH_TIME_OUT=4000;
SharedPreferences sharedPreferences;
    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedPreferences = getSharedPreferences("pref", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();

        Random r= new Random();
        int theme=r.nextInt(4)+1;
switch (theme){
    case 1:
        setTheme(R.style.AppTheme);
        editor.putInt("theme", R.style.AppTheme);
        editor.putInt("theme1",R.style.AppTheme);
        editor.apply();
        editor.commit();
      //  setTheme(R.id.fab);
        break;
    case 2:
        setTheme(R.style.AppTheme2);
       // setTheme(R.id.fab);
        editor.putInt("theme", R.style.AppTheme2);
        editor.putInt("theme1",R.style.AppTheme2);

        editor.apply();
        editor.commit();
        break;
    case 3:
        setTheme(R.style.AppTheme3);
      // setTheme(R.id.fab);
        editor.putInt("theme", R.style.AppTheme3);

        editor.putInt("theme1",R.style.AppTheme3);
        editor.apply();
        editor.commit();
        break;
    case 4:
        setTheme(R.style.AppTheme4);
        //setTheme(R.id.fab);
        editor.putInt("theme1",R.style.AppTheme4);
        editor.putInt("theme", R.style.AppTheme4);
        editor.apply();
        editor.commit();
        break;
    default:

}
        setContentView(R.layout.activity_main);




btnTheme=(Button) findViewById(R.id.btn_Theme);
btnTheme.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
Intent intent=new Intent(getApplicationContext(),MainActivity.class);
MainActivity.this.startActivity(intent);
finish();

    }

});

    fragmentManager=getSupportFragmentManager();
        if (findViewById(R.id.fragment_container )!=null){
            if(savedInstanceState !=null)
            {
        return;
            }
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
//            recyclerView/=findViewById(R.id.recyclerView);
         RecyclerView_fragment recyclerView_fragment =new RecyclerView_fragment();

      //      View view = inflater.inflate(R.layout.fragment_no_record_fragment, parent_layout, false);
            fragmentTransaction.add(R.id.fragment_container, recyclerView_fragment,null);
            fragmentTransaction.detach(recyclerView_fragment);
            fragmentTransaction.attach(recyclerView_fragment);

            fragmentTransaction.commit();

        }


    }
}
