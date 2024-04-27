package org.invernadero.Negocio.Dominio;

public class SensorTemperatura {
    private int id;
    private float humedad;
    private float temperatura;
    private String marca;

    public SensorTemperatura(){

    }

    public SensorTemperatura(float temperatura, String marca, TipoSensor tipoSensor) {
        this.humedad = humedad;
        this.temperatura = temperatura;
        this.marca = marca;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }

    public float getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
}
