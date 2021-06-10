package com.jp.practicawd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.jp.practicawd.ApiManager.RetrofitClient;
import com.jp.practicawd.models.Whisky;
import com.jp.practicawd.models.WhiskyAdapter;

import java.util.List;

import id.ionbit.ionalert.IonAlert;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    ListView listWhisky;
    Whisky myWhisky;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listWhisky = findViewById(R.id.listWhisky);
        //new IonAlert(this).setTitleText("El promedio de los productos es:  ").show();
        new IonAlert(this)
                .setTitleText("Whiskies!")
                .setContentText("Continuar")
                .show();


        getMainWhisky();
        listWhisky.setOnItemClickListener(this);

    }
    private void getMainWhisky(){
        Call<List<Whisky>> call= RetrofitClient.getInstance().getMyApi().getWhisky();
        call.enqueue(new Callback <List<Whisky>>() {
            @Override
            public void onResponse(Call<List<Whisky>> call, Response<List<Whisky>> response) {
                List<Whisky> myWhisky= response.body();
                WhiskyAdapter adapter=new WhiskyAdapter(MainActivity.this,myWhisky);
                listWhisky.setAdapter(adapter);

            }

            @Override
            public void onFailure(Call <List<Whisky>> call, Throwable t) {
                Toast.makeText(getApplicationContext(),"Ocurrio Error",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {



        Intent in=new Intent(this,DetailsWhisky.class);
        //in.putExtra("id",myCivilizaciones.getCivilizationList().get(position).getIdCivilization());
        startActivity(in);
        //new IonAlert(this).setTitleText("El promedio de los productos es:  ").show();

    }


    //new IonAlert(this).setTitleText("El promedio de los productos es:  ").show();

    }




