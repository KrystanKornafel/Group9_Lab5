package com.example.profilemanager;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.example.profilemanager.databinding.ActivityProfileBinding;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ImageView imageview = (ImageView) findViewById(R.id.imageView);
        imageview.setOnClickListener(this);
        ImageView imageview2 = (ImageView) findViewById(R.id.imageView2);
        imageview2.setOnClickListener(this);
        ImageView imageview3 = (ImageView) findViewById(R.id.imageView3);
        imageview3.setOnClickListener(this);
        ImageView imageview4 = (ImageView) findViewById(R.id.imageView4);
        imageview4.setOnClickListener(this);
        ImageView imageview5 = (ImageView) findViewById(R.id.imageView5);
        imageview5.setOnClickListener(this);
        ImageView imageview6 = (ImageView) findViewById(R.id.imageView6);
        imageview6.setOnClickListener(this);
        ImageView imageview7 = (ImageView) findViewById(R.id.imageView7);
        imageview7.setOnClickListener(this);
        ImageView imageview8 = (ImageView) findViewById(R.id.imageView8);
        imageview8.setOnClickListener(this);
        ImageView imageview9 = (ImageView) findViewById(R.id.imageView9);
        imageview9.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        SetTeamIcon(v);
    }

    private void SetTeamIcon(View v) {
        Intent returnIntent = new Intent();
        ImageView selectedImage = (ImageView) v;
        returnIntent.putExtra("ImageID", selectedImage.getId());
        setResult(RESULT_OK, returnIntent);
        finish();
    }
}