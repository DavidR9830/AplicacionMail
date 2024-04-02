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

        mailList.add(new MailList("Peo Estrella","Ya quedo lista la ley de la mano izquierda","P",R.menu.circle));
        mailList.add(new MailList("Nisa","It is the like).","N",R.menu.circle2));
        mailList.add(new MailList("Mehmet"," and the like).","M",R.menu.circle3));
        mailList.add(new MailList("Hülya","It is a nd the lik.","H",R.menu.circle4));
        mailList.add(new MailList("Ayşe","It is  and the like).","A",R.menu.circle5));
        mailList.add(new MailList("Semih","humour and the like).","S",R.menu.circle));
        mailList.add(new MailList("Ece","It is humour and the like).","E",R.menu.circle2));
        mailList.add(new MailList("Karsu","It is ed ur and the like).","K",R.menu.circle3));


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
            intent.putExtra("mailContent", selectedMail.getMail());
            intent.putExtra("mailNames", selectedMail.getMailNames());
            intent.putExtra("mailImage", selectedMail.getImage());


            startActivity(intent);
        });

    }



}