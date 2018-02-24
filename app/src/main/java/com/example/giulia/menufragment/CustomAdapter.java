package com.example.giulia.menufragment;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Giulia on 22/02/2018.
 */

public class CustomAdapter extends ArrayAdapter<Pizza> {


    private final Context context;
    private List<Pizza> items;

    //costruttore
    public CustomAdapter(Context context,List<Pizza> items) {

        super(context, R.layout.menu_fragment, items);
        this.items = items;
        this.context = context;
    }

    @TargetApi(Build.VERSION_CODES.M)

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return getViewOptimize(position, convertView, parent);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public View getViewOptimize(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, null);
            viewHolder = new ViewHolder();
            viewHolder.nameHolder = (TextView) convertView.findViewById(R.id.nome);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Pizza pizza = Utils.getItemByPosition(this.context, position);
        viewHolder.nameHolder.setText(pizza.getNome());

        return convertView;
    }


    private class ViewHolder {
        public TextView nameHolder;
    }

    public void setValues() {
        //values=Singleton.getInstance().getItemList();
        notifyDataSetChanged();
    }


}
