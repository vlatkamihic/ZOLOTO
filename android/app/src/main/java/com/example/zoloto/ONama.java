package com.example.zoloto;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class ONama extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;
    Button porukica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_nama);

        drawerLayout = findViewById(R.id.drawer_layout);

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
        //Recreate activity
        recreate();
    }

    public void ClickPKamenje(View view){
        //Redirect activity to PKamenje
        MainActivity.redirectActivity(this,PKamenje.class);
    }

    public void ClickNarukvice(View view){
        //Redirect activity to Narukvice
        MainActivity.redirectActivity(this,Narukvice.class);
    }

    public void ClickIzlaz(View view){
        //Exit
        MainActivity.logout(this);
    }
}