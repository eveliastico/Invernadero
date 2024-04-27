package org.invernadero.Persistencia;

import org.invernadero.Negocio.Dominio.SensorTemperatura;

import java.util.ArrayList;
import java.util.List;

public class SensorTemperaturaDAO {
    private static List<SensorTemperatura> listaSensoresTemperatura = new ArrayList<>();

    public SensorTemperaturaDAO(){
    }

    public void guardarSensorTemperatura(SensorTemperatura sensorTemperatura){
        listaSensoresTemperatura.add(sensorTemperatura);
    }

    public List<SensorTemperatura> getListaSensoresTemperatura() {
        return listaSensoresTemperatura;
    }
}
