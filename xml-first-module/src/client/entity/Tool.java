package client.entity;

import client.enums.Handy;

public class Tool {
    private String model;
    private Handy handy;
    private String origin;
    private Characteristic tc;
    private String material;

    public Tool() {
    }

    public Tool(String model, Handy handy, String origin, Characteristic tc, String material) {
        this.model = model;
        this.handy = handy;
        this.origin = origin;
        this.tc = tc;
        this.material = material;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Handy getHandy() {
        return handy;
    }

    public void setHandy(Handy handy) {
        this.handy = handy;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Characteristic getTc() {
        return tc;
    }

    public void setTc(Characteristic tc) {
        this.tc = tc;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "PowerTool{" +
                "model='" + model + '\'' +
                ", handy=" + handy +
                ", origin='" + origin + '\'' +
                ", tc=" + tc +
                ", material='" + material + '\'' +
                '}';
    }
}
