package ro.upt.medhelp.dao;

import ro.upt.medhelp.model.Sensor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "SENSORS")
@Table(name = "SENSORS")
public class SensorDAO {
    @Id
    @Column(name = "sensorId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sensorId;
    @Column(name = "bloodPressureDiastolic")
    private Long bloodPressureDiastolic;
    @Column(name = "bloodPressureSystolic")
    private Long bloodPressureSystolic;
    @Column(name = "pulse")
    private Long pulse;
    @Column(name = "bodyTemperature")
    private Long bodyTemperature;
    @Column(name = "bodyWeight")
    private Long bodyWeight;
    @Column(name = "glycemia")
    private Long glycemia;
    @Column(name = "light")
    private Long light;
    @Column(name = "ambientTemperature")
    private Long ambientTemperature;
    @Column(name = "gas")
    private Long gas;
    @Column(name = "humidity")
    private Long humidity;
    @Column(name = "proximity")
    private Long proximity;
    @Column(name = "date")
    private LocalDate date;
    @ManyToOne(fetch = FetchType.LAZY)
    private PatientDAO patient;

    public SensorDAO() {

    }

    public SensorDAO(Long sensorId, Long bloodPressureDiastolic, Long bloodPressureSystolic, Long pulse, Long bodyTemperature, Long bodyWeight, Long glycemia, Long light, Long ambientTemperature, Long gas, Long humidity, Long proximity, LocalDate date) {
        this.sensorId = sensorId;
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

    public SensorDAO(Sensor sensor) {
        this.bloodPressureDiastolic = sensor.getBloodPressureDiastolic();
        this.bloodPressureSystolic = sensor.getBloodPressureSystolic();
        this.pulse = sensor.getPulse();
        this.bodyTemperature = sensor.getBodyTemperature();
        this.bodyWeight = sensor.getBodyWeight();
        this.glycemia = sensor.getGlycemia();
        this.light = sensor.getLight();
        this.ambientTemperature = sensor.getAmbientTemperature();
        this.gas = sensor.getGas();
        this.humidity = sensor.getHumidity();
        this.proximity = sensor.getProximity();
        this.date = sensor.getDate();
    }

    public PatientDAO getPatient() {
        return patient;
    }

    public void setPatient(PatientDAO patient) {
        this.patient = patient;
    }

    public Long getSensorId() {
        return sensorId;
    }

    public void setSensorId(Long sensorId) {
        this.sensorId = sensorId;
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
