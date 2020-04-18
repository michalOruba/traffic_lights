package pl.michaloruba.trafficlights;

public class Light {

    private boolean isOn = false;

    public boolean isOn() {
        return isOn;
    }

    public void toggleLight() {
        isOn = !isOn;
    }
}
