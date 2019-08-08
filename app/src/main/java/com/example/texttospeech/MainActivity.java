package com.example.texttospeech;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    Button button;
    TextToSpeech toSpeech; //creating object



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=(EditText)findViewById(R.id.text);
        button=(Button)findViewById(R.id.button);
        //now object ki madat se method create krenge
        //aur usme 2 chij pass krenge 1)contest 2)
        toSpeech= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i!=TextToSpeech.ERROR){
                    toSpeech.setLanguage(Locale.UK);

                }
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tospeech is a ojject of text to speech
                //toSpeech.speak me 2 chij pass krenge 1)text jo enput hoga
                // 2nd) us text ko convert krne ka parapeter
                //so that click krne pe convert ho jaye
                toSpeech.speak(editText.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);

            }
        });



    }
}
