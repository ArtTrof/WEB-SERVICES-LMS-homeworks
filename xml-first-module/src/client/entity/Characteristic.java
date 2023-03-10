package client.entity;

import client.enums.PowerConsumption;

public class Characteristic {
    private PowerConsumption powerConsumption;
    private int productivity;
    private boolean autonomy;

    public Characteristic() {
    }

    public Characteristic(PowerConsumption powerConsumption, int productivity, boolean autonomy) {
        this.powerConsumption = powerConsumption;
        this.productivity = productivity;
        this.autonomy = autonomy;
    }

    public PowerConsumption getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(PowerConsumption powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
        this.productivity = productivity;
    }

    public boolean isAutonomy() {
        return autonomy;
    }

    public void setAutonomy(boolean autonomy) {
        this.autonomy = autonomy;
    }

    @Override
    public String toString() {
        return "TechnicalCharacteristic{" +
                "powerConsumption=" + powerConsumption +
                ", productivity=" + productivity +
                ", autonomy=" + autonomy +
                '}';
    }
}
