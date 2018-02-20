package com.example.adrianmontes.abrirnotificacionsuperior;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    //esta notificacion se lanza cuando la creemos, el sentido es que se lanze al acabar un hilo, o cuando queramos enseñar algo despues de una accion
    public void metodoBoton(View view){

        //vamos a abrir una web a traves de un intent cuando le damos a la notificacion
        Intent intento=new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        //ahora dejamos pendiente a que alguien pulse la notificacion, para que en ese momento la lancemos
        PendingIntent pendingIntent=PendingIntent.getActivity(this,0,intento,0);

        //construimos la notificacion,
        NotificationCompat.Builder buider =new NotificationCompat.Builder(this);
        buider.setSmallIcon(android.R.drawable.ic_notification_clear_all);
        buider.setContentTitle("Notificacion basica");
        buider.setContentText("Aprender mas android");
        buider.setSubText("pulsar para abrir la web");
        //le decimos que cuando clickes sobre la notificacioon abra el intento pendiente
        buider.setContentIntent(pendingIntent);

        //Enviamos la notificacion
        NotificationManager notificacionManager=(NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        notificacionManager.notify(0,buider.build());
    }


}
