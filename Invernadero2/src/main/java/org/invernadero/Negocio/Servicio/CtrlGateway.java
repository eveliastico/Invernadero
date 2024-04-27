package org.invernadero.Negocio.Servicio;

import com.google.gson.Gson;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import org.apache.cassandra.streaming.StreamOut;
import org.invernadero.Negocio.Dominio.SensorHumedad;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class CtrlGateway {
    private final static String QUEUE_NAME = "ColaDatos";
    private final static String NEW_QUEUE_NAME = "servicio";

    public static void main(String[] args) throws Exception{

        Gson gson = new Gson();

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);
        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        Channel newChannel = connection.createChannel();
        newChannel.queueDeclare(NEW_QUEUE_NAME, false, false, false, null);

        System.out.println("Entre");
        DeliverCallback deliverCallback = (consumerTag, delivery) -> {
            System.out.println("ENTRE");
            String message = new String(delivery.getBody(), StandardCharsets.UTF_8);
            SensorHumedad sensorHumedad1 = gson.fromJson(message, SensorHumedad.class);

            System.out.println(sensorHumedad1.toString());

            newChannel.basicPublish("", NEW_QUEUE_NAME, null, message.getBytes());
        };
        channel.basicConsume(QUEUE_NAME, true, deliverCallback, consumerTag -> { });

    }

    private static List<?> listaDatosSensores = new ArrayList<>();

    public CtrlGateway(){
    }

    public void colaDeDatos(){

    }

    public void enviarDatoServidor(){

    }


}
