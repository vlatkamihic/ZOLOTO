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

public class PKamenje extends AppCompatActivity {
    //Initialize variable
    DrawerLayout drawerLayout;
    Button porukica;
    RecyclerView recyclerView;

    String nasloviPK[], sadrzajiPK[];
    int slikePK[]= {
            R.drawable.ahat,
            R.drawable.krizokola,
            R.drawable.jaspis,
            R.drawable.haulit
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_p_kamenje);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        recyclerView = findViewById(R.id.recyclerviewPKamenje);

        nasloviPK = getResources().getStringArray(R.array.NasloviPKamenja);
        sadrzajiPK = getResources().getStringArray(R.array.SadrzajiPKamenja);

        PKamenjeAdapter pKamenjeAdapter = new PKamenjeAdapter(this, nasloviPK, sadrzajiPK, slikePK);
        recyclerView.setAdapter(pKamenjeAdapter);
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
        //Recreate activity
        recreate();
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