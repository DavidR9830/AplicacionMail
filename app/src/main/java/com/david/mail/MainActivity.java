package com.david.mail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView gmailListView;
    final ArrayList<MailList> mailList = new ArrayList<>();
    FloatingActionButton sendMessage;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        sendMessage = findViewById(R.id.sendMessage);
        sendMessage.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(),SendMessage.class);
            startActivity(intent);
        });

        gmailListView = findViewById(R.id.gmailListView);

        mailList.add(new MailList("Valentina","Informe","Ya esta finalizado el informe solicitado","V",R.menu.circle));
        mailList.add(new MailList("Yenifer","Cerificado","Escribo para solicitar certificado de estudio","Y",R.menu.circle2));
        mailList.add(new MailList("Nubank","Tarjeta aprobada"," Su tarjeta de credito ha sido aprobada y le será entregada " +
                "en una de nuestas sedes","N",R.menu.circle3));
        mailList.add(new MailList("Google","¿Fuiste tu?","Se ha detectado un nuevo inicio de sesión cerca a Medellín","G",R.menu.circle4));
        mailList.add(new MailList("Didi","Calificación","Recuerda calificar tu experiencia viajando con nostros," +
                " hazlo desde la app, al finalziar el viaje","D",R.menu.circle5));
        mailList.add(new MailList("Mercado libre","Pedido #86","Su pedido se ha envíado a la dirrección correspondiente" +
                "recuerda que puedes rastreatlo desde nuestra app","M",R.menu.circle));
        mailList.add(new MailList("Sura eps","Cita programada","Recuerda tu cita con médico general el 12/05/2024 a las 15:00","S",R.menu.circle2));
        mailList.add(new MailList("Wom","Aprovecha la promo","Recuerda que con nuestro plan pospago tienes más megas para disfrutar," +
                "ingresa y unete","W",R.menu.circle3));


        MailAdapter mailAdapter = new MailAdapter(this, mailList);
        if (gmailListView != null) {
            gmailListView.setAdapter(mailAdapter);
        }

        gmailListView.setOnItemClickListener((parent, view, position, id) -> {
            MailList selectedMail = mailList.get(position);

            // Marcar el correo como leído
            selectedMail.setRead(true);

            // Notificar al adaptador sobre el cambio en los datos
            mailAdapter.notifyDataSetChanged();


            // Crear un intent para pasar a la actividad MailDetails
            Intent intent = new Intent(MainActivity.this, MailDetails.class);


            intent.putExtra("mailName", selectedMail.getName());
            intent.putExtra("mailSubject", selectedMail.getSubject());
            intent.putExtra("mailContent", selectedMail.getMail());
            intent.putExtra("mailNames", selectedMail.getMailNames());
            intent.putExtra("mailImage", selectedMail.getImage());


            startActivity(intent);
        });

    }



}