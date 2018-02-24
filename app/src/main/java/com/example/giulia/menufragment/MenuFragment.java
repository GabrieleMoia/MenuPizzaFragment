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

    OnHeadlineSelectedListener mCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (OnHeadlineSelectedListener) getActivity();
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().toString() + "must implementOnHeadlineSelectedListener");
        }
    }

    public interface OnHeadlineSelectedListener{
        public void onArticleSelected(int position);

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


                Pizza pizza = (Utils.getItemByPosition(getActivity(), position));


                DetailFragment detailFragment= new DetailFragment();
                Bundle bundle=new Bundle();
                bundle.putString("description", pizza.getDescription());
                bundle.putString("nome",pizza.getNome());

                detailFragment.setArguments(bundle);

                //mCallback.onArticleSelected(position);


                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

                fragmentTransaction.replace(R.id.container,detailFragment).commit();

                /*Intent intent=new Intent(getActivity().getBaseContext(),MainActivity.class);

                intent.putExtra("nome", pizza.getNome());
                startActivity(intent);*/
            }
        });

        //click sull'item della lista
    }


}
