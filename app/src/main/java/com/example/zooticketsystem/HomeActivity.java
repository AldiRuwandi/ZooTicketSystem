package com.example.zooticketsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.github.florent37.shapeofview.shapes.CircleView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    LinearLayout btn_ticket_berlin, btn_ticket_sandiego,
            btn_ticket_taronga, btn_ticket_singapore,
            btn_ticket_wroclaw, btn_ticket_vieena;
    CircleView btn_to_profile;
    ImageView photo_home_user;
    TextView user_balance, bio, nama_lengkap;

    DatabaseReference reference;

    String USERNAME_KEY = "usernamekey";
    String username_key = "";
    String username_key_new = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        getUsernameLocal();

        btn_ticket_berlin = findViewById(R.id.btn_ticket_berlin);
        btn_ticket_sandiego = findViewById(R.id.btn_ticket_sandiego);
        btn_ticket_taronga = findViewById(R.id.btn_ticket_taronga);
        btn_ticket_singapore = findViewById(R.id.btn_ticket_singapore);
        btn_ticket_wroclaw = findViewById(R.id.btn_ticket_wraclaw);
        btn_ticket_vieena = findViewById(R.id.btn_ticket_vienna);

        btn_to_profile = findViewById(R.id.btn_to_profile);
        photo_home_user = findViewById(R.id.photo_home_user);
        user_balance = findViewById(R.id.user_balance);
        bio = findViewById(R.id.bio);
        nama_lengkap = findViewById(R.id.nama_lengkap);

        reference = FirebaseDatabase.getInstance("https://myzooticket-default-rtdb.firebaseio.com/")
                .getReference().child("Users").child(username_key_new);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                nama_lengkap.setText(dataSnapshot.child("nama_lengkap").getValue().toString());
                bio.setText(dataSnapshot.child("bio").getValue().toString());
                user_balance.setText("US$" + dataSnapshot.child("user_balance").getValue().toString());
                Picasso.with(HomeActivity.this)
                        .load(dataSnapshot.child("url_photo_profile").getValue().toString()).centerCrop().fit().into(photo_home_user);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btn_ticket_berlin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototicket = new Intent(HomeActivity.this, TicketDetailActivity.class);
                //meletakkan data pada intent
                gototicket.putExtra("jenis_tiket", "Berlin Zoological Garden");
                startActivity(gototicket);
            }
        });


        btn_ticket_sandiego.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototicket = new Intent(HomeActivity.this, TicketDetailActivity.class);
                gototicket.putExtra("jenis_tiket", "San Diego Zoo");
                startActivity(gototicket);
            }
        });


        btn_ticket_taronga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototicket = new Intent(HomeActivity.this, TicketDetailActivity.class);
                gototicket.putExtra("jenis_tiket", "Taronga Zoo");
                startActivity(gototicket);
            }
        });


        btn_ticket_singapore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototicket = new Intent(HomeActivity.this, TicketDetailActivity.class);
                gototicket.putExtra("jenis_tiket", "Singapore Zoo");
                startActivity(gototicket);
            }
        });


        btn_ticket_wroclaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototicket = new Intent(HomeActivity.this, TicketDetailActivity.class);
                gototicket.putExtra("jenis_tiket", "Wroclaw Zoological Gardens");
                startActivity(gototicket);
            }
        });


        btn_ticket_vieena.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gototicket = new Intent(HomeActivity.this, TicketDetailActivity.class);
                gototicket.putExtra("jenis_tiket", "Vienna Zoo");
                startActivity(gototicket);
            }
        });

        btn_to_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoprofile = new Intent(HomeActivity.this, MyProfileActivity.class);
                startActivity(gotoprofile);
            }
        });
    }

    public void getUsernameLocal(){
        SharedPreferences sharedPreferences = getSharedPreferences(USERNAME_KEY, MODE_PRIVATE);
        username_key_new = sharedPreferences.getString(username_key, "");
    }
}
