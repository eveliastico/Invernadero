package org.invernadero.Negocio.Servicio;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.invernadero.Negocio.Dominio.SensorHumedad;
import org.invernadero.Persistencia.RegistroAlarmas;

import java.nio.charset.StandardCharsets;

public class CtrlSensorHumedad {

    private int id;
    public static SensorHumedad sensorHumedad1;
    public RegistroAlarmas registroAlarmas;

    private final static String NEW_QUEUE_NAME = "servicio";

    public CtrlSensorHumedad() {
        registroAlarmas = new RegistroAlarmas();
    }

    public static void main(String[] args) throws Exception{
        Gson gson = new Gson();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(NEW_QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            sensorHumedad1 = gson.fromJson(message, SensorHumedad.class);

            System.out.println(sensorHumedad1.toString());
            CtrlSensorHumedad ctrlSensorHumedad = new CtrlSensorHumedad();
            ctrlSensorHumedad.humedadAlta(sensorHumedad1);
        };
        channel.basicConsume(NEW_QUEUE_NAME, true, deliverCallback, consumerTag -> { });

    }

    public void humedadAlta(SensorHumedad sensorHumedad1){
        if(sensorHumedad1.getHumedad() >= sensorHumedad1.getHumedadMaxima()){
            generarAlarma(sensorHumedad1);
        }
    }

    public void generarAlarma(SensorHumedad sensor){
        System.out.println("HUMEDAD ALTA: "+sensor.getHumedad());
        registroAlarmas.guardarRegistroHumedad(sensor);

    }

    public void mostrarAlarmaPorPantall(){

    }


}
