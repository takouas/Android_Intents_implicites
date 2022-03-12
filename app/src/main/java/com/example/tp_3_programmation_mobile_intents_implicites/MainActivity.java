package com.example.tp_3_programmation_mobile_intents_implicites;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText edit_text_Url;
    private EditText edit_text_location;
    private EditText edit_text_partager_texte;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit_text_Url = findViewById(R.id.editTextUrl);
        edit_text_location = findViewById(R.id.editTextLocation);
        edit_text_partager_texte = findViewById(R.id.editTextPartagerTexte);
    }

    public void ouvrirURL(View view) {
        String url = edit_text_Url.getText().toString();
        Uri webpageUri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpageUri);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Log.d("ImplicitIntents", "Can't handle this!");
        }
    }

    public void ouvrirLOCALISATION(View view) {
        String location = edit_text_location.getText().toString();
        Uri addressUri = Uri.parse("geo:0,0?q=" + location);
        Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
        Log.d("ggggggg", "ouvrirLOCALISATION: ");

            startActivity(intent);
            Log.d("22", "ouvrirLOCALISATION: ");

    }
    public void partagerTexte(View view) {
        String text = edit_text_partager_texte.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(text)
                .startChooser();

    }


}