package it.upo.pissir; //prova

import org.eclipse.paho.client.mqttv3.*;

public class SubscribeCallback implements MqttCallback {

    @Override
    public void connectionLost(Throwable cause) {
        System.out.println("Connessione persa: " + cause.getMessage());
    }

    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        System.out.println("Messaggio ricevuto - Topic: " + topic + " | Payload: " + message.toString());
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        System.out.println("Messaggio consegnato.");
    }
}