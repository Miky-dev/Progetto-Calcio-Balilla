package it.upo.pissir;

import org.eclipse.paho.client.mqttv3.*;

public class Publisher {

    private static final String BROKER = "tcp://localhost:1883";
    private static final String TOPIC  = "cgp/foosball/events/goal/A";
    private static final String CLIENT_ID = "publisher-goal-a";

    public static void main(String[] args) throws MqttException, InterruptedException {
        MqttClient client = new MqttClient(BROKER, CLIENT_ID);

        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setWill(TOPIC + "/LWT", "offline".getBytes(), 0, false);

        client.connect(options);
        System.out.println("Publisher connesso al broker.");

        int score = 0;
        while (score < 3) {
            score++;
            String payload = "{\"team\":\"A\", \"score\":" + score + "}";
            MqttMessage msg = new MqttMessage(payload.getBytes());
            client.publish(TOPIC, msg);
            System.out.println("Pubblicato: " + payload);
            Thread.sleep(2000);
        }

        client.disconnect();
        System.out.println("Publisher disconnesso.");
    }
}