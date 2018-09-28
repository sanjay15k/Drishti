package org.tensorflow.tensorflowdemo;

import android.content.Intent;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.tensorflow.demo.CameraActivity;
import org.tensorflow.demo.R;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener{

    private CardView findObjectCardView;
    private TextToSpeech textToSpeech;
    private boolean isIntro = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findObjectCardView = (CardView) findViewById(R.id.find_me_an_object_cardview);

        textToSpeech = new TextToSpeech(this, this);

        findObjectCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                startActivity(intent);
            }
        });
    }

    public void getSpeechInput() {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            if (isIntro){
                startActivityForResult(intent, 10);
            }
            else{
                startActivityForResult(intent, 11);
            }
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }

    @Override
    public void onInit(int status) {

        if (status == TextToSpeech.SUCCESS) {

            int result = textToSpeech.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            } else {
                if (isIntro){
                    textToSpeech.speak("Welcome to Drishti, Speak One for finding an object", TextToSpeech.QUEUE_FLUSH, null);
                    getSpeechInput();
                }
                else{
                    System.out.println("Here isIntro is false!");
                    getSpeechInput();
                }
            }

        } else {
            Log.e("TTS", "Initilization Failed!");
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        System.out.println("ResultCOde is :"+requestCode);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    System.out.println("Mine Value is "+result.get(0));

                    if (result.get(0).equals("1")){
                        System.out.println("I m one");
                        textToSpeech.speak("What object you are searching for?", TextToSpeech.QUEUE_FLUSH, null);
                        isIntro = false;
                        getSpeechInput();
                    }
                    else{
                        textToSpeech.speak("Invalid Option Chosen, Try Again", TextToSpeech.QUEUE_FLUSH, null);
                        getSpeechInput();
                    }
                }
                break;
            case 11:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

                    System.out.println("Value is :"+result);

                    String objectName = result.get(0);
                    System.out.println("ObjectName is : "+objectName);
                    Intent intent = new Intent(MainActivity.this, CameraActivity.class);
                    intent.putExtra("objectName",objectName);
                    startActivity(intent);
                }
                break;
        }
    }

}
