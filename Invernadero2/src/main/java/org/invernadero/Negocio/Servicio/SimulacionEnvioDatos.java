package org.invernadero.Negocio.Servicio;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.invernadero.Negocio.Dominio.SensorHumedad;

import java.nio.charset.StandardCharsets;

public class SimulacionEnvioDatos {
    private final static String QUEUE_NAME = "ColaDatos";

    public static void main(String[] argv) throws Exception {

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");

        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            SensorHumedad sensorHumedad1 = new SensorHumedad("Kawasaki", 19.3f);
            sensorHumedad1.setHumedad(20f);
            Gson gson = new Gson();

            String message = gson.toJson(sensorHumedad1);

            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println(" [x] Sent '" + message + "'");
        }

        /*ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        try (Connection connection = factory.newConnection();
             Channel channel = connection.createChannel()) {
            channel.queueDeclare(QUEUE_NAME, false, false, false, null);

            SensorHumedad sensorHumedad1 = new SensorHumedad("Kawasaki", 19.3f);
            /*SensorHumedad sensorHumedad2 = new SensorHumedad("ASK", 25.3f);
            SensorHumedad sensorHumedad3 = new SensorHumedad("ARS", 16.2f);

            Gson gson = new Gson();

            String message = gson.toJson(sensorHumedad1);
            System.out.println(sensorHumedad1.toString());
            channel.basicPublish("", QUEUE_NAME, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Dato Enviado...");
            */

    }
}
