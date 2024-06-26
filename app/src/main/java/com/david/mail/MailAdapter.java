package com.david.mail;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MailAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private ArrayList<MailList> mailArrayList;

    public MailAdapter(Activity activity, ArrayList<MailList> gmailArrayList) {

        this.mInflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mailArrayList = gmailArrayList;
    }

    @Override
    public int getCount() {
        return mailArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return mailArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = mInflater.inflate(R.layout.mail_list, null);
        TextView mailName = convertView.findViewById(R.id.mailName);
        TextView mailSubject = convertView.findViewById(R.id.mailSubject);
        TextView mailContent = convertView.findViewById(R.id.mailContent);
        TextView mailNames = convertView.findViewById(R.id.mailNames);
        ImageView imageView = convertView.findViewById(R.id.imageView);

        MailList mail = mailArrayList.get(position);
        mailName.setText(mail.getName());
        mailSubject.setText(mail.getSubject());
        mailContent.setText(mail.getMail());
        mailNames.setText(mail.getMailNames());
        imageView.setImageResource(mail.getImage());
        if (mail.isRead()) {
            convertView.setBackgroundColor(Color.LTGRAY); // Correo leído, color de fondo gris
        } else {
            convertView.setBackgroundColor(Color.WHITE); // Correo no leído, color de fondo blanco
        }
        return convertView;
    }
}