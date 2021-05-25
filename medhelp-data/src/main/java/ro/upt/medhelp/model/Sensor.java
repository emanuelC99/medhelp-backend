package ro.upt.medhelp.model;

import java.time.LocalDate;

public class Sensor {

    private Long bloodPressureDiastolic;
    private Long bloodPressureSystolic;
    private Long pulse;
    private Long bodyTemperature;
    private Long bodyWeight;
    private Long glycemia;
    private Long light;
    private Long ambientTemperature;
    private Long gas;
    private Long humidity;
    private Long proximity;
    private LocalDate date;

    public Sensor() {
    }

    public Sensor(Long bloodPressureDiastolic, Long bloodPressureSystolic, Long pulse, Long bodyTemperature, Long bodyWeight, Long glycemia, Long light, Long ambientTemperature, Long gas, Long humidity, Long proximity, LocalDate date) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
        this.bloodPressureSystolic = bloodPressureSystolic;
        this.pulse = pulse;
        this.bodyTemperature = bodyTemperature;
        this.bodyWeight = bodyWeight;
        this.glycemia = glycemia;
        this.light = light;
        this.ambientTemperature = ambientTemperature;
        this.gas = gas;
        this.humidity = humidity;
        this.proximity = proximity;
        this.date = date;
    }

    public Long getBloodPressureDiastolic() {
        return bloodPressureDiastolic;
    }

    public void setBloodPressureDiastolic(Long bloodPressureDiastolic) {
        this.bloodPressureDiastolic = bloodPressureDiastolic;
    }

    public Long getBloodPressureSystolic() {
        return bloodPressureSystolic;
    }

    public void setBloodPressureSystolic(Long bloodPressureSystolic) {
        this.bloodPressureSystolic = bloodPressureSystolic;
    }

    public Long getPulse() {
        return pulse;
    }

    public void setPulse(Long pulse) {
        this.pulse = pulse;
    }

    public Long getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(Long bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public Long getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(Long bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public Long getGlycemia() {
        return glycemia;
    }

    public void setGlycemia(Long glycemia) {
        this.glycemia = glycemia;
    }

    public Long getLight() {
        return light;
    }

    public void setLight(Long light) {
        this.light = light;
    }

    public Long getAmbientTemperature() {
        return ambientTemperature;
    }

    public void setAmbientTemperature(Long ambientTemperature) {
        this.ambientTemperature = ambientTemperature;
    }

    public Long getGas() {
        return gas;
    }

    public void setGas(Long gas) {
        this.gas = gas;
    }

    public Long getHumidity() {
        return humidity;
    }

    public void setHumidity(Long humidity) {
        this.humidity = humidity;
    }

    public Long getProximity() {
        return proximity;
    }

    public void setProximity(Long proximity) {
        this.proximity = proximity;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
