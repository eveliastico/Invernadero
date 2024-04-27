package org.invernadero.Negocio.Dominio;

public class SensorHumedad {
    private static int contador = 0;
    public int id = 0;
    private float humedad;
    private String marca;

    private float humedadMaxima;

    public SensorHumedad(String marca, float humedadMaxima) {
        this.id = ++contador;
        this.marca = marca;
        this.humedadMaxima = humedadMaxima;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getHumedad() {
        return humedad;
    }

    public void setHumedad(float humedad) {
        this.humedad = humedad;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getHumedadMaxima() {
        return humedadMaxima;
    }

    public void setHumedadMaxima(float humedadMaxima) {
        this.humedadMaxima = humedadMaxima;
    }

    @Override
    public String toString() {
        return "SensorHumedad{" +
                "id=" + id +
                ", humedad=" + humedad +
                ", marca='" + marca + '\'' +
                ", humedadMaxima=" + humedadMaxima +
                '}';
    }
}
