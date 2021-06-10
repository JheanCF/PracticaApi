package com.jp.practicawd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jp.practicawd.ApiManager.RetrofitClient;
import com.jp.practicawd.models.Distillery;
import com.jp.practicawd.models.DistilleryAdapter;
import com.jp.practicawd.models.Whisky;
import com.jp.practicawd.models.WhiskyAdapter;

import java.util.List;

import id.ionbit.ionalert.IonAlert;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Distilleries extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView listDistillery;
    Whisky myWhisky;
    List<Whisky> wikiList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_distilleries);

        listDistillery=findViewById(R.id.listDistillery);

        new IonAlert(this)
                .setTitleText("Whiskies!")
                .setContentText("Continuar")
                .show();
        getMainDistillery();
        listDistillery.setOnItemClickListener(this);
    }

    private void getMainDistillery() {
        Call<List<Distillery>> call= RetrofitClient.getInstance().getMyApi().getDistillery();
        call.enqueue(new Callback<List<Distillery>>() {
            @Override
            public void onResponse(Call<List<Distillery>> call, Response<List<Distillery>> response) {

                List<Distillery> myDistillery= response.body();
                DistilleryAdapter adapter=new DistilleryAdapter(Distilleries.this,myDistillery);
                listDistillery.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call<List<Distillery>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio Error",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //Intent in=new Intent(this,InicialApi.class);
        //in.putExtra("id",myCivilizaciones.getCivilizationList().get(position).getIdCivilization());
        //startActivity(in);
        new IonAlert(this).setTitleText(wikiList.get(position).getNameWhisky()).show();

    }
}