package it.upo.pissir;

import org.eclipse.paho.client.mqttv3.*;

public class Subscriber {

    private static final String BROKER    = "tcp://localhost:1883";
    private static final String TOPIC     = "cgp/#";
    private static final String CLIENT_ID = "subscriber-backend";

    public static void main(String[] args) throws MqttException {
        MqttClient client = new MqttClient(BROKER, CLIENT_ID);

        client.setCallback(new SubscribeCallback());
        client.connect();

        client.subscribe(TOPIC);
        System.out.println("Subscriber in ascolto su: " + TOPIC);

        // rimane in ascolto indefinitamente
        while (true) {
            try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
        }
    }
}