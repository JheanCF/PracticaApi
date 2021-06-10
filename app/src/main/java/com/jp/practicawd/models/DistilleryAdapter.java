package com.jp.practicawd.models;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.jp.practicawd.R;

import java.util.List;

public class DistilleryAdapter extends BaseAdapter {
    protected Activity activity;
    protected List<Distillery> myDistillery;

    public DistilleryAdapter(Activity activity, List<Distillery> distillerieslist) {
        this.activity=activity;
        this.myDistillery=distillerieslist;
    }

    @Override
    public int getCount() {
        return myDistillery.size();
    }

    @Override
    public Object getItem(int position) {
        return myDistillery.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=convertView;
        if (convertView==null){
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v=inf.inflate(R.layout.distillery_item,null);
        }
        Distillery distillery=myDistillery.get(position);

        TextView nameDistillery =v.findViewById(R.id.tvNameDistillery);
        nameDistillery.setText(distillery.getNameDistillery());

        TextView slugDistillery =v.findViewById(R.id.tvSlugDistillery);
        slugDistillery.setText("SLUG: "+distillery.getSlugDistillery());

        TextView countryDistillery =v.findViewById(R.id.tvCountryDistillery);
        countryDistillery.setText("COUNTRY: "+distillery.getCountryDistillery());

        return v;
    }
}
