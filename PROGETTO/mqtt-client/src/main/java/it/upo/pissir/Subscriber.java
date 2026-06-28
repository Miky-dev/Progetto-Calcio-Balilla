package it.upo.pissir;

import org.eclipse.paho.client.mqttv3.*;

public class Subscriber {

    private static final String BROKER    = "tcp://localhost:1883";
    private static final String TOPIC     = "cgp/#";
    private static final String CLIENT_ID = "subscriber-backend";

    public static void main(String[] args) throws MqttException {
        MqttClient client = new MqttClient(BROKER, CLIENT_ID);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setUserName("backend_service");
        options.setPassword("@Miky2004".toCharArray());

        client.setCallback(new SubscribeCallback());
        client.connect(options);

        client.subscribe(TOPIC);
        System.out.println("Subscriber in ascolto su: " + TOPIC);

        while (true) {
            try { Thread.sleep(1000); } catch (InterruptedException e) { break; }
        }
    }
}