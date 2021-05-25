package ro.upt.medhelp.remote;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.upt.medhelp.model.Sensor;

import java.util.List;

@Service
public class SensorService {

    private SensorRepository sensorRepository;

    @Autowired
    public SensorService(SensorRepository sensorRepository) {
        this.sensorRepository = sensorRepository;
    }

    @Transactional("remoteTransactionManager")
    public Sensor addData(Long userId, Sensor sensor) {
        return null;
    }

    public List<SensorDAO> findValue(String date) {

        return sensorRepository.findAll();
    }

    public void deleteSensorData(String date) {

    }

    public Sensor updateSensorData(String date, Sensor sensor) {
        return null;
    }

}
