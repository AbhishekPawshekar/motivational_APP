package com.example.non_suicidal_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class main_page extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    TextView singinfullname,singinuser,singinemail;
    DrawerLayout drawerLayout;
    ActionBarDrawerToggle toggle;
    NavigationView navigationView;
    Toolbar toolbar;
    FirebaseFirestore fbs= FirebaseFirestore.getInstance();
    FirebaseAuth fba ;
    FirebaseUser singinuserdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        drawerLayout = findViewById(R.id.drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        getSupportFragmentManager().beginTransaction().replace(R.id.framedisplay,new home_click()).commit();
        updatenavheader();
    }
    @Override
    public void onBackPressed() {

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage("Are You Sure You Want To Exit?")
                .setCancelable(false)
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);
                        finish();

                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
    public void updatenavheader(){
        fba=FirebaseAuth.getInstance();
        singinuserdata=fba.getCurrentUser();
        navigationView=findViewById(R.id.nav_view);
        View headerview=navigationView.getHeaderView(0);
        singinfullname=headerview.findViewById(R.id.singinfullname);
        singinuser=headerview.findViewById(R.id.singinusername);
        singinemail=headerview.findViewById(R.id.singinemail);
        if(singinuserdata!=null) {
            singinemail.setText(singinuserdata.getEmail());
            fbs.collection("Customer").document(singinuserdata.getEmail()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                @Override
                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                    if(task.isSuccessful()){
                        singinfullname.setText( (String) task.getResult().get("First_Name")+" "+task.getResult().get("Last_Name"));
                        singinuser.setText((String) task.getResult().get("User_Name"));
                    }
                }
            });
        }
}
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item)
    { int id=item.getItemId();
        switch (id) {
            case R.id.account:
                startActivity(new Intent(getApplicationContext(),account_click.class));
                break;
            case R.id.home_app:
                startActivity(new Intent(this,main_page.class));
                break;

            case R.id.logout:
                if (singinuserdata != null) {
                    Intent i = new Intent(getApplicationContext(), login_page.class);
                    fba.signOut();
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "already Logout", Toast.LENGTH_SHORT).show();
                }
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}