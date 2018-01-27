package bestquiz.sbl.operaquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {


    // We declare the Views that need to be used in methods in order to initialize them in the onCreate method
    TextView nameView ;
    RadioButton Answer1;
    EditText Answer2;
    TextView q1VText;
    TextView q2VText;
    CheckBox Answer3e1;
    CheckBox Answer3e2;
    CheckBox Answer3f1;
    CheckBox Answer3f2;
    EditText Answer4;
    TextView q3VText;
    TextView q4VText;
    RadioButton Answer5 ;
    TextView q5VText ;
    EditText Answer6 ;
    TextView q6VText ;
    RadioButton Answer7 ;
    TextView q7VText ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // We initialize the Views in order to save CPU
        nameView = findViewById(R.id.nameField) ;
        Answer1 = findViewById(R.id.answer1);
        Answer2 = findViewById(R.id.answer2);
        q1VText =  findViewById(R.id.q1VText);
        q2VText =  findViewById(R.id.q2VText);
        Answer3e1 =  findViewById(R.id.answer3e1);
        Answer3e2 =  findViewById(R.id.answer3e2);
        Answer3f1 =  findViewById(R.id.answer3f1);
        Answer3f2 =  findViewById(R.id.answer3f2);
        Answer4 =  findViewById(R.id.answer4);
        q3VText =  findViewById(R.id.q3VText);
        q4VText =  findViewById(R.id.q4VText);
        Answer5 = findViewById(R.id.answer5);
        q5VText = findViewById(R.id.q5VText) ;
        Answer6 = findViewById(R.id.answer6) ;
        q6VText = findViewById(R.id.q6VText) ;
        Answer7 = findViewById(R.id.answer7) ;
        q7VText = findViewById(R.id.q7VText) ;


    }


    // We modify the onSaveInstanceState and onRestoreInstanceState methods in order to save the explainations text if the device is rotated
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("q1VText", q1VText.getText().toString());
        outState.putInt("q1VColor", q1VText.getCurrentTextColor());
        outState.putString("q2VText", q2VText.getText().toString());
        outState.putInt("q2VColor", q2VText.getCurrentTextColor());
        outState.putString("q3VText", q3VText.getText().toString());
        outState.putInt("q3VColor", q3VText.getCurrentTextColor());
        outState.putString("q4VText", q4VText.getText().toString());
        outState.putInt("q4VColor", q4VText.getCurrentTextColor());
        outState.putString("q5VText", q5VText.getText().toString());
        outState.putInt("q5VColor", q5VText.getCurrentTextColor());
        outState.putString("q6VText", q6VText.getText().toString());
        outState.putInt("q6VColor", q6VText.getCurrentTextColor());
        outState.putString("q7VText", q7VText.getText().toString());
        outState.putInt("q7VColor", q7VText.getCurrentTextColor());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        q1VText.setText(savedInstanceState.getString("q1VText"));
        q1VText.setTextColor(savedInstanceState.getInt("q1VColor"));
        q2VText.setText(savedInstanceState.getString("q2VText"));
        q2VText.setTextColor(savedInstanceState.getInt("q2VColor"));
        q3VText.setText(savedInstanceState.getString("q3VText"));
        q3VText.setTextColor(savedInstanceState.getInt("q3VColor"));
        q4VText.setText(savedInstanceState.getString("q4VText"));
        q4VText.setTextColor(savedInstanceState.getInt("q4VColor"));
        q5VText.setText(savedInstanceState.getString("q5VText"));
        q5VText.setTextColor(savedInstanceState.getInt("q5VColor"));
        q6VText.setText(savedInstanceState.getString("q6VText"));
        q6VText.setTextColor(savedInstanceState.getInt("q6VColor"));
        q7VText.setText(savedInstanceState.getString("q7VText"));
        q7VText.setTextColor(savedInstanceState.getInt("q7VColor"));
    }


