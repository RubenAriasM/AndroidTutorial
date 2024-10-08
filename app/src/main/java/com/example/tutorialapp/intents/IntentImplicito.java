package com.example.tutorialapp.intents;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.tutorialapp.R;

public class IntentImplicito extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_intent_implicito);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView textViewComida = findViewById(R.id.textViewFood);
        TextView textViewBebida = findViewById(R.id.textViewDrink);

        //Recover data

        Bundle extras = getIntent().getExtras();

        String textoPrueba = extras.getString("Prueba");
        String comida = extras.getString("Comida");
        String bebida = extras.getString("Bebida");

        textViewComida.setText(comida);
        textViewBebida.setText(bebida);
        Log.d("Prueba", textoPrueba);

        //Intent Implicito componente
        ImageButton imageButton = findViewById(R.id.ImageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //INTERNET URL
                String url="https://www.yelp.com/search?cflt=kebab&find_loc=Gij%C3%B3n%2C+Asturias";
                Intent intentUrl = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intentUrl);

                //ALARMA
                Intent intentAlarma = new Intent(AlarmClock.ACTION_SET_ALARM)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "message")
                        .putExtra(AlarmClock.EXTRA_HOUR, 8)
                        .putExtra(AlarmClock.EXTRA_MINUTES, 43);
                startActivity(intentAlarma);


            }
        });

    }
}