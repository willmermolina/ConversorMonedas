package com.willmer.convertidor.calculos;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.willmer.convertidor.modelos.CambioPar;
import com.willmer.convertidor.modelos.Divisa;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDivisa {
    public Divisa calculaDivisa(String baseCode, String targetCode, double monto){
        String direccion = "https://v6.exchangerate-api.com/v6/92ada4bf01e89a44e263354e/pair/"+baseCode+"/"+targetCode+"/"+monto;
        Gson gson= new GsonBuilder()
                .setPrettyPrinting()
                .create();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();
            //hacer un response ********************
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();
            //System.out.println(json);
            CambioPar cambioDivisa = gson.fromJson(json, CambioPar.class);
            Divisa divisaConvertida = new Divisa(cambioDivisa);
            return divisaConvertida;
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

}

