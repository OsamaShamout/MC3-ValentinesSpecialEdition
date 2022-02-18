package com.example.valentinesspecialeditionapp2022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private int counter =0;
    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Translate image upon entering new screen.
        ImageView language_image = (ImageView) findViewById(R.id.imageLanguage);
        language_image.setImageResource(R.drawable.question_mark);
        language_image.setX(-1000);
        language_image.animate().translationXBy(1000).rotation(360).setDuration(1000);

        //Define the spinner
        Spinner spinner_list = findViewById(R.id.listOfLanguages);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.languages, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_list.setAdapter(adapter);
        spinner_list.setOnItemSelectedListener(this);

    }

    //Back to main menu
    public void OnClickBackButton(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }

    //Take name and language, generate a random number and store in table.
    public void OnClickShowLove(View view){
        counter++;

        //Define name, language, image, and texts for Java.
        EditText full_name = (EditText) findViewById(R.id.nameEntry);
        Spinner language = (Spinner) findViewById(R.id.listOfLanguages);
        ImageView lanuage_image = (ImageView) findViewById(R.id.imageLanguage);
        TextView text_percentage = (TextView) findViewById(R.id.textPercentage);
        TextView text_output = (TextView) findViewById((R.id.textResult));
        TextView text_table = (TextView) findViewById((R.id.textScoreTable));

        AdapterView<?> parent = language;
        int number = language.getSelectedItemPosition();
        String language_chosen = language.getItemAtPosition(number).toString();
        //Get user name and favorite language.

        String user_name = full_name.getText().toString();

        //Generate a random number.
        Random rand = new Random();
        int score = rand.nextInt(101);

        //Change image according to spinner item chosen.
        if(language_chosen.equalsIgnoreCase("Java")){
            lanuage_image.setX(-1000);
            lanuage_image.animate().translationXBy(1000).rotation(360).setDuration(1000);
            lanuage_image.setImageResource(R.drawable.java);
        }
        if(language_chosen.equalsIgnoreCase("Python")){
            lanuage_image.setX(-1000);
            lanuage_image.animate().translationXBy(1000).rotation(360).setDuration(1000);
            lanuage_image.setImageResource(R.drawable.python);
        }
        if(language_chosen.equalsIgnoreCase("C")){
            lanuage_image.setX(-1000);
            lanuage_image.animate().translationXBy(1000).rotation(360).setDuration(1000);
            lanuage_image.setImageResource(R.drawable.letter_c);
        }
        if(language_chosen.equalsIgnoreCase("C++")){
            lanuage_image.setX(-1000);
            lanuage_image.animate().translationXBy(1000).rotation(360).setDuration(1000);
            lanuage_image.setImageResource(R.drawable.c_);
        }
        if(language_chosen.equalsIgnoreCase("PHP")){
            lanuage_image.setX(-1000);
            lanuage_image.animate().translationXBy(1000).rotation(360).setDuration(1000);
            lanuage_image.setImageResource(R.drawable.php);
        }
        if(language_chosen.equalsIgnoreCase("JavaScript")){
            lanuage_image.setImageResource(R.drawable.js);
        }
        if(language_chosen.equalsIgnoreCase("SQL")){
            lanuage_image.setX(-1000);
            lanuage_image.animate().translationXBy(1000).rotation(360).setDuration(1000);
            lanuage_image.setImageResource(R.drawable.sql_server);
        }
        if(language_chosen.equalsIgnoreCase("Ruby")){
            lanuage_image.setX(-1000);
            lanuage_image.animate().translationXBy(1000).rotation(360).setDuration(1000);
            lanuage_image.setImageResource(R.drawable.ruby);
        }
        if(language_chosen.equalsIgnoreCase("Choose an item") || language_chosen.isEmpty()){
            lanuage_image.setX(-1000);
            lanuage_image.animate().translationXBy(1000).rotation(360).setDuration(1000);
            lanuage_image.setImageResource(R.drawable.question_mark);
            text_output.setText("Please enter a valid language.");
            return;
        }

        //Print out result string
        String value_score = String.valueOf(score);

        text_percentage.setText(value_score + "%");

        if(score >= 80){
            text_output.setText("Wow. That much love!");
        }
        else if(score >= 60){
            text_output.setText("Well. Not bad...");
        }
        else if(score >= 40){
            text_output.setText("Mediocre at best.");
        }
        else if(score >= 0){
            text_output.setText("Try flirting more?");
        }

        //Storing data
        String text_scores = value_score + "\t" + language_chosen + "\t\t - " + user_name + "\n";
        text_table.append(text_scores);

        //Reset score after 3 trials.
        if(counter==4){
            text_table.setText("");
            text_table.append(text_scores);
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String text = adapterView.getItemAtPosition(i).toString();
        Toast.makeText(adapterView.getContext(), text, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}