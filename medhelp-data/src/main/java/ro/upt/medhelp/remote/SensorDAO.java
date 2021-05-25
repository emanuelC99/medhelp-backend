package ro.upt.medhelp.remote;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "sensor")
@Table(schema="sql11414385",name="sensor")
public class SensorDAO {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "pir")
    private Integer proximity;
    @Column(name = "gaz")
    private Integer gas;
    @Column(name = "puls")
    private Integer pulse;
    @Column(name = "lumina")
    private Integer light;
    @Column(name = "umiditate")
    private Integer humidity;
    @Column(name = "temperatura")
    private Integer Temperature;

    public SensorDAO() {

    }

    public SensorDAO(Integer id, Integer proximity, Integer gas, Integer pulse, Integer light, Integer humidity, Integer temperature) {
        this.id = id;
        this.proximity = proximity;
        this.gas = gas;
        this.pulse = pulse;
        this.light = light;
        this.humidity = humidity;
        Temperature = temperature;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProximity() {
        return proximity;
    }

    public void setProximity(Integer proximity) {
        this.proximity = proximity;
    }

    public Integer getGas() {
        return gas;
    }

    public void setGas(Integer gas) {
        this.gas = gas;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public Integer getLight() {
        return light;
    }

    public void setLight(Integer light) {
        this.light = light;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Integer getTemperature() {
        return Temperature;
    }

    public void setTemperature(Integer temperature) {
        Temperature = temperature;
    }
}
