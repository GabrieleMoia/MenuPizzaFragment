package com.example.giulia.menufragment;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

public class MenuFragment extends Fragment  {

    OnHeadLinesFragment mCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnHeadLinesFragment) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "must implementOnHeadlineSelectedListener");
        }
    }


    @TargetApi(Build.VERSION_CODES.M)

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.menu_fragment, container, false);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstance) {

        super.onViewCreated(view, savedInstance);

        Utils.initDataSource(getActivity());

        CustomAdapter ca = new CustomAdapter(getActivity(), Utils.getDataSource());

        ListView pizzaList = view.findViewById(R.id.listView);

        pizzaList.setAdapter(ca);

        pizzaList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                mCallback.onArticleSelected(position);



            }
        });

        //click sull'item della lista
    }


}
