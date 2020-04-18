package pl.michaloruba.trafficlights;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView redLight;
    ImageView yellowLight;
    ImageView greenLight;
    Button redBtn;
    Button yellowBtn;
    Button greenBtn;
    TrafficLight trafficLight = new TrafficLight();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        redLight = findViewById(R.id.redImageView);
        yellowLight = findViewById(R.id.yellowImageView);
        greenLight = findViewById(R.id.greenImageView);
        redBtn = findViewById(R.id.redBtn);
        yellowBtn = findViewById(R.id.yellowBtn);
        greenBtn = findViewById(R.id.greenBtn);

        redBtn.setOnClickListener(this);
        yellowBtn.setOnClickListener(this);
        greenBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (buttonIsClicked(v)){
            lightChangeHandler(v);
        }
    }

    private boolean buttonIsClicked(View v) {
        return v.getId() == R.id.redBtn || v.getId() == R.id.yellowBtn || v.getId() == R.id.greenBtn;
    }

    private void lightChangeHandler(View v) {
        trafficLight.validateLights(v);
        changeLights();
    }

    private void changeLights() {
        int currentLight = 0;
        for (boolean lightStatus : trafficLight.getStatusRedYellowGreen()){
                switch (currentLight){
                    case 0: {
                        switchRedImage(lightStatus);
                        break;
                    }
                    case 1: {
                        switchYellowImage(lightStatus);
                        break;
                    }
                    case 2: {
                        switchGreenImage(lightStatus);
                        break;
                    }
                }
            currentLight++;
        }
    }

    private void switchRedImage(boolean lightStatus) {
        if (lightStatus){
            redLight.setImageResource(R.drawable.red_on);
        }
        else {
            redLight.setImageResource(R.drawable.light_off);
        }
    }

    private void switchYellowImage(boolean lightStatus) {
        if (lightStatus){
            yellowLight.setImageResource(R.drawable.yellow_on);
        }
        else {
            yellowLight.setImageResource(R.drawable.light_off);
        }
    }

    private void switchGreenImage(boolean lightStatus) {
        if (lightStatus){
            greenLight.setImageResource(R.drawable.green_on);
        }
        else {
            greenLight.setImageResource(R.drawable.light_off);
        }
    }
}
