package com.example.zoloto;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import java.util.Random;

import static android.widget.Toast.makeText;


public class MainActivity extends AppCompatActivity{
    //Initialize variable
    DrawerLayout drawerLayout;
    EditText editText;
    CheckBox cb1, cb2, cb3;
    Button button;
    Button porukica;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assign variable
        drawerLayout = findViewById(R.id.drawer_layout);

        setPorukica();
        mojiFavoriti();

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

    int i = 0;

    public void mojiFavoriti(){


        editText = (EditText) findViewById(R.id.editTextFavoriti);
        cb1 = (CheckBox) findViewById(R.id.checkBox);
        cb2 = (CheckBox) findViewById(R.id.checkBox2);
        cb3 = (CheckBox) findViewById(R.id.checkBox3);
        button = (Button) findViewById(R.id.buttonAdd);


        // Attaching OnClick listener to the submit button
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String newFavorit = editText.getText().toString();

                switch (i){
                    case 0: cb1.setText(newFavorit); break;
                    case 1: cb2.setText(newFavorit); break;
                    case 2: cb3.setText(newFavorit); break;
                }
                if(i == 2){
                    i = 0;
                }else {
                    i++;
                }
            }
        });

    }

    public void ClickMenu(View view){
        //Open drawer
        openDrawer(drawerLayout);
    }


    public static void openDrawer(DrawerLayout drawerLayout) {
        //Open drawer layout
        drawerLayout.openDrawer(GravityCompat.START);
    }


    public static void closeDrawer(DrawerLayout drawerLayout){
        //Close drawer layout
        //Check condition
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            //When drawer is open
            //Close drawer
            drawerLayout.closeDrawer(GravityCompat.START);
        }
    }

    public void ClickPocetna(View view){
        //Recreate activity
        recreate();
    }

    public void ClickONama(View view){
        //Redirect activity to O nama
        redirectActivity(this,ONama.class);
    }

    public void ClickPKamenje(View view){
        //Redirect activity to Poludrago kamenje
        redirectActivity(this,PKamenje.class);
    }

    public void ClickNarukvice(View view){
        //Redirect activity to Narukvice
        redirectActivity(this,Narukvice.class);
    }


    public void ClickIzlaz(View view){
        //Exit
        logout(this);
    }

    public static void logout(Activity activity){
        //Initialize alert dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        //Set title
        builder.setTitle("Izlaz");
        //Set message
        builder.setMessage("Jeste li sigurni da želite izaći iz aplikacije?");
        //Positive yes button
        builder.setPositiveButton("DA", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Finish activity
                activity.finishAffinity();
                //Exit app
                System.exit(0);
            }
        });
        //Negative no button
        builder.setNegativeButton("NE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //Dismiss dialog
                dialog.dismiss();
            }
        });
        //Show dialog
        builder.show();
    }

    public static void redirectActivity(Activity activity, Class aClass){
        //Initialize intent
        Intent intent = new Intent(activity, aClass);
        //Set flag
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        //Start activity
        activity.startActivity(intent);
    }


    @Override
    protected void onPause() {
        super.onPause();
        //Close drawer
        closeDrawer(drawerLayout);
    }
}