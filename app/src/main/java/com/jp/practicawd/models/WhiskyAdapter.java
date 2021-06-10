package com.jp.practicawd.models;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.jp.practicawd.MainActivity;
import com.jp.practicawd.R;

import java.util.List;

public class WhiskyAdapter extends BaseAdapter {
    protected Activity activity;
    protected List<Whisky> myWhisky;

    public WhiskyAdapter(Activity activity, List<Whisky> whiskieslist) {
        this.activity=activity;
        this.myWhisky=whiskieslist;
    }

    @Override
    public int getCount() {
        return myWhisky.size();
    }

    @Override
    public Object getItem(int position) {
        return myWhisky.get(position);
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
            v=inf.inflate(R.layout.wiskhey_item,null);
        }
        Whisky whisky=myWhisky.get(position);

        TextView nameWhisky =v.findViewById(R.id.tvName);
        nameWhisky.setText(whisky.getNameWhisky());

        TextView slugWhisky =v.findViewById(R.id.tvSlug);
        slugWhisky.setText("SLUG: "+whisky.getSlugWhisky());

        Button urlWhisky =v.findViewById(R.id.btnUrl);
        String url=whisky.getUrlWhisky();
        urlWhisky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btnUrl) {
                    Uri link=Uri.parse(url);
                    Intent i=new Intent(Intent.ACTION_VIEW,link);
                    activity.startActivity(i);
                }

            }
        });

        TextView moneyWhisky =v.findViewById(R.id.tvMoney);
        moneyWhisky.setText("MONEY: "+whisky.getMoneyWhisky());
        return v;
    }
}
