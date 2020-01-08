package com.example.inicio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RemoteViews;

public class Notificando extends AppCompatActivity
{

    private static final String CHANNEL_ID = "canal";

    EditText txtTitulo;
    EditText txtMensaje;
    EditText txtSegundos;

    Button btnNotificando;

    String titulo;
    String mensaje;
    int segundos;

    PendingIntent i;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificando);
        createNotificationChannel();

        txtTitulo = findViewById(R.id.txtTitulo);
        txtMensaje = findViewById(R.id.txtTexto);
        txtSegundos = findViewById(R.id.txtSegundos);
        btnNotificando = findViewById(R.id.btnNotificando);



        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        i = PendingIntent.getActivity(this, 0, getIntent(), 0);

        // Apply the layouts to the notification




        btnNotificando.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                notificar(v);
            }
        });
    }

    public void notificar (View view)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.babyyoda)
                .setContentTitle("TÍTULO")
                .setContentText("TEXTO")
                //.setTimeoutAfter(6000)
                .setColor(Color.MAGENTA)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

        // notificationId is a unique int for each notification that you must define
        notificationManager.notify(0, builder.build());
    }

    private void createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = ("nombre");
            String description = ("descripción");
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

}