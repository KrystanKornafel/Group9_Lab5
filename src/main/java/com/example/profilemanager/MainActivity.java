package com.example.profilemanager;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button googleMaps = (Button) findViewById(R.id.googleMaps);
        googleMaps.setOnClickListener(this);
        ImageView profilePicture = (ImageView) findViewById(R.id.profilePicture);
        profilePicture.setOnClickListener(this);
        EditText teamName = (EditText) findViewById(R.id.teamName);
        EditText teamAddress = (EditText) findViewById(R.id.teamAddress);
        int resID = getResources().getIdentifier("flag_ca", "drawable", getPackageName());
        profilePicture.setImageResource(resID);
    }


    public void onClick(View v) {
        if (v.getId() == R.id.googleMaps) {
            OnOpenInGoogleMaps(v);
        } else if (v.getId() == R.id.profilePicture) {
            OnSetAvatarButton(v);
        }
    }

    public void OnOpenInGoogleMaps(View view) {
        EditText teamAddress = (EditText) findViewById(R.id.teamAddress);
        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    ActivityResultLauncher<Intent> profileActivityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        Intent data = result.getData();
                        ImageView profilePicture = (ImageView) findViewById(R.id.profilePicture);
                        String drawableName = "flag_ca";
                        int imageId = data.getIntExtra("ImageID", R.id.imageView);
                        if (imageId == R.id.imageView) {
                            drawableName = "flag_ca";
                        } else if (imageId == R.id.imageView2) {
                            drawableName = "flag_eg";
                        } else if (imageId == R.id.imageView3) {
                            drawableName = "flag_fr";
                        } else if (imageId == R.id.imageView4) {
                            drawableName = "flag_jp";
                        } else if (imageId == R.id.imageView5) {
                            drawableName = "flag_kr";
                        } else if (imageId == R.id.imageView6) {
                            drawableName = "flag_sp";
                        } else if (imageId == R.id.imageView7) {
                            drawableName = "flag_tr";
                        } else if (imageId == R.id.imageView8) {
                            drawableName = "flag_uk";
                        } else if (imageId == R.id.imageView9) {
                            drawableName = "flag_us";
                        }
                        int resID = getResources().getIdentifier(drawableName, "drawable", getPackageName());
                        profilePicture.setImageResource(resID);
                    }
                }
            });

    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        profileActivityResultLauncher.launch(intent);
    }
}