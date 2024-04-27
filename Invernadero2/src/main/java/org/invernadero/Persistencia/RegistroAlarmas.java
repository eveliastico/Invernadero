package org.invernadero.Persistencia;

import org.invernadero.Negocio.Dominio.SensorHumedad;
import org.invernadero.Negocio.Dominio.SensorTemperatura;

import java.util.ArrayList;
import java.util.List;

public class RegistroAlarmas {
    private static List<SensorHumedad> listaAlarmasHumedad = new ArrayList<>();
    private static List<SensorTemperatura> listaAlarmasTemperatura = new ArrayList<>();

    public RegistroAlarmas(){
    }

    public void guardarRegistroHumedad(SensorHumedad sensorHumedad){
        listaAlarmasHumedad.add(sensorHumedad);
    }

    public void guardarRegistroTemperatura(SensorTemperatura sensorTemperatura){
        listaAlarmasTemperatura.add(sensorTemperatura);
    }

    public List<SensorHumedad> getListaAlarmasHumedad() {
        return listaAlarmasHumedad;
    }

    public List<SensorTemperatura> getListaAlarmasTemperatura() {
        return listaAlarmasTemperatura;
    }
}
