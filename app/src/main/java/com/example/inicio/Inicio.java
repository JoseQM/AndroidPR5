package com.example.inicio;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Inicio extends AppCompatActivity
{

    Button btnToast;
    Button btnNotificacion;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incio);

        btnToast = findViewById(R.id.btnToast);
        btnNotificacion = findViewById(R.id.btnNotificacion);

        btnToast.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent1 = new Intent (v.getContext(), Toasteando.class);
                startActivity(intent1);
            }
        });

        btnNotificacion.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent2 = new Intent (v.getContext(), Notificando.class);
                startActivity(intent2);
            }
        });
    }
}