package pl.michaloruba.trafficlights;


import android.view.View;

public class TrafficLight {
    private Light redLight;
    private Light yellowLight;
    private Light greenLight;

    public TrafficLight() {
        this.redLight = new Light();
        this.yellowLight = new Light();
        this.greenLight = new Light();
        changeRedLight();
    }

    private void changeGreenLight(){
        greenLight.toggleLight();
    }

    private void changeYellowLight(){
        yellowLight.toggleLight();
    }

    private void changeRedLight(){
        redLight.toggleLight();
    }

    public boolean[] getStatusRedYellowGreen(){
        return new boolean[] {redLight.isOn(), yellowLight.isOn(), greenLight.isOn()};
    }

    public void validateLights(View v) {
        boolean [] status = getStatusRedYellowGreen();
        if (isOnlyRedLightOn(status) && isYellowButtonClicked(v)){
            changeYellowLight();
        }
        if (isOnlyRedAndYellowLightOn(status) && isGreenButtonClicked(v)){
            changeRedLight();
            changeYellowLight();
            changeGreenLight();
        }
        if (isOnlyGreenLightOn(status) && isYellowButtonClicked(v)){
            changeYellowLight();
            changeGreenLight();
        }
        if (isOnlyYellowLightOn(status) && isRedButtonClicked(v)){
            changeRedLight();
            changeYellowLight();
        }
    }

    private boolean isOnlyRedLightOn(boolean[] status) {
        return status[0] && !status[1] && !status[2];
    }

    private boolean isYellowButtonClicked(View v) {
        return v.getId() == R.id.yellowBtn;
    }

    private boolean isOnlyRedAndYellowLightOn(boolean[] status) {
        return status[0] && status[1] && !status[2];
    }

    private boolean isGreenButtonClicked(View v) {
        return v.getId() == R.id.greenBtn;
    }

    private boolean isOnlyGreenLightOn(boolean[] status) {
        return !status[0] && !status[1] && status[2];
    }

    private boolean isOnlyYellowLightOn(boolean[] status) {
        return !status[0] && status[1] && !status[2];
    }

    private boolean isRedButtonClicked(View v) {
        return v.getId() == R.id.redBtn;
    }

}
