package edu.eci.arep.sparkwebapp;


import okhttp3.*;

import java.io.IOException;


public class HTTPClient {

    private OkHttpClient httpClient;
    private String baseUrl="http://192.168.206.129";
    private String[] ports={":8087",":8088",":8089"};
    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    private int serverNumber=0;

    public HTTPClient(){
        httpClient=new OkHttpClient();
    }

    public String getMessages(String path) throws IOException {
        Request request = request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .get()
                .build();
        System.out.println("Request enviado a nodo "+baseUrl+ports[serverNumber]+path);
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public String postMessage(String message,String path) throws IOException {
        RequestBody body = RequestBody.create(message,JSON);
        Request request = new Request.Builder()
                .url(baseUrl+ports[serverNumber]+path)
                .post(body)
                .build();
        System.out.println("Sending POST to node: "+baseUrl+ports[serverNumber]+path);
        Response response = httpClient.newCall(request).execute();
        return response.body().string();
    }

    public void roundRobin(){
        this.serverNumber=(this.serverNumber+1)% ports.length;
    }
}