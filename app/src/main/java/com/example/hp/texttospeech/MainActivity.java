package com.example.hp.texttospeech;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    EditText textspeech;
    Button btn_speechtext;
    TextToSpeech toSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textspeech=(EditText) findViewById(R.id.textforspeech);
        btn_speechtext=(Button) findViewById(R.id.btn_speech);

        toSpeech = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status!=TextToSpeech.ERROR){
                    toSpeech.setLanguage(Locale.ENGLISH);

                }
            }
        });
        btn_speechtext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toSpeech.speak(textspeech.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
            }
        });
    }
}
