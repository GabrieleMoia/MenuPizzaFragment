package com.example.giulia.menufragment;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;


public class MainActivity extends Activity implements OnHeadLinesFragment {

    MenuFragment menuFragment = new MenuFragment();
    FragmentManager fragmentManager = getFragmentManager();
    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
    DetailFragment detailFragment = new DetailFragment();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Log.d("DEBUG", getResources().getConfiguration().orientation + "");
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            if (savedInstanceState == null) {
                fragmentTransaction.add(R.id.container, menuFragment);
                fragmentTransaction.commit();
            }

        } else {

            Bundle bundle = new Bundle();
            bundle.putString("name", Utils.getItemByPosition(getBaseContext(), 0).getNome());
            bundle.putString("description", Utils.getItemByPosition(getBaseContext(), 0).getDescription());

            detailFragment.setArguments(bundle);

            fragmentTransaction.add(R.id.menu_container, menuFragment);
            fragmentTransaction.add(R.id.detail_container, detailFragment);

            fragmentTransaction.commit();

        }
    }


    @Override
    public void onArticleSelected(int position) {
        DetailFragment detailFragment = new DetailFragment();
        Pizza pizza = (Utils.getItemByPosition(getBaseContext(), position));
        Bundle bundle = new Bundle();
        bundle.putString("description", pizza.getDescription());
        bundle.putString("name", pizza.getNome());
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {

            detailFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.container, detailFragment);
            fragmentTransaction.addToBackStack(null).commit();

        } else {
            detailFragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.detail_container,detailFragment);
            fragmentTransaction.addToBackStack(null).commit();

        }
    }

}