// The following method is used to calculate the score by checking the answer fields

    public void calculateScore(View view) {

        // A variable containing the score is initialized
        int score = 0;

        // We initialize variables that are containing the answers chosen by the player

        boolean checkAnswer1 = Answer1.isChecked();
        String checkAnswer2 = Answer2.getText().toString().toUpperCase();
        String checkAnswer4 = Answer4.getText().toString().toUpperCase();
        boolean checkAnswer3e1 = Answer3e1.isChecked();
        boolean checkAnswer3e2 = Answer3e2.isChecked();
        boolean checkAnswer3f1 = Answer3f1.isChecked();
        boolean checkAnswer3f2 = Answer3f2.isChecked();
        boolean checkAnswer5 = Answer5.isChecked();
        String checkAnswer6 = Answer6.getText().toString().toUpperCase();
        boolean checkAnswer7 = Answer7.isChecked();


        // And then we check if the anwsers are right or wrong using simple if/else conditions.
        // If the answer is true, one point is scored and a green text is displayed under the question.
        // If the answer is wrong, no points are scored and a red text is displayed under the question.
        if (checkAnswer1) {
            score += 1;
            q1VText.setText(getResources().getText(R.string.right));
            q1VText.setTextColor(getResources().getColor(R.color.rightAnswer));

        } else {
            q1VText.setText(getResources().getText(R.string.wrongQ1));
            q1VText.setTextColor(getResources().getColor(R.color.wrongAnswer));
        }

        if (checkAnswer2.contains(getResources().getText(R.string.haendel)) || checkAnswer2.contains(getResources().getText(R.string.handel))) {
            score += 1;
            q2VText.setText(getResources().getText(R.string.right));
            q2VText.setTextColor(getResources().getColor(R.color.rightAnswer));

        } else {
            q2VText.setText(getResources().getText(R.string.wrongQ2));
            q2VText.setTextColor(getResources().getColor(R.color.wrongAnswer));
        }

        if (checkAnswer3e1 && checkAnswer3e2 && checkAnswer3f1 == false && checkAnswer3f2 == false) {
            score += 1;
            q3VText.setText(R.string.right);
            q3VText.setTextColor(getResources().getColor(R.color.rightAnswer));
        } else {
            q3VText.setText(R.string.wrongQ3);
            q3VText.setTextColor(getResources().getColor(R.color.wrongAnswer));
        }

        if (checkAnswer4.contains(getResources().getText(R.string.norma)) && checkAnswer4.contains(getResources().getText(R.string.bellini))) {
            score += 1;
            q4VText.setText(getResources().getText(R.string.right));
            q4VText.setTextColor(getResources().getColor(R.color.rightAnswer));

        } else {
            q4VText.setText(getResources().getText(R.string.wrongQ4));
            q4VText.setTextColor(getResources().getColor(R.color.wrongAnswer));
        }

        if (checkAnswer5) {
            score += 1;
            q5VText.setText(getResources().getText(R.string.right));
            q5VText.setTextColor(getResources().getColor(R.color.rightAnswer));

        } else {
            q5VText.setText(getResources().getText(R.string.wrongQ5));
            q5VText.setTextColor(getResources().getColor(R.color.wrongAnswer));
        }

        if (checkAnswer6.contains(getResources().getText(R.string.carmen))) {
            score += 1;
            q6VText.setText(getResources().getText(R.string.right));
            q6VText.setTextColor(getResources().getColor(R.color.rightAnswer));

        } else {
            q6VText.setText(getResources().getText(R.string.wrongQ6));
            q6VText.setTextColor(getResources().getColor(R.color.wrongAnswer));
        }

        if (checkAnswer7) {
            score += 1;
            q7VText.setText(getResources().getText(R.string.right));
            q7VText.setTextColor(getResources().getColor(R.color.rightAnswer));

        } else {
            q7VText.setText(getResources().getText(R.string.wrongQ7));
            q7VText.setTextColor(getResources().getColor(R.color.wrongAnswer));
        }

// Eventually we display a long test message showing score
        String message;

        if (score == 0) {

            message = "Sorry " + nameView.getText().toString() + " ! You scored no points this time ! You may now see infos about your wrong answers. " ;
        } else {
            message = "Good Job " + nameView.getText().toString() + " ! You scored " + score + " points. You may now see infos about your wrong answers. " ;

        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show();


    }
        // Method used to display the video extract from question 4, it's actually a youtube intent
    public void playExtract(View view) {

        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=yiGpm56Bi8s")));
    }


}


