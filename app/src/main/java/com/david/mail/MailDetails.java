package com.david.mail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MailDetails extends Activity {

    Button back,backMail,reply,replyAll;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maildetails);

        // Obtener los datos del intento
        Intent intent1 = getIntent();
        String mailName = intent1.getStringExtra("mailName");
        String mailContent = intent1.getStringExtra("mailContent");
        String mailNames = intent1.getStringExtra("mailNames");
        int mailImage = intent1.getIntExtra("mailImage", 0);

        // Encontrar los elementos de la interfaz de usuario y establecer los datos
        TextView mailNameTextView = findViewById(R.id.mailName);
        TextView mailContentTextView = findViewById(R.id.mailContent);
        TextView mailNamesTextView = findViewById(R.id.mailNames);
        ImageView imageView = findViewById(R.id.imageView);

        mailNameTextView.setText(mailName);
        mailContentTextView.setText(mailContent);
        mailNamesTextView.setText(mailNames);
        imageView.setImageResource(mailImage);



        back = findViewById(R.id.back);
        back.setOnClickListener(v -> {
            finish();
        });
        backMail = findViewById(R.id.backMail);
        backMail.setOnClickListener(v -> {
            finish();
        });

        reply = findViewById(R.id.reply);
        reply.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(),SendMessage.class);
            startActivity(intent);
        });

        replyAll = findViewById(R.id.replyAll);
        replyAll.setOnClickListener(v -> {
            Intent intent = new Intent(getApplication(),SendMessage.class);
            startActivity(intent);
        });
    }
}
