package com.example.zoloto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class Narukvice extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;
    Button porukica;
    RecyclerView recyclerView;

    String nasloviN[], sadrzajiN[];
    int slikeN[]= {
            R.drawable.kummitus,
            R.drawable.vapaus,
            R.drawable.envie,
            R.drawable.rahu,
            R.drawable.ancora,
            R.drawable.vincere,
            R.drawable.vigore
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_narukvice);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        recyclerView = findViewById(R.id.recyclerviewNarukvice);

        nasloviN = getResources().getStringArray(R.array.NasloviNarukvica);
        sadrzajiN = getResources().getStringArray(R.array.SadrzajiNarukvica);

        NarukviceAdapter narukviceAdapter = new NarukviceAdapter(this, nasloviN, sadrzajiN, slikeN);
        recyclerView.setAdapter(narukviceAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        setPorukica();

    }

    public void setPorukica() {
        Random rand = new Random();

        String poruke[] = getResources().getStringArray(R.array.lijepePoruke);
        porukica = (Button)findViewById(R.id.porukica);

        porukica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i1 = rand.nextInt(20 - 0);
                Toast.makeText(getBaseContext(), poruke[i1] , Toast.LENGTH_SHORT ).show();

            }
        });
    }

    public void ClickMenu(View view){
        //Open drawer
        MainActivity.openDrawer(drawerLayout);
    }

    public void ClickPocetna(View view){
        //Redirect activity to Pocetna
        MainActivity.redirectActivity(this,MainActivity.class);
    }

    public void ClickONama(View view){
        //Redirect activity to O nama
        MainActivity.redirectActivity(this,ONama.class);
    }

    public void ClickPKamenje(View view){
        //Redirect activity to PKamenje
        MainActivity.redirectActivity(this,PKamenje.class);
    }


    public void ClickIzlaz(View view){
        //Exit
        MainActivity.logout(this);
    }
}