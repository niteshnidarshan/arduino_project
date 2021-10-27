package in.sysventure.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class KilogramToPoundActivity extends AppCompatActivity {

    private final static double POUND_VALUE = 2.20462262185;
    private Button home, buttonSubmit;
    private EditText editTextKgValue;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kilogram_to_pound);
        home = findViewById(R.id.buttonKgPoundHome);
        editTextKgValue = findViewById(R.id.editTextKgValue);
        buttonSubmit = findViewById(R.id.buttonSubmit);
        result = findViewById(R.id.textViewResult);

        /*
            This method uses OnClickListener() event call

            onClick Attribute:
            ------------------------
            Another way of button onClick is onClickAttribute

            Steps to use onClickAttribute:
            1) Define a method like calculatePound()
                View will be always a default parameter to this attribute method
            2) Go to button definition in xml & use below attribute:
                android:onClick="calculatePound"
         */
       /* buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(editTextKgValue.getText().toString().trim().length() <= 0){
                    editTextKgValue.setError("Enter Value in Kilogram(kg)");
                }else{
                    double kg = Double.parseDouble(editTextKgValue.getText().toString());
                    double poundResult = kg*POUND_VALUE;
                    result.setText(String.valueOf(poundResult)+" lbs");
                }
            }
        });
*/
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(KilogramToPoundActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    /*
    * onClickAttribute:
            ------------------------
            Another way of button onClick is onClickAttribute

            Steps to use onClickAttribute:
            1) Define a method like calculatePound()
                View will be always a default parameter to this attribute method
            2) Go to button definition in xml & use below attribute:
                android:onClick="calculatePound"
    * */
    public void calculatePound(View view) {

        if(editTextKgValue.getText().toString().trim().length() <= 0){
            editTextKgValue.setError("Enter Value in Kilogram(kg)");
        }else{
            double kg = Double.parseDouble(editTextKgValue.getText().toString());
            double poundResult = kg*POUND_VALUE;
            result.setText(String.valueOf(poundResult)+" lbs");

            //Toast is used to some message on screen for a while - will disappear within a few seconds.
            Toast.makeText(this, "Thanks for using Unit Converter", Toast.LENGTH_SHORT).show();
        }

    }
}