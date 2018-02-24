package com.example.giulia.menufragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends Activity implements MenuFragment.OnHeadlineSelectedListener{



    public void onArticleSelected(int position) {


      /* DetailFragment detailFragment = new DetailFragment();


       bundle.putString("nome",getArguments().toString());

       detailFragment.setArguments(bundle);

       FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction().replace(R.id.container,detailFragment);
       fragmentTransaction.commit();


        /*Intent intent=getIntent();
        String nome=intent.getStringExtra("nome");

        Intent intent1=new Intent(MainActivity.this, DetailFragment.class);

        intent1.putExtra("nome",nome);
        startActivity(intent1);*/
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);



        if (savedInstanceState == null)
        {
            MenuFragment menuFragment =new MenuFragment();
            FragmentManager fragmentManager= getFragmentManager();
            FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();

            fragmentTransaction.add(R.id.container, menuFragment);
            fragmentTransaction.commit();
        }

    }






}

