package com.example.jerem.seg2150_lab04;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.net.Uri;
import android.content.Intent;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    public void OnOpenInGoogleMaps(View view) {

        EditText teamAddress = (EditText) findViewById(R.id.zipInput);

        Uri gmmIntentUri = Uri.parse("http://maps.google.co.in/maps?q=" + teamAddress.getText());

        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);

        mapIntent.setPackage("com.google.android.apps.maps");

        startActivity(mapIntent);
    }

    public void OnSetAvatarButton(View view) {
        Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
        startActivityForResult(intent, 0);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_CANCELED) return;

        ImageView avatarImage = (ImageView) findViewById(R.id.icon);

        String drawableName = "icon00";

        switch(data.getIntExtra("imageID", R.id.icon)) {
            case R.id.icon00:
                drawableName = "square";
                break;
            case R.id.icon01:
                drawableName = "chrome";
                break;
            case R.id.icon02:
                drawableName = "obama";
                break;
            case R.id.icon03:
                drawableName = "kon";
                break;
            case R.id.icon04:
                drawableName = "tsm";
                break;
            case R.id.icon05:
                drawableName = "sad";
                break;
            default:
                drawableName = "tsm";
                break;
        }

        int resID = getResources().getIdentifier(drawableName, "drawable",
                getPackageName());
        avatarImage.setImageResource(resID);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
