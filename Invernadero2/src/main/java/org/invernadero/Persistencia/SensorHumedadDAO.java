package org.invernadero.Persistencia;

import org.invernadero.Negocio.Dominio.SensorHumedad;

import java.util.ArrayList;
import java.util.List;

public class SensorHumedadDAO {
    private static List<SensorHumedad> listaSensoresHumedad = new ArrayList<>();

    public SensorHumedadDAO(){
    }

    public void guardarSensorHumedad(SensorHumedad sensor){
        listaSensoresHumedad.add(sensor);
    }

    public List<SensorHumedad> getListaSensoresHumedad() {
        return listaSensoresHumedad;
    }
}
