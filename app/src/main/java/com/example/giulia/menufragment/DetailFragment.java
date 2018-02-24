package com.example.giulia.menufragment;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Giulia on 22/02/2018.
 */

public class DetailFragment extends Fragment {

    TextView nome;
    TextView descrizione;
    @TargetApi(Build.VERSION_CODES.M)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.detail_fragment, container, false);


        nome=(TextView) rootView.findViewById(R.id.NomePizza);
        descrizione=(TextView)rootView.findViewById(R.id.Description);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstance) {
        super.onViewCreated(view,savedInstance);

        Bundle bundle=getArguments();
        String name=bundle.getString("nome");
        String description=bundle.getString("description");
        nome.setText(name);
        descrizione.setText(description);
    }



}

