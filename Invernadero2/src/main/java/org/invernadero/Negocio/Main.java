package org.invernadero.Negocio;

import org.invernadero.Negocio.Dominio.SensorHumedad;
import org.invernadero.Negocio.Servicio.CtrlSensorHumedad;
import org.invernadero.Persistencia.RegistroAlarmas;
import org.invernadero.Persistencia.SensorHumedadDAO;

public class Main {
    public static void main(String[] args) {
        //Se crea un sensor.
        SensorHumedad sensorHumedad1 = new SensorHumedad("Kawasaki", 19.3f);
        SensorHumedad sensorHumedad2 = new SensorHumedad("ASK", 25.3f);
        SensorHumedad sensorHumedad3 = new SensorHumedad("ARS", 16.2f);

        //Se guarda el sensor.
        SensorHumedadDAO sensorHumedadDAO = new SensorHumedadDAO();
        SensorHumedadDAO sensor2 = new SensorHumedadDAO();
        sensorHumedadDAO.guardarSensorHumedad(sensorHumedad1);
        sensorHumedadDAO.guardarSensorHumedad(sensorHumedad2);
        sensorHumedadDAO.guardarSensorHumedad(sensorHumedad3);

        //Se crea una simulacion.
        CtrlSensorHumedad sensorHumedadControlador = new CtrlSensorHumedad();
        sensorHumedad1.setHumedad(20f);
        sensorHumedad2.setHumedad(26f);
        sensorHumedad3.setHumedad(12f);

        //Aqui es donde llegaria el dato desde el gateway.
        sensorHumedadControlador.humedadAlta(sensorHumedad1);
        sensorHumedadControlador.humedadAlta(sensorHumedad2);
        sensorHumedadControlador.humedadAlta(sensorHumedad3);

        //Se busca el registro de alarmas.
        RegistroAlarmas registroAlarmas = new RegistroAlarmas();
        registroAlarmas.getListaAlarmasHumedad().forEach(System.out::println);
        System.out.println("------------------------------------------------------------");
        //Se muestran todos los sensores.
        sensorHumedadDAO.getListaSensoresHumedad().forEach(System.out::println);
    }
}
